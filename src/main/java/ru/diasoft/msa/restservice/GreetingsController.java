package ru.diasoft.msa.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.diasoft.msa.domain.Greetings;
import ru.diasoft.msa.service.GreetingsService;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingsController {

    private final GreetingsService service;

    @Autowired
    public GreetingsController(GreetingsService service) {
        this.service = service;
    }

    @GetMapping("/greetings")
    public List<Greetings> greetings() {
        return service.findAll();
    }

    @GetMapping("/greeting/{id}")
    public Greetings getOne(@PathVariable Long id) {
        return service.findByID(id).get();
    }

    @PostMapping("/greeting")
    public Greetings create(@RequestBody Map<String, String> params) {
        return service.save(params).get();
    }

    @PutMapping("/greeting/{id}")
    public Greetings update(@RequestBody String newName, @PathVariable long id) {
        return service.update(id, newName).get();
    }

    @DeleteMapping("/greeting/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

}
