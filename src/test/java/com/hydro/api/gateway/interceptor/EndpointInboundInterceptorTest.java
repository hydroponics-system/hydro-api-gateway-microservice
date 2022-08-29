package com.hydro.api.gateway.interceptor;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;

import com.hydro.api.gateway.validator.EndpointInboundValidator;
import com.hydro.common.annotations.interfaces.ControllerJwt;
import com.hydro.common.jwt.utility.JwtHolder;
import com.hydro.test.factory.abstracts.BaseControllerTest;
import com.hydro.test.factory.annotations.HydroRestTest;

/**
 * Test for Endpoint Inbound Interceptor.
 * 
 * @author Sam Butler
 * @since August 25, 2022
 */
@HydroRestTest
public class EndpointInboundInterceptorTest extends BaseControllerTest {

    @SpyBean
    private EndpointInboundValidator endpointValidator;

    @SpyBean
    private JwtHolder jwtHolder;

    @Test
    @ControllerJwt
    public void testDoFilterForInvalidRequestPath() {
        check(get("/invalid"), error(HttpStatus.NOT_FOUND));
        verify(endpointValidator, never()).validateRequest(any());
    }

    @Test
    @ControllerJwt
    public void testDoFilterValidRequestPath() {
        check(get("/api/test"), error(HttpStatus.NOT_FOUND));
        verify(endpointValidator).validateRequest(any(HttpServletRequest.class));
        verify(jwtHolder).clearToken();
    }

    @Test
    public void testDoFilterMissingToken() {
        check(get("/api/test"), error(HttpStatus.UNAUTHORIZED, "Missing JWT Token."));
        verify(endpointValidator).validateRequest(any(HttpServletRequest.class));
        verify(jwtHolder).clearToken();
    }
}
