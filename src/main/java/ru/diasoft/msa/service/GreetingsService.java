package ru.diasoft.msa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.diasoft.msa.domain.Greetings;
import ru.diasoft.msa.repository.GreetingsRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class GreetingsService {

    private final GreetingsRepository greetingRepository;

    @Autowired
    public GreetingsService(GreetingsRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Optional<Greetings> save(Map<String, String> params) {
        if (params == null) params = new HashMap<>();
        return Optional.of(greetingRepository.save(new Greetings(params.get("greetingName"))));
    }

    public Optional<Greetings> update(long id, String newContext) {
        Greetings greetings = greetingRepository.findById(id).orElseGet(() -> new Greetings(newContext));
        greetings.setContent(newContext);
        return Optional.of(greetingRepository.save(greetings));
    }

    @Transactional(readOnly = true)
    public Optional<Greetings> findByName(String name) {
        return greetingRepository.findByContent(name);
    }

    @Transactional(readOnly = true)
    public Optional<Greetings> findByID(long id) {
        return greetingRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Greetings> findAll() {
        return greetingRepository.findAll();
    }

    public void delete(String content) {
        greetingRepository.deleteByContent(content);
    }

    public void delete(long id) {
        greetingRepository.deleteById(id);
    }

}
