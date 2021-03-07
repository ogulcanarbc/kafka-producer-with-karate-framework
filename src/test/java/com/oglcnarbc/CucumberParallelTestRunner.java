package com.oglcnarbc;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ogulcan Arabaci
 */

@RunWithCucumber
public class CucumberParallelTestRunner extends BaseTest {

    String karateOutputPath = "target/surefire-reports";

    protected void generateReport(String karateOutputPath) {

        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
        ArrayList<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"), "kafka-producer-with-karate");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }

    @Test
    public void executeParallelAllTest() {
        Results results = Runner.parallel(getClass(), 5, karateOutputPath);
        generateReport(karateOutputPath);
        assertEquals(results.getFailCount(), 0, results.getErrorMessages());
    }

    @Test
    public void executeParallelKafkaProducerTest() {
        Results results = Runner.parallel(karateOutputPath, 5, "@kafka-producer");
        generateReport(karateOutputPath);
        assertEquals(results.getFailCount(), 0, results.getErrorMessages());
    }

}
