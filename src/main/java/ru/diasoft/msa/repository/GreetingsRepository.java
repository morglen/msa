package ru.diasoft.msa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diasoft.msa.domain.Greetings;

import java.util.Optional;

public interface GreetingsRepository extends JpaRepository<Greetings, Long> {

    Optional<Greetings> findByContent(String name);

    Optional<Greetings> deleteByContent(String name);

}
