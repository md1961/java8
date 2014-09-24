import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.IntSummaryStatistics;


public class Employee {

	private static List<Employee> employees = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("部長連:");
		employees.stream()
			.filter(e -> "部長".equals(e.getRole()))
			.forEach(e -> System.out.println(e.getName()));
		System.out.println();

		System.out.println("名前の List:");
		List<String> names = employees.stream()
			.map(e -> e.getName())
			.collect(Collectors.toList());
		System.out.println(String.join(", ", names));
		System.out.println();

		System.out.println("名前を列挙:");
		System.out.println(employees.stream()
			.map(e -> e.getName())
			.collect(Collectors.joining("、")));
		System.out.println();

		System.out.println("部ごとに表示:");
		Map<String, List<Employee>> mapByDept = employees.stream()
			.collect(Collectors.groupingBy(e -> e.getDept()));
		mapByDept.forEach((dept, employees) -> {
			System.out.println(dept);
			employees.forEach(e -> System.out.printf("- %s\n", e.getName()));
		});
		System.out.println();

		System.out.println("年齢を集計:");
		IntSummaryStatistics ageStats = employees.stream()
			.collect(Collectors.summarizingInt(e -> e.getAge()));
		System.out.printf("社員数　: %d\n", ageStats.getCount());
		System.out.printf("最低年齢: %d\n", ageStats.getMin());
		System.out.printf("最高年齢: %d\n", ageStats.getMax());
		System.out.printf("合計年齢: %d\n", ageStats.getSum());
		System.out.printf("平均年齢: %f\n", ageStats.getAverage());
	}


	private final String name;
	private final String role;
	private final String dept;
	private final Integer age;

	public Employee(String name, String role, String dept, Integer age) {
		this.name = name;
		this.role = role;
		this.dept = dept;
		this.age  = age ;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public String getDept() {
		return dept;
	}

	public Integer getAge() {
		return age;
	}

	static {
		employees.add(new Employee("スミス"      , "部長"  , "開発部"          , 54));
		employees.add(new Employee("ジョンソン"  , "平社員", "営発部"          , 29));
		employees.add(new Employee("ウィリアムズ", "課長"  , "開発部"          , 41));
		employees.add(new Employee("ブラウン"    , "主任"  , "開発部"          , 34));
		employees.add(new Employee("ジョーンズ"  , "部長"  , "人事部"          , 52));
		employees.add(new Employee("ミラー"      , "平社員", "マーケティング部", 24));
	}
}
