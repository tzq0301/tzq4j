package cn.tzq0301.program;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProgramUtilsTest {

    @Test
    @Disabled
    void getCurrentLineNumber() {
        assertEquals(11, ProgramUtils.getCurrentLineNumber().orElseThrow());
    }
}