package com.my4tb._41_singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 单例 双重检查
 */
public class DEMO_03_IdGenerator_DoubleCheck {

    private AtomicLong id = new AtomicLong(0);

    /**
     * 这里使用volatile关键字，能够防止因为指令重排而导致的问题
     *
     * 实际上，jdk8已经能够确保new关键字的初始化操作是原子性的，不会出现之前因指令重排而导致的问题
     */
    private static volatile DEMO_03_IdGenerator_DoubleCheck instance;

    private DEMO_03_IdGenerator_DoubleCheck() {
    }

    public static DEMO_03_IdGenerator_DoubleCheck getInstance() {
        // 检查后如果为null，才做加锁操作
        if (instance == null) {
            synchronized (DEMO_03_IdGenerator_DoubleCheck.class) {
                // 加锁过程中，可能已经被初始化，因此做第二次检查
                if (instance == null) {
                    instance = new DEMO_03_IdGenerator_DoubleCheck();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.getAndIncrement();
    }

}
