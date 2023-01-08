package lamdas;

import java.util.Arrays;

@FunctionalInterface
public interface Python {

	void print(Object arg);
	
	default void print(Object... objects) {
		Arrays.stream(objects).forEach(e -> System.out.print(e + " "));
	}
}
