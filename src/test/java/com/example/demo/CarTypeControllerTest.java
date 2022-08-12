package com.example.demo;

import com.example.demo.dto.CarTypeModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CarTypeControllerTest{



    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper;

    public CarTypeControllerTest(){
        mapper = new ObjectMapper();
    }
    @Test
    public void add() throws Exception{
        CarTypeModel carTypeModel = new CarTypeModel("Sedan");

        String jsonRequest = mapper.writeValueAsString(carTypeModel);//преобразует параметр body в JSON с помощью Jackson ObjectMapper

        mockMvc.perform( post("/cartype/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getAll() throws Exception{
        mockMvc.perform( get("/cartype/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getById() throws Exception{
        mockMvc.perform(get("/cartype/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void update() throws Exception{
        CarTypeModel carTypeModel = new CarTypeModel("Sedan");
        String jsonRequest = mapper.writeValueAsString((carTypeModel));

        mockMvc.perform(put("/cartype/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }
}