package is.ru.stringcalculator;

public class Calculator { 

	public static int add(String text) {
		if(text == "") {
			return 0;
		}
		if(text.length() == 1) {
			return toInt(text);
		}
		
		return sum(splitNumbers(text));
	}

	private static void negativeNumberTest(String text) {
		if(text.contains("-")) {
			throw new IllegalArgumentException("negative numbers not allowed");
		}
	}

	private static String[] splitNumbers(String text) {
		if(text.charAt(0) == '/' && text.charAt(1) == '/' && text.charAt(2) == '[') {
			String[] temp = text.split("[\\n]", 2);

			String delimiter = "";

			for (int i = 3; i < temp[0].length()-1; i++) {
				delimiter += temp[0].charAt(i);
			}
			
			negativeNumberTest(temp[1]);
			return temp[1].split("[,\\n" + delimiter + "]");
		}
		else if(text.charAt(0) == '/' && text.charAt(1) == '/') {
			String[] temp = text.split("[\\n]", 2);
			Character delimiter = temp[0].charAt(2);
			
			negativeNumberTest(temp[1]);
			return temp[1].split("[,\\n\"" + delimiter + "\"]");
		}
		else {
			negativeNumberTest(text);
			return text.split("[,\\n]");

		}
				
	}

	private static int toInt(String num){
		return Integer.parseInt(num);
	}

	private static int CheckBiggerThanK(int num){
		if (num > 1000) {
        	return 0;
        }
        return num;
	}

	private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
        	int n = toInt(number);
		    total += CheckBiggerThanK(n);
		}
		return total;
    }
}
