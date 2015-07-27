package org.example.logging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The Server Application receives log events.
 *
 * @since 0.0.1
 */
@SpringBootApplication
public class ServerApplication extends Thread {

    public static void main(String[] args) {

        SpringApplication.run(ServerApplication.class, args);
        new ServerApplication().run();
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
