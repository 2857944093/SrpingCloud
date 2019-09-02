package com.czk.product.repository;


import com.czk.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findAllBy();

    List<ProductInfo> findByCategoryType(Integer categoryType);

    List<ProductInfo> findByProductIdIn(List<String> prodctIdList);
}
