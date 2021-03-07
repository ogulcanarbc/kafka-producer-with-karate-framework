package com.oglcnarbc.kafka.producer.users;

import com.oglcnarbc.kafka.producer.KafkaEventProducer;
import com.oglcnarbc.kafka.producer.users.model.UserCreatedEvent;
import com.oglcnarbc.kafka.producer.users.model.submodel.EmployeeInfo;
import com.oglcnarbc.kafka.producer.users.model.submodel.EmployeeType;
import com.oglcnarbc.util.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;

/**
 * @author Ogulcan Arabaci
 */

@Slf4j
public class UserCreatedEventProducer extends KafkaEventProducer {

    public UserCreatedEventProducer(String broker, String topic) {
        super(broker, topic);
    }

    public UserCreatedEvent produceUserCreatedEvent() {

        final EmployeeInfo employeeInfo = EmployeeInfo.builder()
                .id(1L)
                .employeeType(EmployeeType.ACCOUNTING)
                .startDate(DateUtil.getTodayEpochMiliSec())
                .endDate(DateUtil.getTodayEpochMiliSec() + 86400000L)
                .build();

        final UserCreatedEvent message = UserCreatedEvent.builder()
                .id(8181L)
                .userName("oglcnarbc")
                .firstName("Oğulcan")
                .lastName("Arabacı")
                .employeeInfoList(Collections.singletonList(employeeInfo))
                .build();

        sendMessage(message);
        return message;
    }

    public UserCreatedEvent produceUserCreatedEvent(Integer id, String userName) {

        final EmployeeInfo employeeInfo = EmployeeInfo.builder()
                .id(1L)
                .employeeType(EmployeeType.ACCOUNTING)
                .startDate(DateUtil.getTodayEpochMiliSec())
                .endDate(DateUtil.getTodayEpochMiliSec() + 86400000L)
                .build();

        final UserCreatedEvent message = UserCreatedEvent.builder()
                .id(8181L)
                .userName("oglcnarbc")
                .firstName("Oğulcan")
                .lastName("Arabacı")
                .employeeInfoList(Collections.singletonList(employeeInfo))
                .build();

        sendMessage(message);
        return message;
    }
}
