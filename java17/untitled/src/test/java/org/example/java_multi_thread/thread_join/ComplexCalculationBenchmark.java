package org.example.java_multi_thread.thread_join;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.profile.SafepointsProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@State(Scope.Benchmark)
@Warmup(iterations = 5)
@Fork(1)
@Measurement(iterations = 10)
public class ComplexCalculationBenchmark {

    private ComplexCalculation complexCalculation;
    private BigInteger base;
    private List<BigInteger> power;

    @Setup
    public void setup() {
        complexCalculation = new ComplexCalculation();
        base = BigInteger.valueOf(5);
        power = IntStream.range(500000,500100).mapToObj(BigInteger::valueOf).collect(Collectors.toList());
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void singleThread(Blackhole blackhole) {
        BigInteger result = BigInteger.ZERO;
        for (BigInteger integer : power) {
            result = result.add(base.pow(integer.intValue()));
        }
        blackhole.consume(result);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void multiThread(Blackhole blackhole) throws InterruptedException, ExecutionException {
        blackhole.consume(complexCalculation.calculateResult(base, power));
    }

}