package ru.bservice.cons.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bservice.cons.entity.Messages;
import ru.bservice.cons.repository.MessageRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements  MessageService {

    private final MessageRepository messageRepository;


    @Override
    public List<Messages> getMessage() {
        return messageRepository.findAll();
    }


}




