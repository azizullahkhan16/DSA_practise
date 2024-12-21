package org.aktic.Cashier;

import java.util.HashMap;
import java.util.Map;

public class Cashier {
    private int n;
    private int discount;
    private int[] products;
    private int[] prices;
    private int discountCount;
    private Map<Integer, Integer> productMap;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        this.products = products;
        this.prices = prices;
        this.discountCount = 0;

        this.productMap = new HashMap<>();
        for (int i = 0; i < products.length; i++) {
            productMap.put(products[i], prices[i]);
        }


    }

    public double getBill(int[] product, int[] amount) {
        double subtotal = 0;
        for (int i = 0; i < product.length; i++) {
            if (productMap.containsKey(product[i])) {
                int price = productMap.get(product[i]);
                subtotal += (price * amount[i]);
            }
        }

        if(this.discountCount == n-1) {
            subtotal = subtotal * ((double) (100 - discount) / 100);
            this.discountCount = 0;
        }else discountCount++;

        return subtotal;
    }
}
