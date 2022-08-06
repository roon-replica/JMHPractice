package org.roon.jmh.quickstart.compilerTrick;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

public class BenchMarkTarget {
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(warmups = 1, value = 1)
    @Warmup(iterations = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void doNothing() {
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(warmups = 1, value = 1)
    @Warmup(iterations = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void createObject() {
         new Object();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(warmups = 1, value = 1)
    @Warmup(iterations = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void createObject(Blackhole blackhole) {
        blackhole.consume(new Object());
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(warmups = 1, value = 1)
    @Warmup(iterations = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public Object getObject() {
        return new Object();
    }

}
