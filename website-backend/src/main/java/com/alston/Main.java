package com.alston;

import io.javalin.Javalin;

public class Main {

    public static String email ="nothing";

    public static void main(String[] args) {
        var app = Javalin.create(/*config*/)
                .post("/contact", ctx -> ctx.result("Hello World"))
                .get("/contact", ctx -> ctx.result(email))
                .start(7070);


    }
}