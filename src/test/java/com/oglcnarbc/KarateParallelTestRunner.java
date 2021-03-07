package com.oglcnarbc;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ogulcan Arabaci
 */
public class KarateParallelTestRunner extends BaseTest {

    @Test
    void executeParallelAllTest() {
        Results results = Runner.path("classpath:com/oglcnarbc/features").tags("~@ignore").parallel(5);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }

    @Test
    void executeParallelKafkaProducerTest() {
        Results results = Runner.path("classpath:com/oglcnarbc/features").tags("@kafka-producer").parallel(5);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }
}
