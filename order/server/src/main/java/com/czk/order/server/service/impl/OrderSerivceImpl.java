package com.czk.order.server.service.impl;

import com.czk.order.repository.OrderDetailRepository;
import com.czk.order.repository.OrderMasterRepository;
import com.czk.order.server.client.ProductClient;
import com.czk.order.server.dataobject.OrderDetail;
import com.czk.order.server.dataobject.OrderMaster;
import com.czk.order.server.dataobject.ProductInfo;
import com.czk.order.server.dto.CartDTO;
import com.czk.order.server.dto.OrderDTO;
import com.czk.order.server.enums.OrderStatusEnum;
import com.czk.order.server.enums.PayStatusEnum;
import com.czk.order.server.utils.KeyUtil;
import com.czk.order.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * FileName: OrderSerivceImpl
 * Author:   ChenZK
 * Date:     2019/9/1 18:06
 * Description:
 * History:
 */
@Service
public class OrderSerivceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private ProductClient productClient;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();

        //查询商品信息（调用商品服务）
        List<String> productIdList = orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfo> productInfoList = productClient.listForOrder(Arrays.asList("1"));

        //计算总价
        BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()){
            for (ProductInfo productInfo : productInfoList){
                if (productInfo.getProductId().equals(orderDetail.getProductId())){
                    //单价*数量
                    orderAmout = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmout);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setProductId(KeyUtil.genUniqueKey());
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    //订单详情入库
                    orderDetailRepository.save(orderDetail);
                }
            }

        }
        //扣库存（调用商品服务）
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e-> new CartDTO(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);

        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmout);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
