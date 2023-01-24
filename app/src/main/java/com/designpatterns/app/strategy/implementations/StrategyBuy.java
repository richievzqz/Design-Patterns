package com.designpatterns.app.strategy.implementations;

import com.designpatterns.app.strategy.interfaces.Strategy;
import com.designpatterns.app.strategy.model.Item;
import com.designpatterns.app.strategy.model.Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrategyBuy implements Strategy<Map<String, Integer>, Order> {
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    public StrategyBuy() {
    }

    @Override
    public Order executeOrder(Map<String, Integer> stock, Order order) throws IOException {

        List<Item> items = new ArrayList<>();
        do {
            String itemChosen;
            System.out.println("Please choose items to Buy");
            stock.forEach((item, amount) -> {
                System.out.println(item + " amount: " + amount);
            });
            itemChosen = READER.readLine();
            if (itemChosen.equals("checkout")) {
                break;
            }
            System.out.println("Please select an amount");
            Integer amount = Integer.valueOf(READER.readLine());

            if (stock.containsKey(itemChosen.toLowerCase())) {
                Integer amountOfItemInStock = stock.get(itemChosen);
                if (amountOfItemInStock >= amount) {
                    stock.replace(itemChosen, amountOfItemInStock - amount);
                } else {
                    System.out.println("NOT ENOUGH IN STOCK");
                }
                items.add(new Item(itemChosen, amount));
            }
            order.setItems(items);
            System.out.println("Is that all?");
            if (READER.readLine().equalsIgnoreCase("yes")){
                break;
            }
        } while (true);
        return order;
    }

}
