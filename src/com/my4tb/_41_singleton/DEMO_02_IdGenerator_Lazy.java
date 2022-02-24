package com.my4tb._41_singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 单例 懒汉
 */
public class DEMO_02_IdGenerator_Lazy {

    private final AtomicLong id = new AtomicLong(0);

    private static DEMO_02_IdGenerator_Lazy instance;

    private DEMO_02_IdGenerator_Lazy() {}

    public static synchronized DEMO_02_IdGenerator_Lazy getInstance() {
        // 延迟加载
        if (instance == null)
            instance = new DEMO_02_IdGenerator_Lazy();
        return instance;
    }

    public Long getId() {
        return id.incrementAndGet();
    }

}
