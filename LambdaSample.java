import java.util.function.Function;
import java.util.stream.IntStream;


public class LambdaSample {

	public static void main(String[] args) {
		Function<Integer, Integer> twice = x -> x ^ 2;

		System.out.println(IntStream.range(1, 10).map(x -> x * x).sum());


		BiIntFunction func = (x, y) -> x * y;

		System.out.println(func.apply(3, 7));
	}
}


@FunctionalInterface
interface BiIntFunction {
	int apply(int x, int y);
}
