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
        Javalin app = Javalin.create();

        app.post("/contact/{email}", this::postContactHandler);

        app.get("/contact", this::getContactHandler);
        return app;
    }

    private void getContactHandler(@NotNull Context context) {
        context.result(context.body());

        context.status(200);
    }



    private void postContactHandler(Context context) throws IOException {

    }

}
