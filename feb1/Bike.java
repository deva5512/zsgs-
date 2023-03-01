package feb1;

public class Bike {
	String name;
	double run;
	double fuleconsume;

	public Bike(String name, double run, double fule) {
		this.name = name;
		this.run = run;
		this.fuleconsume = fule;
	}

	public String toString() {

		System.out.println(name);
		System.out.println(run);
		System.out.println(fuleconsume);

		return "";
	}
}
