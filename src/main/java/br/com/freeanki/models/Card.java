package br.com.freeanki.models;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
public class Card implements Serializable {

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
