package com.test.java8;

import java.util.*;
import java.util.stream.Collectors;

// ********** Benchmark   *********
//In Java 8 Stream, filter with Set.Add() is the fastest algorithm to find duplicate elements,
// because it loops only one time.

//The Collections.frequency is the slowest because it compares each item with a
// list – Collections.frequency(list, i). If we increase the size of the list,
// the performance will get slower.

public class FindDuplicateInList {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);

        // find duplicate using Set ---- fast performance
        Set<Integer> items = new HashSet<Integer>();
          list.stream().filter(n -> !items.add(n)).collect(Collectors.toSet()).forEach(System.out::println);

        // find duplicate using frequency -------- slow performance
        list.stream().filter(i-> Collections.frequency(list, i)>1)
                .collect(Collectors.toSet()).forEach(System.out::println);

    }
}
