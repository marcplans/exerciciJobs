package com.jobs.tools;

import java.util.List;

public class Tools {

	// Returns a given string repeated a number of times.
	public static String repeatString(String toRepeat,
		int repetitions) {
		String output = "";
		for (int i = 0; i < repetitions; i++) {
			output += toRepeat;
		}
		return output;
	}

	// Returns a given a string with leading spaces
	// so that matches a desired string length.
	public static String leadingString(String inputString,
		int desiredLength) {
		int currentLength = inputString.length();
		if (desiredLength <= currentLength) {
			return inputString;
		}
		return repeatString(" ", desiredLength - currentLength)
			+ inputString;
	}

	// Returns a given string with trailing spaces
	// so that matches a desired string length.
	public static String trailingString(String inputString,
		int desiredLength) {
		int currentLength = inputString.length();
		if (desiredLength <= currentLength) {
			return inputString;
		}
		return inputString
			+ repeatString(" ", desiredLength - currentLength);
	}

	// Returns line of given strings space separated according
	// to given spacings array, underlined.
	public static String tableHeader(List<String> strings,
		List<Integer> stringSpacing) {
		String outputString = stringLine(strings, stringSpacing);
		return outputString + "\n"
			+ repeatString("-", outputString.length());
	}

	// Returns line of given strings space separated according
	// to given spacings array. Negative spacing adds leading
	// spaces and positive ones adds trailing spaces.
	public static String stringLine(List<String> strings,
		List<Integer> stringSpacing) {
		String outputString = "";
		if (strings.size() != stringSpacing.size()) {
			return outputString;
		}
		for (int i = 0; i < strings.size(); i++) {
			if (stringSpacing.get(i) < 0) {
				outputString += leadingString(strings.get(i),
					Math.abs(stringSpacing.get(i)));
			} else {
				outputString += trailingString(strings.get(i),
					stringSpacing.get(i));
			}
		}
		return outputString;
	}

}
