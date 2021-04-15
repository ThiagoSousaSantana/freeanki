package br.com.freeanki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"br.com.freeanki.repositories*"})
public class FreeAnkiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreeAnkiApplication.class, args);
    }
}
