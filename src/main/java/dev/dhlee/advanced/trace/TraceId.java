package dev.dhlee.advanced.trace;

import lombok.Getter;

import java.util.UUID;

@Getter
public class TraceId {

    private final String id;
    private final int level;

    public TraceId() {
        this.id = creatId();
        this.level = 0;
    }

    private TraceId(final String id, final int level) {
        this.id = id;
        this.level = level;
    }

    private String creatId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public TraceId createNextId() {
        return new TraceId(id, level + 1);
    }

    public TraceId createPreviousId() {
        return new TraceId(id, level - 1);
    }

    public boolean isFirstLevel() {
        return level == 0;
    }
}
