package com.test.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test implements Cloneable{

    public static void main(String[] args) {

        List<Employee> empList = new ArrayList<>();

        Employee e1 =null;

        empList.stream().sorted(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
               int res=  o1.getYearOfJoining() - o2.getYearOfJoining();
                return res;
            }
        });

      //  empList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).forEach(System);

        empList.stream().filter(employee -> employee.getYearOfJoining() > 2021).collect(Collectors.toList());

        empList.stream().filter(e->e.getYearOfJoining() >2021).map(Employee::getName).forEach(System.out::println);

          //Employee e2 =e1.clone();

    }
}

class EmpNameComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {

        return 0;
    }
}
