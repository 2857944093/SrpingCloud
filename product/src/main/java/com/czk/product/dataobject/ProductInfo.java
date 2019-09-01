package com.czk.product.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * FileName: ProductInfo
 * Author:   ChenZK
 * Date:     2019/9/1 15:45
 * Description:
 * History:
 */
@Data
@Entity
public class ProductInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 状态, 0正常1下架. */
    private Integer productStatus;

    /** 类目编号. */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
