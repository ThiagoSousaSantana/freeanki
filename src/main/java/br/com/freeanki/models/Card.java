package br.com.freeanki.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document
public class Card implements Serializable {

    @Id
    private UUID id;
    private UUID deckId;
    private String question;
    private String answer;
    private LocalDateTime lastExecutedAt;
    private LocalDateTime dueDate;

    public Card() {

    }

    public Card(Card card, UUID id) {
        this.id = id;
        this.deckId = card.getDeckId();
        this.question = card.getQuestion();
        this.answer = card.getAnswer();
        this.lastExecutedAt = card.getLastExecutedAt();
        this.dueDate = card.getDueDate();
    }

}
