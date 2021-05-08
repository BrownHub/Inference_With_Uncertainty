
public abstract class Bag {
	private float bag_probability;
	private int c_probability;
	private int l_probability;
	
	public Bag(float bag, int c, int l) {
		bag_probability = bag;
		c_probability = c;
		l_probability = l;
	}
	
	public void update_bag_probability(char candy, float candy_probability) {
		int candy_given_bag;
		
		if (candy == 'C') {
			candy_given_bag = c_probability;
		} else {
			candy_given_bag = l_probability;
		}
	}
	
	public float get_bag_probability() {
		return bag_probability;
	}
	
	public int get_c_probability() {
		return c_probability;
	}
	
	public int get_l_probability() {
		return l_probability;
	}
	
}
