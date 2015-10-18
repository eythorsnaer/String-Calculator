package is.ru.stringcalculator;

public class Calculator { 
	private static int toInt(String num){
		return Integer.parseInt(num);
	}

	public static int add(String text){
		if(text == "") {
			return 0;
		}
		if(text.length() == 1) {
			return toInt(text);
		}
		
		return sum(splitNumbers(text));
	}

	private static String[] splitNumbers(String text) {
		if(text.charAt(0) == '/' && text.charAt(1) == '/') {
			String[] temp = text.split("[\\n]", 2);
			Character delimiter = temp[0].charAt(2);
			
			return temp[1].split("[,\\n" + delimiter + "]");
		}
		else {
			return text.split("[,\\n]");
		}
				
	}

	private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }
	
	 
	public static void main(String args[]) {
		
	}
}
