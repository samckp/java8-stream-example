package com.test.java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupByMapExample {

    public static void main(String[] args) {

        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );

        //Group by + Count

        Map<String, Long> counts = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.counting())
        );

        System.out.println(counts);

        //Group by + Sum qty
        Map<String, Long> sum = items.stream().collect(
                Collectors.groupingBy(Item::getName , Collectors.summingLong(Item::getQty))
        );

        System.out.println(sum);

        //group by price
        Map<BigDecimal, List<Item> > grpByPrice = items.stream().collect(
                Collectors.groupingBy(Item::getPrice)
        );

        System.out.println(grpByPrice);

        //group by price and convert into set of String
        Map<BigDecimal, Set<String>> grpByPrice1 = items.stream().collect(
                    Collectors.groupingBy(Item::getPrice, Collectors.mapping(
                            Item::getName, Collectors.toSet()
                    ))
        );

        System.out.println(grpByPrice1);

    }
}


class Item{

    private String name;
    private int qty;
    private BigDecimal price;

    public Item(String name, int qty, BigDecimal price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}
