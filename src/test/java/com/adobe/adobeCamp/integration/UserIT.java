package com.adobe.adobeCamp.integration;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mystageservice.controllers.UserController;
import mystageservice.domain.Critique;
import mystageservice.domain.User;
import mystageservice.dto.UserOutputDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.*;

@SpringBootTest
@NoArgsConstructor
public class UserIT {

    private UserController userController;

    @Test
    public void test_userComponent() {
        ResponseEntity<?> getUserResponse = userController.getUsers();

        assertNotNull("response should not be null", getUserResponse);
        assertEquals("wrong http status code", SC_OK, getUserResponse.getStatusCode().value());
        assertNotNull("response body should not be null", getUserResponse.getBody());

        assertTrue("wrong response body type", getUserResponse.getBody() instanceof List);
        List<UserOutputDto> result = (List<UserOutputDto>) getUserResponse.getBody();
        assertTrue("customers list should be empty", result.isEmpty());

        Critique critique = Critique.builder().name("Alin").phoneNumber("07123456789").build();
        ResponseEntity<?> addCustomerResponse = userController.createNewUser(critique);

        assertNotNull("response should not be null", addCustomerResponse);
        assertEquals("wrong http status code", SC_OK, addCustomerResponse.getStatusCode().value());
        assertTrue("wrong response body type", addCustomerResponse.getBody() instanceof Critique);

        User added = (User) addCustomerResponse.getBody();
        assertEquals("wrong customer name", "Alin", added.getName());
        assertEquals("wrong customer phone", "07123456789", added.getPhoneNumber());

        // get the customer
        String alin = added.getName();
        ResponseEntity<?> getCustomerResponse = null;
        try {
            getCustomerResponse = userController.getUser(alin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("wrong http status code", SC_OK, getCustomerResponse.getStatusCode().value());
        assertTrue("wrong response body type", getCustomerResponse.getBody() instanceof UserOutputDto);

        UserOutputDto getIon = (UserOutputDto) getCustomerResponse.getBody();
        assertEquals("wrong customer name", "Ion", getIon.getName());

        // add the same customer and check that 400 is returned
        addCustomerResponse = userController.createNewUser(critique);
        assertEquals("wrong http status code", SC_BAD_REQUEST, addCustomerResponse.getStatusCode().value());
        assertEquals("wrong response body", "Customer already exists!", addCustomerResponse.getBody());
    }

}
