package br.com.freeanki.repositories;

import br.com.freeanki.models.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeckRepository extends JpaRepository<Deck, UUID> {
}
