package com.oglcnarbc.extensions;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;

@Slf4j
public class TestExecutionContext implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        Method testMethod = extensionContext.getRequiredTestMethod();
        Class<?> testClass = extensionContext.getRequiredTestClass();
        log.info(testClass.getName() + "." + testMethod.getName() + " --> Test Started.");
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        Method testMethod = extensionContext.getRequiredTestMethod();
        Class<?> testClass = extensionContext.getRequiredTestClass();
        log.info(testClass.getName() + "." + testMethod.getName() + " --> Test Ended.");
    }
}
