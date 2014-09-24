import java.util.Map;
import java.util.TreeMap;
import java.util.StringJoiner;
import java.util.function.BiFunction;


public class MapSample {

	public static void main(String[] args) {
		Map<String, Integer> map = new TreeMap<String, Integer>() {
			{
				put("apple" , 150);
				put("lemon" ,  98);
				put("melon" , 450);
				put("orange",  50);
			}
		};

		printAll(map);

		map.replaceAll((k, v) -> (int)Math.round(v * 1.1));
		printAll(map);

		map.computeIfAbsent("grape", k -> 198);
		printAll(map);

		map.computeIfPresent("lemon", (k, v) -> v / 2);
		printAll(map);

		BiFunction<String, Integer, Integer> funcRaiseAppleOrAdd = (k, v) -> v != null ? v + 20 : 200;

		map.compute("apple", funcRaiseAppleOrAdd);
		printAll(map);

		map.remove("apple");
		System.out.println("'apple' removed.");
		map.compute("apple", funcRaiseAppleOrAdd);
		printAll(map);

		map.merge("orange", 30, (vOrig, vNew) -> Math.min(vOrig, vNew));
		printAll(map);
	}

	private static <K, V> void printAll(Map<K, V> map) {
		StringJoiner sj = new StringJoiner(", ");
		map.forEach((k, v) -> sj.add(String.format("%s: %s", String.valueOf(k), String.valueOf(v))));
		System.out.println(sj);
	}
}
