public class Main {

	public static void error_msg() {
		System.out.println("Incorrect usage. Please enter only 1 argument consisting of the characters 'C' and/or 'L'.");
	}
	
	public static void main(String[] args) {
		String sequence = new String();
		
		if (args.length == 1) {
			sequence = args[0].toUpperCase();
		} else {
			error_msg();
			return;
		}
		
		for (int i = 0; i < sequence.length(); i++) {
			if (sequence.charAt(i) != 'C' || sequence.charAt(i) != 'L') {
				error_msg();
				return;
			}
		}

	}

}
