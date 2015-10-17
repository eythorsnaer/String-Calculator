package is.ru.stringcalculator;

public class Calculator { 
	private static int toInt(String num){
		return Integer.parseInt(num);
	}

	public static int add(String text){
		if(text == "") {
			return 0;
		}
		else if(text.contains(",")) {
			return sum(splitNumbers(text));
		}
		else {
			return toInt(text);
		}
	}

	private static String[] splitNumbers(String text) {
		return text.split(",");
	}

	private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }
}