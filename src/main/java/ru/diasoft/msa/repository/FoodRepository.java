package ru.diasoft.msa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diasoft.msa.domain.Food;

import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {

    Optional<Food> findByName(String name);

    Optional<Food> deleteByName(String name);

}
