package com.psideris.springhealthaggregatordemo;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import static com.psideris.springhealthaggregatordemo.Utils.getRandomNumber;

@Component("numberService")
public class NumberHealthIndicator extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) {
        int number = getRandomNumber();

        if (number > 5) {
            builder.up().build();
        } else {
            builder.down().withDetail("error", "Number was less than 5").build();
        }
    }
}
