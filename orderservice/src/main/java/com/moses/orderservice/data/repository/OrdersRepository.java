package com.moses.orderservice.data.repository;

import com.moses.orderservice.data.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository <OrderEntity, String>{
    
}
