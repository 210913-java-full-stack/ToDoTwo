package com.Revature.ToDoTwo.beans.services;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class APIClientService {
    private static OkHttpClient apiClient = new OkHttpClient();
    private String APIKey;

    public APIClientService() {
        try {
            Properties props = new Properties();
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            InputStream fileIn = cl.getResourceAsStream("application.properties");
            props.load(fileIn);
            APIKey = props.getProperty("APIKey");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String url) {
        Request req = new Request.Builder().url(url).build();

        try(Response response = apiClient.newCall(req).execute()) {
            return response.body().string();

        } catch (IOException e) {
            //TODO: Set up file logger or AOP logging and invoke here instead of stack trace
            //e.printStackTrace();
        }
        return null;
    }

}
