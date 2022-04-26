package com.test.java8;

public class AppTest {

    public static void main(String[] args) {

        for(int i=1;i<=100;i++){

            if(i%3!=0 && i%5!=0)
                System.out.println(i);
            else if(i%3==0 && i%5==0)
                System.out.println("fizz buzz " + i);
            else if(i%3==0)
                System.out.println("fizz " + i);
            else if(i%5==0)
                System.out.println("buzz " +i);
        }

    }
}

//3 = fizz
//5= buzz
// 1 --
// 2 --

