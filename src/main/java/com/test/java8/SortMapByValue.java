package com.test.java8;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByValue {

    public static void main(String[] args) {

        Map<String, Integer> val = new HashMap<>();

        val.put("gaa",5);
        val.put("aab",2);
        val.put("uac",4);
        val.put("aad",3);
        val.put("fae",1);

        Map<String, Integer> res = val.entrySet().stream()
//                .sorted(Map.Entry.comparingByKey())               //sort by Key
                .sorted(Map.Entry.comparingByValue())                //sort by Value
                    .collect(Collectors.toMap(Map.Entry::getKey,        // key Mapper
                                                Map.Entry::getValue     // value Mapper
                                                ,(e1, e2) -> e1,       // merge values which associated with same key
                                                LinkedHashMap::new)     // hold the result on Map
                    );

        for(Map.Entry e : res.entrySet()){

            System.out.println(e.getKey() +" : " + e.getValue());
        }

        System.out.println("--------------------------------------");
        /////////////////////////////////////////////////
        Map<String, Integer> num = new HashMap<>();

            num.put("one", 1);
            num.put("four", 4);
            num.put("two", 2);
            num.put("six", 6);
            num.put("ten", 10);

            num.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(System.out::println);

        System.out.println("--------------------------------------");
            num.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

    }
}
