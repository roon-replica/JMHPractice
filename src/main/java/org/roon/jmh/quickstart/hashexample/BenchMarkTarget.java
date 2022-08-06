//package org.roon.jmh.quickstart.hashexample;
//
//import org.openjdk.jmh.annotations.*;
//
//import java.nio.charset.Charset;
//
//public class BenchMarkTarget {
//    @Warmup(iterations = 2)
//    @Fork(warmups = 2, value = 1)
//    @BenchmarkMode(Mode.Throughput)
//    @Benchmark
//    public void benchmarkMurmur3_128(ExecutionPlan executionPlan){
//        for(int i=0; i< executionPlan.iterations; i++){
//            executionPlan.murmur3.putString(executionPlan.password, Charset.defaultCharset());
//        }
//
//        executionPlan.murmur3.hash();
//    }
//}
