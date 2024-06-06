package hgcq.appleshop.dto;

import lombok.Data;

@Data
public class ItemInfo {

    private Long id;

    private String name;

    private String image;

    private double price;

    private double discount;

    private double discountPrice;

    private int views;

    private int orders;

    public void discountPrice() {
        discountPrice = price - price * discount / 100;
    }
}
