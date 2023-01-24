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

public class StrategySell implements Strategy {
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    public StrategySell() {};
    @Override
    public void executeOrder(Map<String, Item> stock, Order order) throws IOException {
        List<Item> items = new ArrayList<>();
        do {
            String itemChosen;
            System.out.println("What would you like to Sell");

            itemChosen = READER.readLine();

            System.out.println("How many do you have?");
            try {
                Integer amount = Integer.valueOf(READER.readLine());

                if (stock.containsKey(itemChosen.toLowerCase())) {
                    Item item = stock.get(itemChosen);
                    item.setAmount(item.getAmount() + amount);
                    items.add(new Item(itemChosen, item.getPrice() * amount, amount));
                } else {
                    System.out.println("How much per item?");
                    Double pricePerItem = Double.valueOf(READER.readLine());
                    stock.put(itemChosen, new Item(itemChosen, pricePerItem, amount));
                    items.add(new Item(itemChosen, pricePerItem * amount, amount));
                }
            } catch (NumberFormatException e) {
                System.out.println("Not a number");
                break;
            }
            order.setItems(items);
            System.out.println("Is that all?");
        } while (!READER.readLine().equalsIgnoreCase("yes"));
    }
}
