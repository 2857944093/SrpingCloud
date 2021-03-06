package com.czk.order.server.controller;


import com.czk.product.client.ProductClient;
import com.czk.product.common.DecreaseStockInput;
import com.czk.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private ProductClient productClient;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("getProductMsg")
    public String getProductMsg() {
        //restTemplate
        // 第一种方式(路徑寫死)
       /* RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://localhost:8080/msg",String.class);*/

        //第二种方式（利用LoadBalancerClien获取url，然后再试一下restTemplate）
       /* ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort()+"/msg");
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url,String.class);*/

        //第三种方式
        //String response = restTemplate.getForObject("http://PRODUCT/msg",String.class);

        //Fegin
        /*String response = productClient.productMsg();
        log.info("response={} ",response);
        return response;*/
        return "ok";
    }

    @GetMapping("/getProductList")
    public String getProductList(){
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(Arrays.asList("1"));
        log.info("response={}", productInfoList);
        return "ok";
    }

    @GetMapping("/productDecreaseStock")
    public String productDecreaseStock(){
        productClient.decreaseStock(Arrays.asList(new DecreaseStockInput("1",3)));
        log.info("response={}", "ok");
        return "ok";
    }
}
