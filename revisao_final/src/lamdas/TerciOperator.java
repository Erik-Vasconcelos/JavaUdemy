package lamdas;

@FunctionalInterface
public interface TerciOperator<T, Y, R> {

	R apply(T arg1, Y arg2);
	
}
