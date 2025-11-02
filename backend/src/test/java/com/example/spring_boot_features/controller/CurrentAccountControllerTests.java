package com.example.spring_boot_features.controller;

import com.example.spring_boot_features.model.CurrentAccount;
import com.example.spring_boot_features.model.Person;
import com.example.spring_boot_features.service.ICurrentAccountService;
import com.example.spring_boot_features.service.ICustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CurrentAccountController.class)
class CurrentAccountControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICurrentAccountService currentAccountService;

    @MockBean
    private ICustomerService customerService;

    @BeforeEach
    void setup() {
        Mockito.when(customerService.checkCustomerExists(1L)).thenReturn(true);
        Mockito.when(currentAccountService.listUserCurrentAccounts(1L))
                .thenReturn(List.of(new CurrentAccount(10L, 100.0, new Person())));
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    void testListCurrentAccountsForUser_authenticated() throws Exception {
        mockMvc.perform(get("/api/current-accounts/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(10L))
                .andExpect(jsonPath("$[0].balance").value(100.0));
    }

    @Test
    void testListCurrentAccountsForUser_unauthenticated() throws Exception {
        mockMvc.perform(get("/api/current-accounts/1"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    void testTransferFunds_authenticated() throws Exception {
        mockMvc.perform(post("/api/current-accounts/transfer")
                        .with(csrf())
                        .contentType("application/x-www-form-urlencoded")
                        .param("fromAccountId", "10")
                        .param("toAccountId", "20")
                        .param("amount", "50"))
                .andExpect(status().isOk());

        Mockito.verify(currentAccountService).withdraw(50.0, 10L);
        Mockito.verify(currentAccountService).deposit(50.0, 20L);
    }

    @Test
    void testTransferFunds_unauthenticated() throws Exception {
        mockMvc.perform(post("/api/current-accounts/transfer")
                        .with(csrf())
                        .contentType("application/x-www-form-urlencoded")
                        .param("fromAccountId", "10")
                        .param("toAccountId", "20")
                        .param("amount", "50"))
                .andExpect(status().isUnauthorized());
    }
}