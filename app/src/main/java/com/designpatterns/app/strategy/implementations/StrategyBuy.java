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

public class StrategyBuy implements Strategy {
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    public StrategyBuy() {
    }

    @Override
    public void executeOrder(Map<String, Item> stock, Order order) throws IOException {

        List<Item> items = new ArrayList<>();
        do {
            System.out.println("Please choose items to Buy or choose");
            stock.forEach((item, itemDetails) -> {
                System.out.println(itemDetails);
            });

            String itemChosen = READER.readLine();

            if (stock.containsKey(itemChosen.toLowerCase())) {
                Item item = stock.get(itemChosen);
                Integer amountOfItemInStock = item.getAmount();

                System.out.println("Please select an amount");
                Integer amount = Integer.valueOf(READER.readLine());

                if (amountOfItemInStock >= amount) {
                    item.setAmount(amountOfItemInStock - amount);
                } else {
                    System.out.println("Not enough in stock");

                    continue;
                }
                items.add(new Item(itemChosen, amount * item.getPrice(), amount));
            } else {
                System.out.println("Item not currently in stock");
                continue;
            }
            order.setItems(items);
            System.out.println("Is that all?");
        } while (!READER.readLine().equalsIgnoreCase("yes"));
    }

}
