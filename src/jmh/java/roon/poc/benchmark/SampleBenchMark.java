package roon.poc.benchmark;

import java.util.ArrayList;
import java.util.List;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
public class SampleBenchMark {

	static List<Integer> sourceList = new ArrayList<>();

	@Setup
	public void setUp() {
		for (int i = 0; i < 10000; i++) {
			sourceList.add(i);
		}
	}

	@BenchmarkMode(Mode.AverageTime)
	@Benchmark
	public void useLoop(Blackhole blackhole) {
		var result = new ArrayList<>(sourceList.size() / 2 + 1);
		for (Integer i : sourceList) {
			if (i % 2 == 0) {
				result.add(Math.sqrt(i));
			}
		}
		blackhole.consume(result);
	}


	@BenchmarkMode(Mode.AverageTime)
	@Benchmark
	public void useStream(Blackhole blackhole) {
		List<Double> result = sourceList.stream()
				.filter(i -> i % 2 == 0)
				.map(Math::sqrt)
				.toList();

		blackhole.consume(result);
	}
}
