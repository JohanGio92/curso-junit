package com.geekshubsacademy.junit.v9;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TimeoutTest {

	@Rule
    public Timeout globalTimeout = Timeout.millis(500);

    @Test
    public void testFallaPorqueExcedeElTimeoutGlobalDeLaRegla() throws Exception {
        TimeUnit.MILLISECONDS.sleep(1000);
    }

    @Test(timeout = 200)
    public void testFallaPorqueExcedeElTimeoutIndicadoEnLaAnotacionTest() throws Exception {
        TimeUnit.MILLISECONDS.sleep(250);
    }
}
