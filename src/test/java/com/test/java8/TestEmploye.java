package com.test.java8;

import
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class TestEmploye {

    TestEmploye testEmploye;

    @BeforeEach
    public TestEmploye init(){
        testEmploye = new TestEmploye();
        return testEmploye;
    }

    @Test
    public void testName(){

        AssertTrue(testEmploye.testName(), "S");

    }


}
