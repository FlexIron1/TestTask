package ru.aservice.prod.resource;


import lombok.SneakyThrows;
import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import ru.aservice.prod.entity.Messages;
import ru.aservice.prod.processor.MessageProcessor;

@Component
public class ApplicationResource extends RouteBuilder {

    @BeanInject
    private MessageProcessor messageProcessor;

    public ApplicationResource(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }


    @Override
    @SneakyThrows
    public void configure() {
        restConfiguration()
                .component("servlet")
                .port(8080).host("localhost")
                .bindingMode(RestBindingMode.json);


        rest().post("/addMessage")
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .type(Messages.class).outType(Messages.class)
                .route()
                .process(messageProcessor).endRest();
    }
}

