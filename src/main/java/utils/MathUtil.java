package utils;

import java.util.ArrayList;
import java.util.Collections;


public class MathUtil {

	/**
	 * Rounds a double value to the specified position.
	 *
	 * @param value  the decimal value provided
	 * @param places the decimal place that the number will be rounded to
	 * @return		 the number rounded to the specified position
	 */
	public static double round(double value, int places) {
		return Math.round(value * (Math.pow(10, places))) / (Math.pow(10, places));
	}

	/**
	 * Generates a random number in the defined range. (inclusive)
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
	 * @param value the given number to be tested
	 * @return	    whether the given number is a prime number
	 */
	public static boolean isPrime(int value) {
		boolean flag = false;
		for (int i = 2; i <= value / 2; i++) {
			if (value % i == 0) {
				flag = true;
				break;
			}
		}
		return !flag;
	}

	/**
	 * Finds all possible whole number division for the given value.
	 *
	 * @param value the given number to test
	 * @return      all divisors of the value excluding 1 and value
	 */
	public static ArrayList<Integer> getDivisors(int value) {
		ArrayList<Integer> divisors = new ArrayList<>();
		for (int i = 2; i <= (value / 2) + 1; i++) {
			if (value % i == 0) divisors.add(i);
		}
		return divisors;
	}

	/**
	 * Finds all prime numbers in a range. (Inclusive)
	 *
	 * @param min the lowest possible limit of the range
	 * @param max the highest possible limit of the range
	 * @return    all prime numbers in a range
	 */
	public static ArrayList<Integer> getPrimes(int min, int max) {
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = min; i <= max; i++) {
			if (isPrime(i)) nums.add(i);
		}
		return nums;
	}

	/**
	 * Finds the average of all the given values.
	 *
	 * @param values list of all values
	 * @return       the average of all the values
	 */
	public static double average(ArrayList<Integer> values) {
		double sum = 0;
		for (int e: values) sum += e;
		return sum / values.size();
	}

	/**
	 * Finds the highest value in a list of values.
	 *
	 * @param values list of all values
	 * @return       the largest integer value in the list
	 */
	public static int max(ArrayList<Integer> values) {
		int high = 0;
		for (int e: values) {
			if (e > high) high = e;
		}
		return high;
	}

	/**
	 * Finds the lowest value in a list of values.
	 *
	 * @param values list of all values
	 * @return       the smallest integer value in the list
	 */
	public static int min(ArrayList<Integer> values) {
		int low = values.get(0);
		for (int e : values) {
			if (e < low) low = e;
		}
		return low;
	}

	/**
	 * Finds the range of the given values.
	 *
	 * @param values list of all values
	 * @return       the range between the lowest and highest integer values
	 */
	public static int range(ArrayList<Integer> values) {
		int min = min(values);
		int max = max(values);
		return max - min;
	}

	/**
	 * Finds the median of the given values.
	 *
	 * @param values list of all values
	 * @return       the median value of all the values
	 */
	public static double median(ArrayList<Integer> values) {
		Collections.sort(values);
		if (values.size() % 2 == 0) {
			double x = values.get((values.size() / 2) - 1);
			double y = values.get(((values.size() / 2) + 1) - 1);
			return (x + y) / 2;
		} else return values.get(((values.size() + 1) / 2) - 1);
	}

	/**
	 * Finds the mode of the given values.
	 *
	 * @param values list of all values
	 * @return       the mode value of all the values
	 */
	public static int mode(ArrayList<Integer> values) {
		int mode = values.get(0);
		int maxCount = 0;
		for (int i = 0; i < values.size(); i++) {
			int value = values.get(i);
			int count = 0;
			for (Integer num : values) {
				if (num == value) count++;
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
