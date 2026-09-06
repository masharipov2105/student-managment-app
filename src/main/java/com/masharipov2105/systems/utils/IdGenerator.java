package com.masharipov2105.systems.utils;

import java.util.concurrent.atomic.AtomicLong;

public final class IdGenerator {
    
    private static final AtomicLong idGenerator = new AtomicLong(1);
    
    private IdGenerator() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated!");
    }
    
    public static long generateId() {
        return idGenerator.getAndIncrement();
    }
    
    
    public static void reset() {
        idGenerator.set(1);
    }
}