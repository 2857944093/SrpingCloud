package com.czk.order.server.converter;

import com.czk.order.server.dataobject.OrderDetail;
import com.czk.order.server.dto.OrderDTO;
import com.czk.order.server.enums.ResultEnum;
import com.czk.order.server.exception.OrderException;
import com.czk.order.server.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: OrderFormToOrderDTO
 * Author:   ChenZK
 * Date:     2019/9/1 18:31
 * Description:
 * History:
 */
@Slf4j
public class OrderFormToOrderDTO {
    public static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getPhone());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (Exception e) {
            log.error("【json转换】错误，string={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
