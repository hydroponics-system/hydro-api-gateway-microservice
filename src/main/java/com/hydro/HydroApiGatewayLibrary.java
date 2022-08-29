package com.hydro;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * API Gateway setup class for performing scan of filters and packages needed.
 * 
 * @author Sam Butler
 * @since August 27, 2022
 */
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ServletComponentScan
public class HydroApiGatewayLibrary {}
