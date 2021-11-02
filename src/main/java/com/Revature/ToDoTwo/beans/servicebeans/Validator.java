package com.Revature.ToDoTwo.beans.servicebeans;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class Validator {
    private Validator validator;


    public Validator() {
    }

    public boolean validate(String pattern, String text) {
        return Pattern.compile(pattern).matcher(text).find();
    }
}
