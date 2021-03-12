package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MathUtil {

	/**
	 * Rounds a decimal value to the specified position.
	 *
	 * @param value  the decimal value provided
	 * @param places the decimal place that the number will be rounded to
	 * @return		 the number rounded to the specified position
	 */
	public static double round(double value, int places) {
		return Math.round(value * (Math.pow(10, places))) / (Math.pow(10, places));
	}

	/**
	 * Generates a random random number in the defined range.
	 *
	 * @param min the the lowest possible limit of the range
	 * @param max the highest possible limit of the range
	 * @return	  a random number within the range
	 */
	public static int random(int min, int max) {
		return (int) ((Math.random() * ((max + 1) - min)) + min);
	}

	/**
	 * Determines if given value is a prime number.
	 *
	 * @param num the given number to be tested
	 * @return	  whether the given number is a prime number
	 */
	public static boolean boolPrimeNum(int num) {
		boolean flag = false;
		for (int i = 2; i <= num/2; i++) {
			if (num % i == 0) {
				flag = true;
				break;
			}
		}
		if (!flag) return true;
		else return false;
	}

	public static double average(ArrayList<Integer> numbers) {
		double sum = 0;
		for (int e: numbers) sum += e;
		return sum / numbers.size();
	}

	public static int max(ArrayList<Integer> numbers) {
		int high = 0;
		for (int e: numbers) {
			if (e > high) high = e;
		}
		return high;
	}

	public static int min(ArrayList<Integer> numbers, int upperLimit) {
		int low = upperLimit;
		for (int e : numbers) {
			if (e < low) low = e;
		}
		return low;
	}

	public static int range(ArrayList<Integer> numbers, int upperLimit) {
		int min = new MathUtil().min(numbers, upperLimit);
		int max = new MathUtil().max(numbers);
		return max - min;
	}

	public static double median(ArrayList<Integer> numbers) {
		Collections.sort(numbers);
		if (numbers.size() % 2 == 0) {
			double x = numbers.get((numbers.size() / 2) - 1);
			double y = numbers.get(((numbers.size() / 2) + 1) - 1);
			return (x + y) / 2;
		} else return numbers.get(((numbers.size() + 1) / 2) - 1);
	}

	public static int mode(ArrayList<Integer> numbers) {
		int mode = numbers.get(0);
		int maxCount = 0;
		for (int i = 0; i < numbers.size(); i++) {
			int value = numbers.get(i);
			int count = 0;
			for (int j = 0; j < numbers.size(); j++) {
				if (numbers.get(j) == value) count++;
				if (count > maxCount) {
					mode = value;
					maxCount = count;
				}
			}
		}
		if (maxCount > 1) return  mode;
		return 0;
	}
}