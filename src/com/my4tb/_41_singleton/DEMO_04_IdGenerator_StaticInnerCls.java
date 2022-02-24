package com.my4tb._41_singleton;

import java.util.concurrent.atomic.AtomicLong;

public class DEMO_04_IdGenerator_StaticInnerCls {

    private final AtomicLong id = new AtomicLong(0);

    private DEMO_04_IdGenerator_StaticInnerCls() {}

    /**
     * 外部类DEMO_04_IdGenerator_StaticInnerCls加载时，SingletonHolder并不会加载
     * 只有当调用getInstance()时，SingletonHolder才会被加载
     *
     * instance的唯一性、创建期间的线程安全都由JVM保证
     */
    private static class SingletonHolder {
        private static final DEMO_04_IdGenerator_StaticInnerCls instance = new DEMO_04_IdGenerator_StaticInnerCls();
    }

    public static DEMO_04_IdGenerator_StaticInnerCls getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

}
