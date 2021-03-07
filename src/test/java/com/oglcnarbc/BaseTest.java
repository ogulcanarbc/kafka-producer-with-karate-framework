package com.oglcnarbc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

@Slf4j
public class BaseTest {

  @BeforeAll
  public static void before() {
    log.info("Test Before Run");
  }

  @AfterAll
  public static void after() {
    log.info("Test After Run");
  }
}