
public class City {

	/**
	 * 
	 */

	private Road[] roads;
	private int numRoads;
	private String name;

	public City(String name) {
		this.name = name;
		this.numRoads = 0;
		this.roads = new Road[10];
	}

	public void connect(Road r) {
		/*
		 * adds the road to the array of roads 
		 */
		try {
			roads[this.numRoads++] = r;
		}
		catch (Exception e) {
			System.out.println("too many roads in the array");
		}
	}

	
	public City nearestCity() {
		City closest = roads[0].getCity1() == this ? roads[0].getCity1() : roads[0].getCity2();
		int distance = roads[0].getLength();
		for (int i = 1; i < this.numRoads; i++)
			if (roads[i].getLength() < distance) {
				distance = roads[i].getLength();
				closest = roads[i].getCity1() == this ? roads[i].getCity1() : roads[i].getCity2();
			}
		return closest;
	}
	

	public String toString() {
		return this.name;
	}

}
