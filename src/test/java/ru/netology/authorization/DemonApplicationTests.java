package ru.netology.authorization;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemonApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;


    private static GenericContainer<?> devapp = new GenericContainer<>("devapp")
            .withExposedPorts(8080);
    @Container
    private static GenericContainer<?> prodapp = new GenericContainer<>("prodapp")
            .withExposedPorts(8080);

    @BeforeAll
    static void setUp() {
        devapp.start();
        prodapp.start();
    }

    @Test
    public void contextLoads() {
        Integer devappPort = devapp.getMappedPort(8080);
        ResponseEntity<String> forEntity = restTemplate
                .getForEntity(
                        "http://localhost:" + devappPort, String.class);
        System.out.println(forEntity.getBody());
    }
}
