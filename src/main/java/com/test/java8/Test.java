package com.test.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        List<Employee> emps = new ArrayList<>();

        emps.add(new Employee(1,"Sam",23,"male","IT",2022,3333));
        emps.add(new Employee(2,"SaP",22,"female","QA",2021,2112));
        emps.add(new Employee(3,"Yam",66,"male","DA",2011,34234));
        emps.add(new Employee(4,"tam",53,"female","IT",2011,1111));

        List<Employee> nameS = emps.stream().filter(e->e.getName().startsWith("S")).collect(Collectors.toList());

        System.out.println(nameS);

        Map<String, Double> avgSalByDEpt =
                                emps.stream().collect(Collectors.
                                        groupingBy(Employee::getDepartment,
                                                Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalByDEpt);


        Comparator<Employee> sortByAge =  Comparator.comparing(Employee::getAge);
        emps.stream().sorted(sortByAge).forEach(System.out::println);

    }
}
