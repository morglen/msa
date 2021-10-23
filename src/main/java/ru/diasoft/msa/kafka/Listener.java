package ru.diasoft.msa.kafka;

import org.springframework.messaging.handler.annotation.MessageMapping;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Listener {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @MessageMapping(Channel.BROADCASTS)
    public void broadcasts(String message) {
        logger.log(Level.INFO, "Message from kafka topic: %s", message);
    }

}
