import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;


public class ListSample {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(5, 4, 2, 10, 7, 3, 9, 8, 6, 1));

		printAll(list);

		list.removeIf(x -> x % 3 == 0);
		printAll(list);

		list.replaceAll(x -> x * 2);
		printAll(list);

		list.sort((x, y) -> y - x);
		printAll(list);
	}

	private static <T> void printAll(List<T> list) {
		StringJoiner sj = new StringJoiner(" ");
		list.forEach(x -> sj.add(String.valueOf(x)));
		System.out.println(sj);
	}
}
