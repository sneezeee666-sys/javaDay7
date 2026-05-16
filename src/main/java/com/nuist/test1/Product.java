package com.nuist.test1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Comparable<Product>{
    private String name;
    private double price;
    private int count;
    private String producer;
    private String date;
    private String description;
    private int id;

    @Override
    public int compareTo(Product o) {
        if (this.price > o.price){
            return 1;
        }else if (this.price < o.price){
            return -1;
        }
        return 0;

    }
}
