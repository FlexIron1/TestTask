package ru.aservice.prod.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;
import ru.aservice.prod.entity.Messages;
import ru.aservice.prod.service.MessagesService;

@Component
public class MessageProcessor implements Processor {

    private final MessagesService messagesService;

    public MessageProcessor(MessagesService messageService) {
        this.messagesService = messageService;
    }


    @Override
    public void process(Exchange exchange) {
        messagesService.addMessage(exchange.getIn().getBody(Messages.class));
    }
}
