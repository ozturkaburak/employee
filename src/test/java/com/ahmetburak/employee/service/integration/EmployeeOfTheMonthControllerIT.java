package com.ahmetburak.employee.service.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ahmetburakozturk on 26.08.2022
 **/
@SpringBootTest
@AutoConfigureMockMvc
class EmployeeOfTheMonthControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testFindEmployeeOfTheMonth() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/employeeOfTheMonth")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
}
