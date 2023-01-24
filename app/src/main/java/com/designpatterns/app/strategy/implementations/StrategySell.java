package com.designpatterns.app.strategy.implementations;

import com.designpatterns.app.strategy.interfaces.Strategy;
import com.designpatterns.app.strategy.model.Item;
import com.designpatterns.app.strategy.model.Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StrategySell implements Strategy<Map<String, Integer>, Order> {
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    public StrategySell() {};
    @Override
    public Order executeOrder(Map<String, Integer> stock, Order order) throws IOException {
        List<Item> items = new ArrayList<>();
        do {
            String itemChosen;
            System.out.println("What would you like to Sell");

            itemChosen = READER.readLine();
            if (itemChosen == null) {
                break;
            }
            System.out.println("How many do you have?");
            try {
                Integer amount = Integer.valueOf(READER.readLine());
                if (stock.containsKey(itemChosen.toLowerCase())) {
                    Integer newAmountInStock = stock.get(itemChosen) + amount;
                    stock.replace(itemChosen, newAmountInStock);
                } else {
                    stock.put(itemChosen, amount);
                }
                items.add(new Item(itemChosen, amount));
            } catch (NumberFormatException e) {
                System.out.println("Not a number");
                break;
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
