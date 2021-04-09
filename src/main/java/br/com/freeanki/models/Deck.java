package br.com.freeanki.models;

import lombok.Data;
import org.springframework.data.annotation.Id;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
public class Deck implements Serializable {

    @Id
    private UUID id;
    private String name;
    private String description;
    private String tags;
    private String category;
    private List<Card> cards;


}
