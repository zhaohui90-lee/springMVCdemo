package spitter;

import com.melody.controller.spitter.SpitterController;
import com.melody.controller.spitter.data.SpittleRepository;
import com.melody.pojo.User;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpitterControllerTest {

    @Test
    public void shouldShowPagedSpittles(){
        System.out.println(Long.toString(Long.MAX_VALUE,10));
    }

    @Test
    public void testSpittles(){


    }

    @Test
    public void showRegistrationForm() throws Exception {
        SpitterController controller = new SpitterController();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spittle/register"))
                .andExpect(view().name("registerForm"));
    }

    @Test
    public void shouldProcessRegistration() throws Exception {
        SpittleRepository mockRes = mock(SpittleRepository.class);
        User unsaved = new User("jbauer_","jbauer_","jbauer_","jbauer_");
        User saved = new User("jbauer","jbauer","jbauer","jbauer");
        when(mockRes.saveSpittle(unsaved)).thenReturn(saved);

        SpitterController controller = new SpitterController(mockRes);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/spittle/register")
                .param("firstName","jbauer_")
                .param("lastName","jbauer_")
                .param("userName","jbauer_")
                .param("password","jbauer_"))
                .andExpect(redirectedUrl("/user/jbauer_"));
//        verify(mockRes,atLeastOnce()).saveSpittle(unsaved);
    }
}