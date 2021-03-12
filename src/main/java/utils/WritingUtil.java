package utils;

public class WritingUtil {

	/**
	 * Repeats a given string a defined amount of times.
	 *
	 * @param text	 the given text to be repeated
	 * @param amount the number of times the string is to be repeated
	 * @return		 a string containing the given text repeated the defined amount of times
	 */
	public static String repeatString(String text, int amount) {
		String res = "", work = "";
		for(int i=0; i<amount; i++) {
			work = work.concat(text);
			res = work;
		}
		return res;
	}

	/**
	 * Counts the number of words in a given string.
	 *
	 * @param input the given text to be counted
	 * @return		the number of words in the given string
	 */
	public static int numOfWords(String input) {
		if (input.length() == 0) {
			return 0;
		} else {
			String[] words = input.split("\\s+");
			return words.length;
		}
	}

	public static String reverse(String input) {
		StringBuffer buffer = new StringBuffer(input);
		return buffer.reverse().toString();
	}
}
