package org.roon.jmh.service;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.roon.jmh.JmhPracticeApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootTest
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
public class SampleBeanBenchMarkTest {
	private ConfigurableApplicationContext context;


	private SampleBean sampleBean;

	@Setup
	public void init() {
		context = SpringApplication.run(JmhPracticeApplication.class);
		context.registerShutdownHook();
		sampleBean = context.getBean(SampleBean.class);
	}

	@Benchmark
	public void benchmarkMyMethod() {
		sampleBean.test();
	}

	@Test
	public void executeJmhRunner() throws RunnerException {
		Options opt = new OptionsBuilder()
				// set the class name regex for benchmarks to search for to the current class
				.include("\\." + this.getClass().getSimpleName() + "\\.")
				.warmupIterations(2)
				.measurementIterations(2)
				// do not use forking or the benchmark methods will not see references stored within its class
				.forks(0)
				// do not use multiple threads
				.threads(1)
				.shouldDoGC(true)
				.shouldFailOnError(true)
				.resultFormat(ResultFormatType.JSON)
				.result("/dev/null") // set this to a valid filename if you want reports
				.shouldFailOnError(true)
				.jvmArgs("-server")
				.build();

		new Runner(opt).run();
	}
}
