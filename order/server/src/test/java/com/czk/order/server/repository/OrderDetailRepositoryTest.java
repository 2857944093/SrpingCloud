package com.czk.order.server.repository;


import com.czk.order.server.OrderApplicationTests;
import com.czk.order.server.dataobject.OrderDetail;
import com.czk.order.server.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testOrderMasterRepositorySave(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1");
        orderMaster.setBuyerAddress("中國");
        orderMaster.setBuyerName("張三");
        orderMaster.setBuyerOpenid("1212122");
        orderMaster.setBuyerPhone("12345678901");
        orderMaster.setUpdateTime(new Date());
        orderMaster.setCreateTime(new Date());
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(1);
        orderMaster.setPayStatus(1);

        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result != null);
    }

    @Test
    public void testOrderDetailRepositorySave(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1");
        orderDetail.setOrderId("1");
        orderDetail.setProductIcon("xxxxx");
        orderDetail.setProductName("水果");
        orderDetail.setProductPrice(new BigDecimal(3));
        orderDetail.setProductId("1");
        orderDetail.setProductQuantity(1);
        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertTrue(result != null);
    }
}