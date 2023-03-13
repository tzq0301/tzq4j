package cn.tzq0301.check;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {

    @Test
    void check() {
        assertThrows(NullPointerException.class, () -> Checker.check(
                Checker.notNull(null),
                Checker.shouldBeTrue(false)
        ));

        assertThrows(IllegalArgumentException.class, () -> Checker.check(
                Checker.notNull(new Object()),
                Checker.shouldBeTrue(false)
        ));
    }

    @Test
    void notNull() {
        assertThrows(NullPointerException.class, () -> Checker.notNull(null).run());
    }

    @Test
    void shouldBeTrue() {
        assertThrows(IllegalArgumentException.class, () -> Checker.shouldBeTrue(false).run());
        assertThrows(IllegalArgumentException.class, () -> Checker.shouldBeTrue(false, "message %s %s", 1, 2).run());
    }

}