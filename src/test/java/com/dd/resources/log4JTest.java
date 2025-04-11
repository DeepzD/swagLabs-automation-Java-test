package com.dd.resources;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class log4JTest {

        private final Logger logger = LogManager.getLogger(log4JTest.class);

        @Test
        public void testLog4J(){
                logger.info("Starting test execution");
                logger.debug("This is a debug message");
                logger.warn("This is a warning");
                logger.error("This is an error message");
                logger.info("Test execution completed");
                logger.fatal("Fatal issue");
                logger.trace("This is from trace log");


        }

}
