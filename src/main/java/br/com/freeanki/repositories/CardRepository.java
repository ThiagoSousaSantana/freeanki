package br.com.freeanki.repositories;

import br.com.freeanki.models.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CardRepository extends MongoRepository<Card, UUID> {
}
