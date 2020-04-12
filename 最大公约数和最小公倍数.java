package com.upon.option;

public class 最大公约数和最小公倍数 {
	public static void main(String[] args) {
		double i = execute(12, 18);
		System.out.println(i);
		double j = execute(30, 10);
		System.out.println(j);
	}

	public static double execute(double a, double b) {
		double tmp;
		double max = a > b ? a : b, min = a < b ? a : b;

		while (min != 0) {
			tmp = max % min;
			max = min;
			min = tmp;
		}
		return (a * b) / max;
	}
}
