package com.controller;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 * Author: Cheryl
 * Description:
 * Date:Created in 15:50 2018/3/5
 */
public class Exp4jDemo {

    public static void main(String[] args) {
        String a = "[1.01-0.37(x/y)]^2";
        String b = "/{1-[(2x/y)/(3-2/y)]^0.5}";
        Expression e = new ExpressionBuilder(a+b)
                .variables("x", "y")
                .build()
                .setVariable("x", 2)
                .setVariable("y", 1);
        double result = e.evaluate();
        System.out.println(result);
        if(result<0){
            String c = String.valueOf(result);
            System.out.println(c);
            Expression e1 = new ExpressionBuilder(c+"^1.08")
                    .variables("x", "y")
                    .build()
                    .setVariable("x", -2)
                    .setVariable("y", 1);
            double result1 = e1.evaluate();
            System.out.println(result1);
        }
    }
}
