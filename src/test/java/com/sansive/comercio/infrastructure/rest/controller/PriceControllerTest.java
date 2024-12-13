package com.sansive.comercio.infrastructure.rest.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPriceAt10amOn14thForProduct35455AndBrand1() throws Exception {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0, 0, 0);
        Long productId = 35455L;
        Long brandId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices")
                        .param("applicationDate", date.toString())
                        .param("productId", productId.toString())
                        .param("brandId", brandId.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", equalTo(35.50)));
    }

    @Test
    public void testPriceAt4pmOn14thForProduct35455AndBrand1() throws Exception {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 16, 0, 0, 0);
        Long productId = 35455L;
        Long brandId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices")
                        .param("applicationDate", date.toString())
                        .param("productId", productId.toString())
                        .param("brandId", brandId.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", equalTo(25.45)));
    }

    @Test
    public void testPriceAt9pmOn14thForProduct35455AndBrand1() throws Exception {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 21, 0, 0, 0);
        Long productId = 35455L;
        Long brandId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices")
                        .param("applicationDate", date.toString())
                        .param("productId", productId.toString())
                        .param("brandId", brandId.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", equalTo(35.50)));
    }

    @Test
    public void testPriceAt10amOn15thForProduct35455AndBrand1() throws Exception {
        LocalDateTime date = LocalDateTime.of(2020, 6, 15, 10, 0, 0, 0);
        Long productId = 35455L;
        Long brandId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices")
                        .param("applicationDate", date.toString())
                        .param("productId", productId.toString())
                        .param("brandId", brandId.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", equalTo(30.50)));
    }

    @Test
    public void testPriceAt9pmOn16thForProduct35455AndBrand1() throws Exception {
        LocalDateTime date = LocalDateTime.of(2020, 6, 16, 21, 0, 0, 0);
        Long productId = 35455L;
        Long brandId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices")
                        .param("applicationDate", date.toString())
                        .param("productId", productId.toString())
                        .param("brandId", brandId.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", equalTo(38.95)));
    }
}
