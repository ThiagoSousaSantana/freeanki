package br.com.freeanki.services;

import br.com.freeanki.models.Deck;
import br.com.freeanki.repositories.DeckRepository;
import br.com.freeanki.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DeckService {

    @Autowired
    private DeckRepository deckRepository;

    public Deck insert(Deck deck) {
        deck.setId(UUID.randomUUID());
        return deckRepository.save(deck);
    }

    public List<Deck> findAll() {
        return deckRepository.findAll();
    }

    public Deck findById(UUID id) {
        Optional<Deck> deck = deckRepository.findById(id);
        return deck.orElseThrow(() -> new ObjectNotFoundException("Object not found id " + id));
    }

    public void delete(UUID id) {
        findById(id);
        deckRepository.deleteById(id);
    }

    public Deck update(UUID id, Deck deck) {
        findById(id);
        return deckRepository.save(new Deck(id, deck));

    }

}
