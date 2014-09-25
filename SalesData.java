import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;


public class SalesData {

	public static void main(String[] args) {
		List<SalesData> salesDataList = createSalesDataList();

		int maxSalesAmount = salesDataList.parallelStream()
			.filter(salesData -> "東京".equals(salesData.getLocation()))
			.mapToInt(salesData -> salesData.getSalesAmount())
			.max().getAsInt()
			;

		/*
		int maxSalesAmount = Integer.MIN_VALUE;
		for (SalesData salesData : salesDataList) {
			if ("東京".equals(salesData.getLocation()) && salesData.getSalesAmount() > maxSalesAmount) {
				maxSalesAmount = salesData.getSalesAmount();
			}
		}
		*/

		System.out.println("maxSalesAmount = " + maxSalesAmount);
	}


	private static final int[] SALES_AMOUNTS = {
		1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000
	};

	private static final String[] LOCATIONS = {
		"東京", "千葉", "埼玉", "神奈川", "茨城", "栃木", "群馬"
	};

	private static List<SalesData> createSalesDataList() {
		List<SalesData> salesDataList = new ArrayList<>();

		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(2014, 1, 1);

		for (int i = 0; i < 100_000; i++) {
			Date salesDate = calendar.getTime();
			for (int salesAmount : SALES_AMOUNTS) {
				for (String location : LOCATIONS) {
					salesDataList.add(new SalesData(salesDate, salesAmount, location));
				}
			}
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}

		return salesDataList;
	}


    private final Date date;
    private final int salesAmount;
    private final String location;
    
    public SalesData(Date date, int salesAmount, String location){
        this.date = date;
        this.salesAmount = salesAmount;
        this.location = location;
    }

    public Date getDate() {
		return date;
	}

    public int getSalesAmount() {
		return salesAmount;
	}

    public String getLocation() {
		return location;
	}
}
