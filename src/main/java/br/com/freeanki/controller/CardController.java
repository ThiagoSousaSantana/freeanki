package br.com.freeanki.controller;


import br.com.freeanki.models.Card;
import br.com.freeanki.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/idDeck/{id}")
    public ResponseEntity<List<Card>> findAll(@PathVariable UUID id) {
        var cardList = cardService.findAll(id);
        return ResponseEntity.ok().body(cardList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> findById(@PathVariable UUID id) {
        var card = cardService.findById(id);
        return ResponseEntity.ok().body(card);
    }

    @PostMapping
    public ResponseEntity<Card> insert(@RequestBody Card card) {
        var cardInsert = cardService.insert(card);
        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(cardInsert.getId())
                .toUri();
        return ResponseEntity.created(uri).body(cardInsert);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> update(@PathVariable UUID id, @RequestBody Card card) {
        var updateCard = cardService.update(id, card);
        return ResponseEntity.ok().body(updateCard);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id, @RequestBody Card card) {
        card.setId(id);
        cardService.delete(id);
        return ResponseEntity.ok().build();

    }
}
