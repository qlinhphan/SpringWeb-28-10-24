package com.example.springWEB.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Oders;
import com.example.springWEB.domain.dto.UsersInfRecv;
import com.example.springWEB.repository.OrderRepository;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Oders toOrderRecvFromUserInfRecv(UsersInfRecv usersInfRecv) {
        Oders order = new Oders();
        order.setReceiverName(usersInfRecv.getReceiverName());
        order.setReceiverAddress(usersInfRecv.getReceiverAddress());
        order.setReceiverPhone(usersInfRecv.getReceiverPhone());
        return order;
    }

    public Oders saveOrder(Oders oders) {
        return this.orderRepository.save(oders);
    }

    public List<Oders> findAllOders() {
        return this.orderRepository.findAll();
    }

    public Oders findOrderById(long id) {
        return this.orderRepository.findById(id);
    }

}
