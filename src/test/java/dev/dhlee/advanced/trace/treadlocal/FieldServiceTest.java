package dev.dhlee.advanced.trace.treadlocal;

import dev.dhlee.advanced.trace.treadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

    private final FieldService fieldService = new FieldService();

    @Test
    void field() {
        log.info("main start");

        final Runnable userA = () -> fieldService.logic("userA");
        final Runnable userB = () -> fieldService.logic("userB");

        final Thread threadA = new Thread(userA);
        final Thread threadB = new Thread(userB);

        threadA.setName("thread-A");
        threadB.setName("thread-B");

        threadA.start();
        // sleep(2000); // 동시성 문제X
        sleep(100); // 동시성 문제O
        threadB.start();

        sleep(3000);
    }

    private void sleep(final int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
