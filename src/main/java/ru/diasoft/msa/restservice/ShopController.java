package ru.diasoft.msa.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.diasoft.msa.domain.Food;
import ru.diasoft.msa.service.FoodService;

import java.util.List;
import java.util.Map;

@RestController
public class ShopController {

    private final FoodService foodService;

    @Autowired
    public ShopController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/shopping")
    public List<Food> shopping() {
        return foodService.findAll();
    }

    @GetMapping("/food/{id}")
    public Food getOne(@PathVariable Long id) {
        return foodService.findByID(id).get();
    }

    @PostMapping("/food")
    public Food create(@RequestBody Map<String, String> params) {
        return foodService.save(params).get();
    }

    @PutMapping("/food/{id}")
    public Food update(@RequestBody String newName, @PathVariable long id) {
        return foodService.update(id, newName).get();
    }

    @DeleteMapping("/food/{id}")
    public void delete(@PathVariable long id) {
        foodService.delete(id);
    }

}
