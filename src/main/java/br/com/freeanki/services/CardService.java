package br.com.freeanki.services;

import br.com.freeanki.models.Card;
import br.com.freeanki.repositories.CardRepository;
import br.com.freeanki.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public Card insert(Card card) {
        card.setId(UUID.randomUUID());
        return cardRepository.save(card);
    }

    public List<Card> findAll(UUID idDeck) {
        var card = cardRepository.findAll();
        card.stream().filter(itemCard -> itemCard.getDeckId().equals(idDeck));
        return card;
    }

    public Card findById(UUID id) {
        Optional<Card> card = cardRepository.findById(id);
        return card.orElseThrow(() -> new ObjectNotFoundException("Object not found id " + id));
    }

    public void delete(UUID id) {
        findById(id);
        cardRepository.deleteById(id);
    }

    public Card update(UUID id, Card card) {
        findById(id);
        return cardRepository.save(new Card(card, id));
    }
}
