package com.oglcnarbc;

import com.intuit.karate.junit5.Karate;


/**
 * @author Ogulcan Arabaci
 */

public class KarateTestRunner extends BaseTest {

    @Karate.Test
    Karate executeAllTest() {
        return Karate.run().relativeTo(getClass());
    }

    @Karate.Test
    Karate executeKafkaProducerTestWithTag() {
        return new Karate()
                .feature("classpath:com/trendyol/mm/fleetmanagement/features/kafka")
                .tags("@kafka-producer")
                .relativeTo(getClass());

    }

    @Karate.Test
    Karate executeKafkaProducerTestWithFeatureName() {
        return new Karate()
                .feature("classpath:features/kafka")
                .relativeTo(getClass());
    }

}
