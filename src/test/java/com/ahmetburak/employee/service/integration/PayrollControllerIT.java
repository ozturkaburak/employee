package com.ahmetburak.employee.service.integration;

import com.ahmetburak.employee.dto.PayrollDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static com.ahmetburak.employee.util.TestUtil.EMPLOYEE_DTO;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ahmetburakozturk on 26.08.2022
 **/
@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PayrollControllerIT {

    private final PayrollDTO payrollDTO = PayrollDTO.builder()
            .employee(EMPLOYEE_DTO)
            .date(LocalDate.now())
            .salary(10000D)
            .build();

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    public void setUp() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    void testFindEmployeeOfTheMonth() throws Exception {
        String stringPayroll = objectMapper.writeValueAsString(payrollDTO);
        mockMvc.perform(MockMvcRequestBuilders.post("/payrolls")
                        .content(stringPayroll)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }
}
