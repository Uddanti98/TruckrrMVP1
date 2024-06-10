package com.truckrr.TruckrrMvp1;

import org.apache.logging.log4j.*;


public class TruckrrMvp1Logger {
	
	// Initialize a Logger object for the class
	public static final Logger logger = LogManager.getLogger(TruckrrMvp1Logger.class);

    public static void main(String[] args) {
        // Example logging
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");
    }

}