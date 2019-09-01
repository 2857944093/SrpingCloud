package com.czk.product.controller;

import com.czk.product.VO.ProductInfoVO;
import com.czk.product.VO.ProductVO;
import com.czk.product.VO.ResultVO;
import com.czk.product.dataobject.ProductCategory;
import com.czk.product.dataobject.ProductInfo;
import com.czk.product.service.ProductCategoryService;
import com.czk.product.service.ProductInfoService;
import com.czk.product.utils.ResultVoUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class ProductInfoCtl {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    public ResultVO<ProductVO> list(){
        List<ProductInfo> productInfoList = productInfoService.findAll();
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        List<ProductCategory> productCategories = productCategoryService.findByType(categoryTypeList);

        List<ProductVO> productVOS = new ArrayList<>();
        for (ProductCategory productCategory : productCategories) {
            ProductVO p = new ProductVO();
            p.setCategoryName(productCategory.getCategoryName());
            p.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOS = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOS.add(productInfoVO);
                }
            }
            p.setProductInfoVOList(productInfoVOS);
            productVOS.add(p);
        }

        return ResultVoUtil.success(productVOS);
    }

}