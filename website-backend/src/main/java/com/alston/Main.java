package com.alston;

import Controller.WebsiteController;
import io.javalin.Javalin;

public class Main {

    public static String email ="nothing";

    public static void main(String[] args) {

        WebsiteController controller = new WebsiteController();
        Javalin app = controller.startAPI();
        app.start(7070);

    }
}