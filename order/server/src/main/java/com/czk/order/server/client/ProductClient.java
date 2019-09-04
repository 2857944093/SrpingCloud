package com.czk.order.server.client;

import com.czk.order.server.dataobject.ProductInfo;
import com.czk.order.server.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * FileName: ProductClient
 * Author:   ChenZK
 * Date:     2019/9/2 21:09
 * Description:
 * History:
 */
@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();

    @PostMapping("/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);
}
