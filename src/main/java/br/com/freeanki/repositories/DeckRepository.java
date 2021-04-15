package br.com.freeanki.repositories;

import br.com.freeanki.models.Deck;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface DeckRepository extends MongoRepository<Deck, UUID> {
}
