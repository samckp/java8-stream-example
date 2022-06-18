package com.test.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountCharsInString {

    public static void main(String[] args) {

        String str = "this is a string";

        charOccurenceCount(str);

        charOccurenceCountUsingStream(str);
    }

    private static void charOccurenceCountUsingStream(String str){

        Map<String, Long> result = Arrays.stream(str.split(""))
                .collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting())
                );
        System.out.println(result);
    }


    private static void charOccurenceCount(String str) {

        char []chars = str.toCharArray();
        Integer count =0;
        Map<Character, Integer> charCountMap = new HashMap<>();

        for(char c : chars){

            if(charCountMap.containsKey(c)){
                charCountMap.put(c, charCountMap.get(c) + 1);
            }else{
                charCountMap.put(c, 1);
            }
        }

        for (Map.Entry entry : charCountMap.entrySet()){

            System.out.println(entry.getKey() +" : " + entry.getValue());
        }
    }

}
