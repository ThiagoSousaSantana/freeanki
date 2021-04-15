package br.com.freeanki.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document
public class Card {

    @Id
    private UUID id;
    private UUID deckId;
    private String question;
    private String answer;
    private LocalDateTime lastExecutedAt;
    private LocalDateTime dueDate;
}
