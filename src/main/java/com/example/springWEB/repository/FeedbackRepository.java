package com.example.springWEB.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springWEB.domain.cart.feedBack;

public interface FeedbackRepository extends JpaRepository<feedBack, Long> {
    public feedBack save(feedBack feed);

    public List<feedBack> findAll();

    public Page<feedBack> findAll(Pageable pageable);

}
