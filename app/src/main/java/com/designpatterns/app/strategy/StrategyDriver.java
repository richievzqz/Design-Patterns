package com.designpatterns.app.strategy;

import com.designpatterns.app.strategy.implementations.StrategyBuy;
import com.designpatterns.app.strategy.implementations.StrategySell;
import com.designpatterns.app.strategy.interfaces.Strategy;
import com.designpatterns.app.strategy.model.Order;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class StrategyDriver {
    private static HashMap<String, Integer> stock = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String product;
    private static Strategy strategy;

    static {
        stock.put("bike", 10);
        stock.put("helmet", 10);
        stock.put("lock", 20);
        stock.put("light", 50);
    }

    public static void main(String[] args) throws IOException {
        do {
            System.out.println("Buy or Sell?");
            product = reader.readLine();
            if (product.equals("buy")) {
                StrategyBuy strategyBuy = new StrategyBuy();
                Order order = strategyBuy.executeOrder(stock, new Order("Buy"));
                System.out.println("Your Order");
                System.out.println(order);
                System.out.println("CURRENT STOCK = " + stock);
            }
            if (product.equals("sell")) {
                StrategySell strategySell = new StrategySell();
                Order order = strategySell.executeOrder(stock, new Order("Sell"));
                System.out.println("Your Order");
                System.out.println(order);
                System.out.println("CURRENT STOCK = " + stock);
            }
        } while (true);
    }
}
