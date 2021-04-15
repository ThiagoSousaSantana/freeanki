package br.com.freeanki.controller;

import br.com.freeanki.models.Deck;
import br.com.freeanki.services.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/deck")
public class DeckController {

    @Autowired
    private DeckService deckService;

    @GetMapping
    public ResponseEntity<List<Deck>> findAll() {
        var deckList = deckService.findAll();
        return ResponseEntity.ok().body(deckList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deck> findById(@PathVariable UUID id) {
        var deck = deckService.findById(id);
        return ResponseEntity.ok().body(deck);
    }

    @PostMapping
    public ResponseEntity<Deck> insert(@RequestBody Deck deck) {
        var deckInsert = deckService.insert(deck);
        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(deckInsert.getId())
                .toUri();
        return ResponseEntity.created(uri).body(deckInsert);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Deck> update(@PathVariable UUID id, @RequestBody Deck deck) {
        var updateDeck = deckService.update(id, deck);
        return ResponseEntity.ok().body(updateDeck);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id, @RequestBody Deck deck) {
        deck.setId(id);
        deckService.delete(id);
        return ResponseEntity.ok().build();

    }


}
