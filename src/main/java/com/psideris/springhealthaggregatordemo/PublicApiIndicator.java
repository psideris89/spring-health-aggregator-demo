package com.psideris.springhealthaggregatordemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class PublicApiIndicator implements HealthIndicator {

    private final BookHealthIndicator bookHealthIndicator;

    public PublicApiIndicator(BookHealthIndicator bookHealthIndicator) {
        this.bookHealthIndicator = bookHealthIndicator;
    }

    @Override
    public Health health() {
        return bookHealthIndicator.health();
    }
}
