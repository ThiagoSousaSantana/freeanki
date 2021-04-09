package br.com.freeanki.models;

import lombok.Data;

import javax.persistence.Id;
import java.util.UUID;

@Data
public class User {

    @Id
    private UUID id;
    private String email;
    private String password;
    private Integer easyCardAmount;
    private Integer mediumCardAmount;
    private Integer hardCardAmount;
}
