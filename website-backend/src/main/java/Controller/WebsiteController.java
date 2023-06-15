package Controller;


import Model.EmailAdress;
import Util.EmailSender;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;
import org.apache.commons.mail.*;
import io.javalin.Javalin;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.post;
import static j2html.TagCreator.br;
import static j2html.TagCreator.button;
import static j2html.TagCreator.form;
import static j2html.TagCreator.input;
import static j2html.TagCreator.textarea;

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



    private void postContactHandler(Context context) throws JsonProcessingException, EmailException {
        context.result("post called"+context.body());
        ObjectMapper mapper = new ObjectMapper();
        EmailAdress emailAdress = mapper.readValue(context.body(), EmailAdress .class);

        System.out.println(emailAdress.getEmail());




        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("alstonstone0@gmail.com", "tgjsjqwefpfnhzlv"));
        email.setSSLOnConnect(true);
        email.setFrom("alstonstone0@gmail.com");

        email.setMsg("message");
        email.addTo(emailAdress.getEmail());
        email.send(); // will throw email-exception if something is wrong

    }

}
