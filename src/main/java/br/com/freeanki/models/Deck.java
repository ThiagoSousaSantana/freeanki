package br.com.freeanki.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

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
}
