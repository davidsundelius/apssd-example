package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void addShouldAddNumbers() {
		assertThat(Calculator.add(1, 1)).isEqualTo(2);
		assertThat(Calculator.add(-1, 1)).isEqualTo(0);
	}

	@Test
	void subtractShouldSubtractNumbers() {
		assertThat(Calculator.subtract(1, 1)).isEqualTo(0);
		assertThat(Calculator.subtract(-1, 1)).isEqualTo(-2);
	}

	@Test
	void multiplyShouldMultiplyNumbers() {
		assertThat(Calculator.multiply(1, 1)).isEqualTo(1);
		assertThat(Calculator.multiply(-1, 1)).isEqualTo(-1);
		assertThat(Calculator.multiply(2, 2)).isEqualTo(4);
	}

	@Test
	void divideShouldDivideNumbers() {
		assertThat(Calculator.divide(1, 1)).isEqualTo(1);
		assertThat(Calculator.divide(-1, 1)).isEqualTo(-1);
		assertThat(Calculator.divide(1, 2)).isEqualTo(0.5);
		assertThrows(ArithmeticException.class, () -> Calculator.divide(1, 0));
	}

}
