package org.example.logging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @since 0.0.1
 */
@SpringBootApplication
@EnableScheduling
public class ClientApplication extends Thread {

    public static void main(String[] args) {

        SpringApplication.run(ClientApplication.class, args);

        new ClientApplication().run();
    }

    @Override
    public void run() {

        try {
            sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
