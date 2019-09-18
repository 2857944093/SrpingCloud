package com.czk.product.service.impl;

import com.czk.product.dataobject.ProductInfo;
import com.czk.product.dto.CartDTO;
import com.czk.product.enums.ResultEnum;
import com.czk.product.execption.ProductExecption;
import com.czk.product.repository.ProductInfoRepository;
import com.czk.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * FileName: ProductInfoServiceImpl
 * Author:   ChenZK
 * Date:     2019/9/1 16:23
 * Description:
 * History:
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> fingByProductInfoStatus(Integer saatus) {
        return productInfoRepository.findAllBy();
    }

    @Override
    public List<ProductInfo> findAll() {
        return productInfoRepository.findAllBy();
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO : cartDTOList){
             Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(cartDTO.getProductId());
             //商品是否存在
             if(!productInfoOptional.isPresent()){
                 throw new ProductExecption(ResultEnum.PRODUCT_NOT_EXIT);
             }
             ProductInfo productInfo = productInfoOptional.get();
             Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
             if(result < 0){
                 throw new ProductExecption(ResultEnum.PRODUCT_STOCK_ERROR);
             }

             productInfo.setProductStock(result);
             productInfoRepository.save(productInfo);
        }
    }
}
