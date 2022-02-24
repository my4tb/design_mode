package com.my4tb._41_singleton;

import java.util.concurrent.atomic.AtomicLong;

public enum DEMO_05_IdGenerator_Enum {

    INSTANCE;

    private final AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.getAndIncrement();
    }

}
