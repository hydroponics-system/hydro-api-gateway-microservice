package com.hydro;

import java.security.NoSuchAlgorithmException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Empty main for building out jar file.
 * 
 * @author Sam Butler
 * @since August 27, 2022
 */
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ServletComponentScan
public class HydroApiGatewayApplication {

	public static void main(String[] args) throws NoSuchAlgorithmException {}
}
