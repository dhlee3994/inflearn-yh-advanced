package dev.dhlee.advanced.trace.treadlocal;

import dev.dhlee.advanced.trace.treadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalServiceTest {

    private final ThreadLocalService service = new ThreadLocalService();


    @Test
    void field() {
        log.info("main start");

        final Runnable userA = () -> service.logic("userA");
        final Runnable userB = () -> service.logic("userB");

        final Thread threadA = new Thread(userA);
        final Thread threadB = new Thread(userB);

        threadA.setName("thread-A");
        threadB.setName("thread-B");

        threadA.start();
        sleep(100);
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
