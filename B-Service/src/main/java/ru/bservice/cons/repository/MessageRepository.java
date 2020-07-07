package ru.bservice.cons.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.bservice.cons.entity.Messages;

public interface MessageRepository extends JpaRepository<Messages, Long> {
}
