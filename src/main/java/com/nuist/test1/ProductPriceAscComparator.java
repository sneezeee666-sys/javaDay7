package com.nuist.test1;

import java.util.Comparator;

//自定义比较器，用不同的比较器定义不同的排序规则。
public class ProductPriceAscComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPrice() > o2.getPrice()) {
            return 1;
        }
        else if (o1.getPrice() < o2.getPrice()) {
            return -1;
        }
        return 0;
    }
}
