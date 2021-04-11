package br.com.freeanki.controller;

import br.com.freeanki.models.Deck;
import br.com.freeanki.services.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        List<Deck> deckList = deckService.findAll();
        return ResponseEntity.ok().body(deckList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deck> findByid(@PathVariable UUID id) {
        Deck deck = deckService.findById(id);
        return ResponseEntity.ok().body(deck);
    }

    @PostMapping
    public ResponseEntity<Deck> insert(@RequestBody Deck deck) {
        Deck deckInsert = deckService.insert(deck);
        return ResponseEntity.ok().body(deckInsert);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Deck> update(@PathVariable UUID id, @RequestBody Deck deck) {
        Deck updateDeck = deckService.update(id, deck);
        return ResponseEntity.ok().body(updateDeck);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id, @RequestBody Deck deck) {
        deck.setId(id);
        deckService.delete(id);
        String message = "The Deck: " + deck.getName() + " successfully deleted!";
        return ResponseEntity.ok().body(message);

    }


}
