package com.psideris.springhealthaggregatordemo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import static com.psideris.springhealthaggregatordemo.Utils.getRandomNumber;

@Component("bookService")
public class BookHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        int number = getRandomNumber();

        if (number > 5) {
            return Health.up().build();
        }

        return Health.down().withDetail("error", "Book was less than 5").build();
    }
}
