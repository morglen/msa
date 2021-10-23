package ru.diasoft.msa.service;

import ru.diasoft.msa.domain.Food;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface FoodService {
    Optional<Food> save(Map<String, String> params);

    List<Food> findAll();

    Optional<Food> findByName(String name);

    Optional<Food> findByID(Long id);

    void delete(long id);

    Optional<Food> update(long id, String newName);
}
