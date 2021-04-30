package br.com.freeanki.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import static java.util.Collections.unmodifiableList;

@Data
@Document
public class Deck implements Serializable {

    @Id
    private UUID id;
    private UUID idUser;
    private String name;
    private String description;
    private String tags;
    private String category;
    private List<Card> cards;

    public List<Card> getCards() {
        return unmodifiableList(cards);
    }

    public Deck(UUID id, Deck deck) {
        this.id = id;
        this.idUser = deck.getIdUser();
        this.name = deck.getName();
        this.description = deck.getDescription();
        this.tags = deck.getTags();
        this.category = deck.getCategory();
        this.cards = deck.getCards();
    }

    public Deck() {

    }


}
