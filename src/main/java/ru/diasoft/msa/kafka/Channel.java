package ru.diasoft.msa.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;


public interface Channel {

    static final String BROADCASTS = "broadcasts";

    @Input(BROADCASTS)
    SubscribableChannel broadcasts();

}
