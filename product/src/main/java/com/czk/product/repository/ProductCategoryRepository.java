package com.czk.product.repository;

import com.czk.product.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * FileName: ProductCategoryRepository
 * Author:   ChenZK
 * Date:     2019/9/1 16:08
 * Description:
 * History:
 */
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> findAllBy();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);
}
