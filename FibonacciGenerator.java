import java.util.stream.LongStream;
import java.util.function.LongSupplier;


public class FibonacciGenerator implements LongSupplier {

	private static final int DEFAULT_LIMIT = 20;

	public static void main(String[] args) {
		int limit = DEFAULT_LIMIT;
		if (args.length >= 1) {
			limit = Integer.parseInt(args[0]);
		}

		LongStream.generate(new FibonacciGenerator())
			.limit(limit)
			.forEach(x -> System.out.print(x + " "));
		System.out.println();
	}

	private long m = 0;
	private long n = 1;

	public long getAsLong() {
		long retval = m;
		m = n;
		n = m + retval;

		return retval;
	}
}
