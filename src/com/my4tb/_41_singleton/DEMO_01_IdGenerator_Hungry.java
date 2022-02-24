package com.my4tb._41_singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 饿汉 单例
 */
public class DEMO_01_IdGenerator_Hungry {

    private final AtomicLong id = new AtomicLong(0);

    /**
     * 类加载期间，instance静态实例就已经创建好并初始化完成，这可以保证instance实例创建过程是现成安全的
     */
    private static final DEMO_01_IdGenerator_Hungry instance = new DEMO_01_IdGenerator_Hungry();

    /**
     * 不对外暴露构造方法
     */
    private DEMO_01_IdGenerator_Hungry() {
    }

    public static DEMO_01_IdGenerator_Hungry getInstance() {
        return instance;
    }

    public Long getId() {
        return id.incrementAndGet();
    }

}