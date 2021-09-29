package com.sparta.logging;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggingMain {

    private static Logger logger = Logger.getLogger("My Application Logger");

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        LoggingMain.logger = logger;
    }
//    public static void main(String[] args) {
//        PropertyConfigurator.configure("log4j.properties");
//        logger.warn("Warning Message");
//        logger.trace("Trace Message");
//        logger.info("Info Message");
//        logger.error("Error Message");
//        logger.debug("Debug Message");
//        logger.fatal("Fatal Message");
//    }
}
