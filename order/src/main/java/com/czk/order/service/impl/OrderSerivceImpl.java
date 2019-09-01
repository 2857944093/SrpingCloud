package com.czk.order.service.impl;

import com.czk.order.dataobject.OrderMaster;
import com.czk.order.dto.OrderDTO;
import com.czk.order.enums.OrderStatusEnum;
import com.czk.order.enums.PayStatusEnum;
import com.czk.order.repository.OrderDetailRepository;
import com.czk.order.repository.OrderMasterRepository;
import com.czk.order.service.OrderService;
import com.czk.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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

    @Override
    public OrderDTO create(OrderDTO orderDTO) {


        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
