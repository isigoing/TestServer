package com.example.TestServer;

import java.util.concurrent.atomic.AtomicLong;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println("test");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping(value = "/data", consumes = "application/json", produces = "application/json")
    public String data(@RequestBody String string) throws ParseException {
        System.out.println(string);
        Object obj = new JSONParser().parse(string);
        JSONArray ja = (JSONArray) obj;
        System.out.println(ja);
        return string;
    }
}
