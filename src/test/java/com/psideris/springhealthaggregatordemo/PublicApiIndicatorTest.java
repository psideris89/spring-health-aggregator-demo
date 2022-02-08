package com.psideris.springhealthaggregatordemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.actuate.health.Health;

public class PublicApiIndicatorTest {

    // PublicApiIndicator requires BookHealthIndicator bean (Autowiring by constructor)
    private PublicApiIndicator publicApiIndicator;
    private BookHealthIndicator bookHealthIndicator;

    @Test
    public void test_up() {
        bookHealthIndicator = new BookHealthIndicator() {
            @Override
            public Health health() {
                return Health.up().build();
            }
        };
        publicApiIndicator = new PublicApiIndicator(bookHealthIndicator);

        Health health = publicApiIndicator.health();
        Assertions.assertEquals("UP", health.getStatus().getCode());
    }

    @Test
    public void test_down() {
        bookHealthIndicator = new BookHealthIndicator() {
            @Override
            public Health health() {
                return Health.down().build();
            }
        };
        publicApiIndicator = new PublicApiIndicator(bookHealthIndicator);

        Health health = publicApiIndicator.health();
        Assertions.assertEquals("DOWN", health.getStatus().getCode());
    }
}
