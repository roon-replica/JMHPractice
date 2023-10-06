package org.roon.jmh.service;

import org.springframework.stereotype.Service;

@Service
public class SampleBean {

	public int test() {
		int sum = 0;
		for (int i = 0; i < 10000; i++) {
			sum += i;
		}

		return sum;
	}

}
