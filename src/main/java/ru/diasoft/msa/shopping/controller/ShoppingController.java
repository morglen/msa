package ru.diasoft.msa.shopping.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.diasoft.msa.shopping.exception.NotFoundException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("shopping")
public class ShoppingController {

    private int counter = 2;

    private final List<Map<String, String>> shoppingList = new LinkedList<Map<String, String>>() {{
       add(new HashMap<String, String>() {{put("id", "1"); put("text", "milk");}});
    }};

    @GetMapping
    public List<Map<String, String>> list() {
        return shoppingList;
    }

    @GetMapping("{id}")
    public Map<String, String> getOne(@PathVariable String id) {
        return getItem(id);
    }

    private Map<String, String> getItem(String id) {
        return shoppingList.stream()
                .filter(day -> day.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> item) {
        item.put("id", String.valueOf(counter++));
        shoppingList.add(item);

        return item;
    }

    @PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> item) {
        Map<String, String> itemFromDb = getItem(id);
        itemFromDb.putAll(item);
        itemFromDb.put("id", id);

        return itemFromDb;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        Map<String, String> item = getItem(id);

        shoppingList.remove(item);
    }
}
