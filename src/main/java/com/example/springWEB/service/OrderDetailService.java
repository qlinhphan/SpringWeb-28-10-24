package com.example.springWEB.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Oders;
import com.example.springWEB.domain.OrderDetail;
import com.example.springWEB.repository.OrderDetailRepository;

@Service
public class OrderDetailService {

    private OrderDetailRepository orderDetailRepository;

    public OrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public OrderDetail saveOrderDetail(OrderDetail od) {
        return this.orderDetailRepository.save(od);
    }

    public List<OrderDetail> findOrderDetailByOrder(Oders oders) {
        return this.orderDetailRepository.findByOrders(oders);
    }

    public void deleteOrderDetailById(long id) {
        this.orderDetailRepository.deleteById(id);
    }

    public List<OrderDetail> findAllOrderDetail() {
        return this.orderDetailRepository.findAll();
    }
}
