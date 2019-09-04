/**
 * @program: order
 * @description:
 * @author: Mr.wjg
 * @create: 2019/9/1 17:34
 **/
package com.czk.order.server.repository;

import com.czk.order.server.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
