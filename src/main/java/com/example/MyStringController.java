package com.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import java.util.List;

@Controller("/")
public class MyStringController {
    private final MyStringDAO myStringDAO = new MyStringDAO();

    @Get
    public List<String> getAllMyString() {
        return this.myStringDAO.getMyStrings();
    }

    @Get("/{myString}")
    public String getMyString(@QueryValue final String myString) {
        return this.myStringDAO.getMyString(myString);
    }

    @Get("/TestStrings")
    public List<String> getMyTestStrings() {
        return this.myStringDAO.getMyTestStrings();
    }

    @Put(consumes = MediaType.TEXT_PLAIN)
    public void postMyString(@Body final String myString) {
        this.myStringDAO.addMyString(myString);
    }

    @Delete("/{myString}")
    public void deleteMyString(@QueryValue final String myString) {
        this.myStringDAO.deleteMyString(myString);
    }
}
