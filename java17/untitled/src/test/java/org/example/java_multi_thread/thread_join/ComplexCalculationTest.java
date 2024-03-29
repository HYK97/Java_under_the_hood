/*
package org.example.java_multi_thread.thread_join;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@State(Scope.Benchmark)
@Warmup(iterations = 10)
@Fork(1)
@Measurement(iterations = 10)
class ComplexCalculationTest {

    public static final int N = 10000;

    static List<Integer> sourceList = new ArrayList<>();

    @Setup
    public void setUp() {
        for (int i = 0; i < N; i++) {
            sourceList.add(i);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void useForEach(Blackhole blackhole) {
        List<Double> result = new ArrayList<>(sourceList.size() / 2 + 1);
        for (Integer i : sourceList) {
            if (i % 2 == 0) {
                result.add(Math.sqrt(i));
            }
        }
        blackhole.consume(result);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void useStream(Blackhole blackhole) {
        List<Double> result = sourceList.stream()
                .filter(i -> i % 2 == 0)
                .map(Math::sqrt)
                .collect(Collectors.toCollection(
                        () -> new ArrayList<>(sourceList.size() / 2 + 1)));
        blackhole.consume(result);
    }


}*/
