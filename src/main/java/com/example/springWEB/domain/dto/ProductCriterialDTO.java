package com.example.springWEB.domain.dto;

import java.util.Objects;

public class ProductCriterialDTO {
    private String fact;
    private String target;
    private String money;
    private String sort;
    private String page;
    private String previousTarget;
    private String previousFact;
    private String previousMoney;

    public ProductCriterialDTO() {
        this.page = "1";
    }

    public String getPreviousTarget() {
        return previousTarget;
    }

    public void setPreviousTarget(String previousTarget) {
        this.previousTarget = previousTarget;
    }

    public String getPreviousFact() {
        return previousFact;
    }

    public void setPreviousFact(String previousFact) {
        this.previousFact = previousFact;
    }

    public String getPreviousMoney() {
        return previousMoney;
    }

    public void setPreviousMoney(String previousMoney) {
        this.previousMoney = previousMoney;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public boolean isNewSearch() {
        // Kiểm tra sự thay đổi
        return !Objects.equals(target, previousTarget) ||
                !Objects.equals(fact, previousFact) ||
                !Objects.equals(money, previousMoney);
    }

    public void updatePreviousState() {
        // Cập nhật trạng thái trước đó
        this.previousTarget = this.target;
        this.previousFact = this.fact;
        this.previousMoney = this.money;
    }

}
