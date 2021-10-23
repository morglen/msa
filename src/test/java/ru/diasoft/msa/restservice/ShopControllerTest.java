package ru.diasoft.msa.restservice;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.diasoft.msa.domain.Food;
import ru.diasoft.msa.service.FoodServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ShopController.class)
class ShopControllerTest {

    @MockBean
    FoodServiceImpl foodService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetGreeting() throws Exception {
        Food bread = new Food("bread");
        bread.setId(1L);
        given(foodService.findByID(ArgumentMatchers.anyLong())).willReturn(Optional.of(bread));

        mockMvc.perform(get("/food/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)));

    }

    @Test
    void testPutGreeting() throws Exception {
        given(foodService.update(ArgumentMatchers.anyLong(), ArgumentMatchers.any())).willReturn(Optional.of(new Food("Food2")));

        mockMvc.perform(put("/food/1")
                        .contentType(MediaType.APPLICATION_JSON).content("{\"id\": \"1\", \"content\":\"Food2\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void testPostGreeting() throws Exception {
        given(foodService.save(ArgumentMatchers.any())).willReturn(Optional.of(new Food("Food3")));

        mockMvc.perform(post("/food")
                        .contentType(MediaType.APPLICATION_JSON).content("{\"id\": \"1\", \"content\":\"Food3\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @Test
    void testGetAllGreetings() throws Exception {
        Food greeting1 = new Food("Food1");
        Food greeting2 = new Food("Food2");
        List<Food> foodList = new ArrayList<>();
        foodList.add(greeting1);
        foodList.add(greeting2);
        given(foodService.findAll()).willReturn(foodList);


        mockMvc.perform(get("/shopping"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}