package org.ufrog;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MoneyLoan {
	private final static Map<Integer, Double> MONEY_RATE = new HashMap<Integer, Double>();

	static {
		MONEY_RATE.put(2012, 6.55);
		MONEY_RATE.put(2013, 6.55);
		MONEY_RATE.put(2014, 6.55);
		MONEY_RATE.put(2015, 6.15);
	}

	private Date startDate;

	private Date endDate;

	private double princinpal;

	private double interest;

	public String calculate() {
		Date date = new Date(startDate.getTime());
		double money = princinpal;
		int days = 0;
		while (date.before(endDate)) {
			money = money * (1 + getDayInterestRate(date));
			date.setTime(date.getTime() + 24 * 60 * 60 * 1000L);
			days++;
		}

		interest = money - princinpal;
		StringBuffer buf = new StringBuffer();
		buf.append("开始::").append(formatDay(startDate)).append("\t结束::").append(formatDay(endDate)).append("\t总天数::")
		      .append(days).append("\t本金::").append(princinpal).append("\t利息::").append(interest);
		return buf.toString();
	}

	private String formatDay(Date date) {
		StringBuffer buf = new StringBuffer();
		buf.append(date.getYear() + 1900).append("年").append(date.getMonth() + 1).append("月").append(date.getDate())
		      .append("日");
		return buf.toString();
	}

	public double getDayInterestRate(Date date) {
		int year = date.getYear() + 1900;
		double rate = 0;
		rate = MONEY_RATE.get(year);
		return rate * 1.1 * 0.8 / (double) (100 * 360);
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setMoney(double money) {
		this.princinpal = money;
	}

	public static void main(String[] args) {
		MoneyLoan moneyLoan = new MoneyLoan();
		
		System.out.println("2013年利率::"+6.55*1.1*0.8);
		System.out.println("2014年利率::"+6.55*1.1*0.8);
		System.out.println("2015年利率::"+6.15*1.1*0.8);

		// 10万, 2013-04-26到2015-09-30日
		moneyLoan.setMoney(100000);
		moneyLoan.setStartDate(new Date(2013 - 1900, 3, 26));
		moneyLoan.setEndDate(new Date(2015 - 1900, 8, 30));

		System.out.println(moneyLoan.calculate());

		// 10.9万, 2013-03-12到2015-09-30日
		moneyLoan.setMoney(109000);
		moneyLoan.setStartDate(new Date(2013 - 1900, 2, 12));
		moneyLoan.setEndDate(new Date(2015 - 1900, 8, 30));
		System.out.println(moneyLoan.calculate());
		
		// 3万, 2012-08-22到2015-09-30日
		moneyLoan.setMoney(30000);
		moneyLoan.setStartDate(new Date(2012 - 1900, 7, 22));
		moneyLoan.setEndDate(new Date(2015 - 1900, 8, 30));
		System.out.println(moneyLoan.calculate());
	}

}
