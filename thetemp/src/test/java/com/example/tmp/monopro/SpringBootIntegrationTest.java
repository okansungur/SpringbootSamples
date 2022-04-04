package com.turksat.azerspace.azweb;
/*
import com.turksat.azerspace.azweb.entity.User;
import com.turksat.azerspace.azweb.repo.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@SpringBootTest

@AutoConfigureMockMvc
public class SpringBootIntegrationTest {

    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private UserRepository userRepo;

    @Test
    @DisplayName("Invalid-Login")
    public void loginWithInvalidUserThenUnauthenticated() throws Exception {
        FormLoginRequestBuilder login = formLogin()
                .user("invalid")
                .password("notvalid");

        mockMvc.perform(login)
                .andExpect(unauthenticated());
    }

    @Test
    @DisplayName("DefaultPage")
    public void testDefaultPage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("login/index"))

                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Resources-Unauthorized")
    public void accessUnsecuredResourceThenOk() throws Exception {
        mockMvc.perform(get("/css/main.css"))
                .andExpect(status().isOk());
    }


    @Test
    @DisplayName("User-Create")
    void testCreateUser() {
        User user = new User();
        user.setEmail("testuser@gmail.com");
        user.setPassword("testuser2022");
        user.setFirstName("test");
        user.setLastName("user");
        userRepo.save(user);
        User actual = userRepo.findByEmail("testuser@gmail.com");
        assertEquals(actual.getUserId(), user.getUserId());
        userRepo.delete(actual);
    }


}
*/