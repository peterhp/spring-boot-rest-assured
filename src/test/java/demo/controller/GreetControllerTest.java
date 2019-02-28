package demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GreetController.class)
public class GreetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldSayHelloToPerson() throws Exception {
        mockMvc.perform(get("/greet")
                .param("person", "Sora"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Sora!"));
    }

    @Test
    public void shouldSayHelloToStranger() throws Exception {
        mockMvc.perform(get("/greet"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Stranger!"));
    }
}
