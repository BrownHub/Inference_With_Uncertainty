public class Bag {
	private double bag_probability;
	private double c_probability;
	private double l_probability;
	
	public Bag(double bag, double c, double l) {
		bag_probability = bag;
		c_probability = c;
		l_probability = l;
	}
	
	public void update_bag_probability(char candy, double candy_probability) {
		double candy_given_bag;
		
		if (candy == 'C') {
			candy_given_bag = c_probability;
		} else {
			candy_given_bag = l_probability;
		}
		
		bag_probability = candy_given_bag * bag_probability / candy_probability;
	}
	
	public double get_bag_probability() {
		return bag_probability;
	}
	
	public double get_c_probability() {
		return c_probability;
	}
	
	public double get_l_probability() {
		return l_probability;
	}
	
}
