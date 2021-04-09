package br.com.freeanki.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import java.util.UUID;

@Data
public class Card {

    @Id
    private UUID id;
    private UUID deckId;
    private String question;
    private String answer;
    private Date lastExecutedAt;
    private Integer lastUserAnswer;
    private Integer answerAmount;
    private Date dueDate;


}
