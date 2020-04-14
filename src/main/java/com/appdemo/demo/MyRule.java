package com.appdemo.demo;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "100", description = "my rule description", priority = 100)
public class MyRule<T> {

    private boolean executed;

    private T result;

    @Condition
    public boolean when(@Fact("user") T fact) {
        //my rule conditions
        return true;
    }

    @Action(order = 1)
    public void then(@Fact("user") T facts) throws Exception {
        try {
            System.out.println("my rule has been executed");
            result = (T)facts; // assign your result here
            executed = true;
        } catch (Exception e) {
            // executed flag will remain false if an exception occurs
            throw e;
        }
    }
    @Action(order = 2)
    public void finaly() throws Exception {
        try {
            System.out.println("all is ok ");

        } catch (Exception e) {
            // executed flag will remain false if an exception occurs
            throw e;
        }
    }
    public boolean isExecuted() {
        return executed;
    }

    public T getResult() {
        return result;
    }

}