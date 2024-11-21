package com.example.springWEB.domain.dto;

public class UsersInfRecv {
    private String receiverName;
    private String receiverAddress;
    private String receiverPhone;

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    @Override
    public String toString() {
        return "UsersInfRecv [receiverName=" + receiverName + ", receiverAddress=" + receiverAddress
                + ", receiverPhone=" + receiverPhone + "]";
    }

}
