package ru.bservice.cons.resource;


import lombok.SneakyThrows;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import ru.bservice.cons.service.MessageService;


@Component
public class ApplicationResource extends RouteBuilder {

    private final MessageService messageService;

    public ApplicationResource(MessageService messageService) {
        this.messageService = messageService;
    }


    @Override
    @SneakyThrows
    public void configure() {
        restConfiguration()
                .component("servlet")
                .port(8000).host("localhost")
                .bindingMode(RestBindingMode.json);

        rest().get("/getMessage")
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .route()
                .setBody(messageService::getMessage).endRest();
    }

}

