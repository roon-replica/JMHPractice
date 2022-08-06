package org.roon.jmh.quickstart.hashexample;

import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class ExecutionPlan {
    @Param({"100","200","500","1000"})
    public int iterations;

    public Hasher murmur3;

    public String password = "1a2a3a4a5a6a7a8a9a";

    @Setup(Level.Invocation)
    public void setUp(){
        murmur3 = Hashing.murmur3_128().newHasher();
    }
}
