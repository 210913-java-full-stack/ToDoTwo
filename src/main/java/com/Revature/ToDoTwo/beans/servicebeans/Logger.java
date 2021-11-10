package com.Revature.ToDoTwo.beans.servicebeans;

import com.Revature.ToDoTwo.beans.entities.LogEntity;
import com.Revature.ToDoTwo.beans.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Transactional
public class Logger {
    private LogRepository repo;

    @Autowired
    public Logger(LogRepository repo) {
        this.repo = repo;
    }

    public void writeLog(String message, int level) {
        LogEntity logEntity = new LogEntity(getCurrentDateTime(), formatLogEntry(message), level);

        repo.save(logEntity);

    }


    private String getCurrentDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(System.currentTimeMillis());
    }

    private String formatLogEntry(String message){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String stackTrace = "";
        for(StackTraceElement element : stackTraceElements) {
            stackTrace += "\n" + element;
        }
        String stackInfo = stackTraceElements[2].toString();


        return String.format("[%s]  %s%n", stackTrace, message);
    }
}
