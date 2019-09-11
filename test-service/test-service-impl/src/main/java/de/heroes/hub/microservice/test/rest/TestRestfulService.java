package de.heroes.hub.microservice.test.rest;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.heroes.hub.microservice.test.rest.item.GreetingResponseItem;

import java.util.concurrent.atomic.AtomicLong;

@Api(description = "Test Service")
@RestController
@RequestMapping("/webresources")
public class TestRestfulService {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    @ApiOperation(value = "hello world", position = 1)
    public GreetingResponseItem greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new GreetingResponseItem(
            counter.incrementAndGet(),
            String.format(template, name));
    }
}