package org.aktic.ProductOfNumbers;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {

    private ArrayList<Integer> prefixProduct = new ArrayList<>();
    private int size = 0;

    public ProductOfNumbers() {
        this.prefixProduct.add(1);
        this.size = 0;
    }

    public void add(int num) {
        if (num == 0) {
            this.prefixProduct = new ArrayList<Integer>();
            this.prefixProduct.add(1);
            this.size = 0;
        } else {
            this.prefixProduct.add(this.prefixProduct.get(size) * num);
            this.size++;
        }
    }

    public int getProduct(int k) {
        if (k > this.size) return 0;
        return (
                this.prefixProduct.get(this.size) /
                        this.prefixProduct.get(this.size - k)
        );
    }

    public static void main(String[] args) {
        ProductOfNumbers pn = new ProductOfNumbers();
        pn.add(3);
        pn.add(0);
        pn.add(2);
        pn.add(5);
        pn.add(4);
        System.out.println(pn.getProduct(2));
    }
}