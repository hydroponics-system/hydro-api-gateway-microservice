package com.hydro.api.gateway.validators;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletRequest;

import com.hydro.api.gateway.validator.EndpointInboundValidator;
import com.hydro.common.jwt.utility.JwtHolder;
import com.hydro.test.factory.annotations.HydroServiceTest;

/**
 * Test for Endpoint Inbound Validator.
 * 
 * @author Sam Butler
 * @since August 25, 2022
 */
@HydroServiceTest
public class EndpointInboundValidatorTest {

    @Mock
    private JwtHolder jwtHolder;

    @InjectMocks
    private EndpointInboundValidator endpointInboundValidator;

    @Test
    public void testShouldNotFilterRequest() {
        MockHttpServletRequest req = new MockHttpServletRequest();
        req.setServletPath("/api/authenticate");
        req.setMethod("POST");

        endpointInboundValidator.validateRequest(req);
        verify(jwtHolder, never()).setToken(anyString());
    }
}
