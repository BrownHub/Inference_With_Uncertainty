public class Inference {
	private static String sequence;
	private static double c_probability;
	private static double l_probability;
	private static Bag[] bags;
	//private static Inference instance;
	
	/*
	private static Inference get_instance() {
		instance = new Inference();
		instance.sequence = new String();
		instance.c_probability = 0.0;
		instance.l_probability = 0.0;
		instance.bags = new Bag[5];
		return instance;
	}
	*/

	public static void error_msg() {
		System.out.println("Incorrect usage. Please enter only 1 argument consisting of the characters 'C' and/or 'L'.");
	}
	
	public static void update_c_probability() {
		double temp_probability = 0;
		for (Bag bag: bags) {
			temp_probability += bag.get_c_probability() * bag.get_bag_probability();
		}
		
		c_probability = temp_probability;
	}
	
	public static void update_l_probability() {
		double temp_probability = 0;
		for (Bag bag: bags) {
			temp_probability += bag.get_l_probability() * bag.get_bag_probability();
		}
		
		l_probability = temp_probability;
	}
	
	public static void update_probabilities(char candy) {
		double candy_probability;
		
		if (candy == 'C') {
			candy_probability = c_probability;
		} else {
			candy_probability = l_probability;
		}
		
		for (Bag bag: bags) {
			bag.update_bag_probability(candy, candy_probability);
		}
		
		update_c_probability();
		update_l_probability();
	}
	
	public static void display_results() {
		System.out.println("Observation sequence Q: " + sequence);
		System.out.println("Length of Q: " + sequence.length());
		System.out.println();
		System.out.println("P(h1|Q) = " + String.format("%6.5e", bags[0].get_bag_probability()));
		System.out.println("P(h2|Q) = " + String.format("%6.5e", bags[1].get_bag_probability()));
		System.out.println("P(h3|Q) = " + String.format("%6.5e", bags[2].get_bag_probability()));
		System.out.println("P(h4|Q) = " + String.format("%6.5e", bags[3].get_bag_probability()));
		System.out.println("P(h5|Q) = " + String.format("%6.5e", bags[4].get_bag_probability()));
		System.out.println();
		System.out.println("Probability that the next candy we pick will be C, given Q: " + String.format("%6.5e", c_probability));
		System.out.println("Probability that the next candy we pick will be L, given Q: " + String.format("%6.5e", l_probability));
	}
	
	public static void main(String[] args) {
		
		if (args.length == 1) {
			sequence = args[0].toUpperCase();
		} else {
			error_msg();
			return;
		}
		
		for (int i = 0; i < sequence.length(); i++) {
			if (sequence.charAt(i) != 'C' && sequence.charAt(i) != 'L') {
				error_msg();
				return;
			}
		}
		
		bags = new Bag[5];
		
		bags[0] = new Bag(0.1, 1.0, 0.0);
		bags[1] = new Bag(0.2, 0.75, 0.25);
		bags[2] = new Bag(0.4, 0.5, 0.5);
		bags[3] = new Bag(0.2, 0.25, 0.75);
		bags[4] = new Bag(0.1, 0.0, 1.0);
		
		
		update_c_probability();
		update_l_probability();
		
		for (int i = 0; i < sequence.length(); i++) {
			char candy = sequence.charAt(i);
			
			update_probabilities(candy);
		}
		
		display_results();
	}

}
