package com.oglcnarbc.kafka.producer.users.model;

import com.oglcnarbc.kafka.producer.users.model.submodel.EmployeeInfo;
import lombok.*;

import java.util.List;

/**
 * @author Ogulcan Arabaci
 */

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserCreatedEvent {

    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private List<EmployeeInfo> employeeInfoList;
}
