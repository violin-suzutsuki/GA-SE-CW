package com.SET08103.cw;

import com.SET08103.cw.data.DataHandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

/**
 * App.java
 *
 * This is the program entrypoint and contains code to connect to an SQL docker container.
 */

@SpringBootApplication
@RestController
public class App {
    public static void main(String[] args) {

        System.out.println("[*] Establishing connection to SQL database...");

        long Start = System.currentTimeMillis();

        DataHandler dataHandler = new DataHandler();
        boolean result = dataHandler.connect(100);

        if (result == false)
        {
            System.out.println("[-] Failed to connect to the database.");
            return;
        }

        System.out.println(String.format("[+] Established connection to the database! Took %sms", System.currentTimeMillis() - Start));

        SpringApplication.run(App.class, args);
    }
}
