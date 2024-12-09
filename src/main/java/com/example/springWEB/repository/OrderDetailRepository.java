package com.example.springWEB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springWEB.domain.Oders;
import com.example.springWEB.domain.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    public OrderDetail save(OrderDetail od);

    public List<OrderDetail> findByOrders(Oders oders);

    public void deleteById(long id);

    public List<OrderDetail> findAll();
}
