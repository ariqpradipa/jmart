package com.AriqJmartFA;

import com.AriqJmartFA.dbjson.JsonDBEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * praktikum oop
 *
 * @author Ariq Pradipa Santoso
 * @version 11/09/2021
 */

@SpringBootApplication

public class Jmart {

    /**
     * Main methods of Jmart
     *
     * @param args data
     */
    public static void main(String[] args) {

        JsonDBEngine.Run(Jmart.class);
        SpringApplication.run(Jmart.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));

    }
}