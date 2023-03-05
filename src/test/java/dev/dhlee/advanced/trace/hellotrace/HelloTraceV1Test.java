package dev.dhlee.advanced.trace.hellotrace;

import dev.dhlee.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloTraceV1Test {

    @Test
    void begin_end() {
        final HelloTraceV1 trace = new HelloTraceV1();
        final TraceStatus status = trace.begin("hello");
        trace.end(status);
    }

    @Test
    void begin_exception() {
        final HelloTraceV1 trace = new HelloTraceV1();
        final TraceStatus status = trace.begin("hello");
        trace.exception(status, new IllegalStateException());
    }
}