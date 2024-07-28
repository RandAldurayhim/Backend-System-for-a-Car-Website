package com.udacity.pricing;

import com.udacity.pricing.api.PricingController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(PricingController.class )
public class PricingControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetPrice() throws Exception {

        // Test successful response
        mockMvc.perform(get("/services/price?vehicleId=1"))
                .andExpect(status().isOk());

        // Test error response
        mockMvc.perform(get("/services/price?vehicleId=200"))
                .andExpect(status().isNotFound());

    }

}
