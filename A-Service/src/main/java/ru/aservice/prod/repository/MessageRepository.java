package ru.aservice.prod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aservice.prod.entity.Messages;

public interface MessageRepository extends JpaRepository<Messages, Long> {
}
