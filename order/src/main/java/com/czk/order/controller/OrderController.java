package com.czk.order.controller;

import com.czk.order.VO.ResultVo;
import com.czk.order.VO.ResultVoUtil;
import com.czk.order.converter.OrderFormToOrderDTO;
import com.czk.order.dto.OrderDTO;
import com.czk.order.enums.ResultEnum;
import com.czk.order.exception.OrderException;
import com.czk.order.form.OrderForm;
import com.czk.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResultVo<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            log.error(" 【创建订单】参数不正确, orderForm={}", orderForm);
            throw new OrderException(1, bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderFormToOrderDTO.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error(" 【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }
        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderid",orderDTO.getOrderId());
        return ResultVoUtil.success(map);
    }
}
