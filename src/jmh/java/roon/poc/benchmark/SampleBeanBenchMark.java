package roon.poc.benchmark;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.roon.jmh.JmhPracticeApplication;
import org.roon.jmh.service.SampleBean;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class SampleBeanBenchMark {

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

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder()
				.include(SampleBeanBenchMark.class.getSimpleName())
				.mode(Mode.Throughput)
				.forks(1)
				.warmupIterations(2)
				.measurementIterations(2)
				.build();

		new Runner(opt).run();
	}
}
