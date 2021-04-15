package br.com.freeanki.models;

import lombok.Data;

import javax.persistence.Id;
import java.util.List;
import java.util.UUID;

import static java.util.Collections.unmodifiableList;

@Data
public class User {

    @Id
    private UUID id;
    private String email;
    private String name;
    private String password;
    private Integer easyCardAmount;
    private Integer mediumCardAmount;
    private Integer hardCardAmount;
    private List<Deck> decks;

    public List<Deck> getDecks() {
        return unmodifiableList(decks);
    }
}
