package com.czk.order.server.service;

import com.czk.order.server.dto.OrderDTO;

/**
 * FileName: OrderService
 * Author:   ChenZK
 * Date:     2019/9/1 18:05
 * Description:
 * History:
 */
public interface OrderService {

    OrderDTO create(OrderDTO orderDTO);
}
