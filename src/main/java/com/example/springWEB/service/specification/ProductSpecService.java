package com.example.springWEB.service.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Products;
import com.example.springWEB.domain.Products_;

import jakarta.persistence.criteria.Predicate;

@Service
public class ProductSpecService {

    public Specification<Products> moreThanInputPrice(String price) {
        return (root, query, builder) -> {
            return builder.greaterThan(root.get(Products_.PRICE), price);
        };
    }

    public Specification<Products> lessThanInputPrice(String price) {
        return (root, query, builder) -> {
            return builder.lessThan(root.get(Products_.PRICE), price);
        };
    }

    public Specification<Products> factoryIsApple(String fact) {
        return (root, query, builder) -> {
            return builder.equal(root.get(Products_.FACTORY), fact);
        };
    }

    public Specification<Products> factoryIsAppleAndDell(List<String> factory) {
        return (root, query, builder) -> {
            return builder.in(root.get(Products_.FACTORY)).value(factory);
        };
    }

    // public Specification<Products> PriceIsInput(double min, double max) {
    // return (root, query, builder) -> {
    // return builder.and(builder.gt(root.get(Products_.PRICE), min),
    // builder.le(root.get(Products_.PRICE), max));
    // };
    // }

    // public Specification<Products> PriceIsInput(double min, double max) {
    // return (root, query, builder) -> {
    // return builder.and(builder.gt(root.get(Products_.PRICE), min),
    // builder.le(root.get(Products_.PRICE), max));
    // };
    // }
    public Specification<Products> PriceIsInput(List<Double[]> dataPrice) {
        return (root, query, builder) -> {
            List<Predicate> dsPre = new ArrayList<>();
            for (Double[] doubles : dataPrice) {
                Predicate predata = builder.and(builder.gt(root.get(Products_.PRICE), doubles[0]),
                        builder.le(root.get(Products_.PRICE), doubles[1]));
                dsPre.add(predata);
            }
            return builder.or(dsPre.toArray(new Predicate[0]));
        };
    }

    public Specification<Products> likeNameFactOne(String name) {
        return (root, query, builder) -> {
            return builder.like(root.get(Products_.NAME), "%" + name + "%");
        };
    }

    public Specification<Products> likeNameFact(List<String> factory) {
        return (root, query, builder) -> {
            return builder.in(root.get(Products_.FACTORY)).value(factory);
        };
    }

    public Specification<Products> likeNameTarget(List<String> target) {
        return (root, query, builder) -> {
            return builder.in(root.get(Products_.TARGET)).value(target);
        };
    }

    public Specification<Products> factoryIs(String fact) {
        return (root, query, builder) -> {
            return builder.equal(root.get(Products_.FACTORY), fact);
        };
    }

    public Specification<Products> selectManyInAllFactory(List<String> fact) {
        return (root, query, builder) -> {
            return builder.in(root.get(Products_.FACTORY)).value(fact);
        };
    }

    public Specification<Products> selectManyInAllTarget(List<String> target) {
        return (root, query, builder) -> {
            return builder.in(root.get(Products_.TARGET)).value(target);
        };
    }

    public Specification<Products> queryByManyMoney(List<double[]> price) {
        return (root, query, builder) -> {
            List<Predicate> listPre = new ArrayList<>();
            for (double[] ds : price) {
                Predicate predi = builder.and(builder.gt(root.get(Products_.PRICE), ds[0]),
                        builder.le(root.get(Products_.PRICE), ds[1]));
                listPre.add(predi);
            }
            return builder.or(listPre.toArray(new Predicate[0]));
        };
    }

}
