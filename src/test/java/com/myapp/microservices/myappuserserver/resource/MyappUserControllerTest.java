package com.myapp.microservices.myappuserserver.resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.myapp.microservices.myappuserserver.MyappUserController;
import com.myapp.microservices.myappuserserver.MyappUserService;


@RunWith(SpringRunner.class)
@WebMvcTest(MyappUserController.class)
public class MyappUserControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private MyappUserService myappUserService;

    

    @Test
    public void isHealthy() throws Exception {
        mvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    public void getSuppliersOfUser() throws Exception {
    	Mockito.when(myappUserService.findSuppliersByUser("myuser")).thenReturn(new ArrayList<>(
    		    Arrays.asList(100, 102)
    			));
       // Mockito.when(repository.findByFromAndTo("EUR", "INR")).thenReturn(new ExchangeValue(Long.getLong("1"), "EUR", "INR", BigDecimal.valueOf(80.00)));
        mvc.perform(get("/users")).andExpect(status().isOk());
    }
}