package spitter;

import com.melody.controller.spitter.HomeController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HomeControllerTest {

    @Test
    public void home() throws Exception {
//        HomeController homeController = new HomeController();
//        assertEquals("home",homeController.home());
//        MockMvc mockMvc = standaloneSetup(homeController).build();
//        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }

}