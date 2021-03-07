package com.oglcnarbc.kafka.producer.users.model.submodel;

import lombok.*;

/**
 * @author Ogulcan Arabaci
 */

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeInfo {

    private Long id;
    private EmployeeType employeeType;
    private Long endDate;
    private Long startDate;

}
