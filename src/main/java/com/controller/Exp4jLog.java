package com.controller;

import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;

/**
 * Author: Cheryl
 * Description:
 * Date:Created in 15:40 2018/3/5
 */
public class Exp4jLog {
    public static void main(String[] args) {
        Function logb = new Function("logb", 2) {
            @Override
            public double apply(double... args) {
                return Math.log(args[0]) / Math.log(args[1]);
            }
        };
        double result = new ExpressionBuilder("logb(x/y, 2)+x")
                .function(logb)
                .variables("x","y")
                .build()
                .setVariable("x",64)
                .setVariable("y",16)
                .evaluate();
        System.out.println(result);
    }
}
