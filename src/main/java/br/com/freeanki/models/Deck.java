package br.com.freeanki.models;

import lombok.Data;
import org.springframework.data.annotation.Id;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.List;

@Data
public class Deck implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String description;
    private String tags;
    private String category;
    private List<Card> cards;

    private Deck(){

    }
}
