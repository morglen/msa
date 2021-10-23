package ru.diasoft.msa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.diasoft.msa.domain.Food;
import ru.diasoft.msa.repository.FoodRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional(timeout = 30, isolation = Isolation.SERIALIZABLE)
public class FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Optional<Food> save(Map<String, String> params) {
        if (params == null) params = new HashMap<>();
        return Optional.of(foodRepository.save(new Food(params.get("foodName"))));
    }

    public Optional<Food> update(long id, String newName) {
        Food food = foodRepository.findById(id).orElseGet(() -> new Food(newName));
        food.setName(newName);
        return Optional.of(foodRepository.save(food));
    }

    @Transactional(readOnly = true)
    public Optional<Food> findByName(String name) {
        return foodRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public Optional<Food> findByID(long id) {
        return foodRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    public void delete(String content) {
        foodRepository.deleteByName(content);
    }

    public void delete(long id) {
        foodRepository.deleteById(id);
    }

}
