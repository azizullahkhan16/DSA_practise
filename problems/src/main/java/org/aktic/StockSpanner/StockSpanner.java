package org.aktic.StockSpanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class StockSpanner {

    private List<Integer> stock;
    private Stack<Integer> mono;
    private int count;

    public StockSpanner() {
        stock = new ArrayList<Integer>();
        count = 0;
    }

    public int next(int price) {
        if(stock.isEmpty()) {
            stock.add(price);
            return 1;
        } else {
            stock.add(price);
            int count = 0;
            for (int i = stock.size()-1; i >= 0; i--) {
                if(stock.get(i) <= price) count++;
                else break;
            }
            return count;
        }

    }


    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
    }
}
