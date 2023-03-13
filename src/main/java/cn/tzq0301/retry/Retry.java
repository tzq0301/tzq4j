package cn.tzq0301.retry;

import lombok.SneakyThrows;

import java.time.Duration;
import java.util.Random;
import java.util.function.Function;

public final class Retry {
    private Retry() {}

    @SneakyThrows
    public static void of(Function<Integer, Boolean> task, int times, Duration interval) {
        of(task, times, interval, false, false);
    }

    @SneakyThrows
    public static void of(Function<Integer, Boolean> task, int times, Duration interval, boolean useExponentialBackoff) {
        of(task, times, interval, useExponentialBackoff, false);
    }

    @SneakyThrows
    public static void of(Function<Integer, Boolean> task, int times, Duration interval, boolean useExponentialBackoff, boolean useJitter) {
        int epoch = 1;
        while (times > 0) {
            boolean result = task.apply(epoch);
            if (result) {
                return;
            }
            long sleepDuration = interval.toMillis();
            if (useExponentialBackoff) {
                sleepDuration *= (long) Math.pow(2, epoch - 1);
            }
            if (useJitter) {
                Random random = new Random();
                long jitter = random.nextLong(interval.toMillis());
                if (random.nextBoolean()) {
                    sleepDuration += jitter;
                } else {
                    sleepDuration -= jitter;
                }
            }
            Thread.sleep(sleepDuration);
            ++epoch;
            --times;
        }
    }
}
