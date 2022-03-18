package com.test.java8;

public class Overloading {
    public static void main(String[] args) {

        Parent p = new Child();
        p.show();
    }
}

class Parent{

    public Parent(){
        System.out.println("Parent ");
    }
    public void show(){
        System.out.println("show parent");
    }
}

class Child extends Parent{

    public Child(){
        System.out.println("Child ");
    }
    public void show(){
        System.out.println("show child ");
    }
}
