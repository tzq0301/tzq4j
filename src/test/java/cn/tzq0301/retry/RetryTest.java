package cn.tzq0301.retry;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

class RetryTest {
    @Test
    @Disabled
    void of() {
        Retry.of(time -> {
            System.out.println(time);
            return time == 4;
        }, 5, Duration.ofSeconds(1), true, true);
    }
}