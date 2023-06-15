package Controller;

import io.javalin.Javalin;
import org.eclipse.jetty.http.HttpTester;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class WebsiteController {

    String lastEmail = "none";

    public Javalin startAPI() {
        Javalin app = Javalin.create(config -> {
            config.plugins.enableCors(cors -> {
                cors.add(it -> {
                    it.anyHost();
                });
            });
        });

        app.post("/contact", this::postContactHandler);

        app.get("/contact", this::getContactHandler);
        return app;
    }

    private void getContactHandler(Context context) {
        context.result("post called"+context.body());
        System.out.println("it worked");
        context.status(200);
    }



    private void postContactHandler(Context context) {
        context.result("post called"+context.body());
        System.out.println("it worked");

    }

}
