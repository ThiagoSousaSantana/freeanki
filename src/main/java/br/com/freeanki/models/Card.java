package br.com.freeanki.models;

import java.util.Date;

public class Card {

    private String deckId;
    private String question;
    private String answer;
    private Date lastExecutedAt;
    private Integer lastUserAnswer;
    private Integer answerAmount;
    private Date dueDate;
}
