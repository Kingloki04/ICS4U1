package utils;

import java.math.BigInteger;

public class ConversionUtil {

	/**
	 * Converts a hexadecimal value into a decimal value.
	 *
	 * @param input hexadecimal value to be converted
	 * @return		decimal value equivalent to the given hexadecimal value
	 */
	public static int HexToDec(String input) {
		String dec = new BigInteger(input, 16).toString(1);
		int hex = Integer.parseInt(dec.trim());
		return hex;
	}

	/**
	 * Converts a binary value into a decimal value.
	 *
	 * @param input binary value to be converted
	 * @return		decimal value equivalent to the given binary value
	 */
	public static int BinToDec(int input) {
		return 0;
	}

	/**
	 * Converts a decimal value to a hexadecimal value.
	 *
	 * @param input decimal value to be converted
	 * @return		hexadecimal value equivalent to the given decimal value
	 */
	public static String DecToHex(int input) {
		String hexStr = Integer.toHexString(input);
		return hexStr;
	}

	/**
	 * Converts a string to an ASCII values
	 *
	 * @param str string to be converted
	 * @return	  ASCII value equivalent to the given string
	 */
	public static String stringToASCII(String str) {
		String res = "";
		for (int i = 0; i < str.length(); i++) {
			char character = str.charAt(i);
			int ascii = (int) character;
			res = res.concat(ascii + " ");
		}
		return res;
	}

	/**
	 * Converts a string to a binary value
	 *
	 * @param str string to be converted
	 * @return	  binary value equivalent to the given string
	 */
	public static String stringToBin(String str) {
		String res = "";
		for (int i = 0; i < str.length(); i++) {
			char character = str.charAt(i);
			int ascii = (int) character;
			res = res.concat(ascii + " ");
		}
		return res;
	}
}