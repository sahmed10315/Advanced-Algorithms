
/*
@summary
In the gasup problem, a number of cities are arranged on a circular road.
You need to visit all the cities and come back to the starting city.
A certain amount of gas is available at each city.
The amount of gas summed up over all cities
is equal to the amount of gas required to go around the road once.
Your gas tank has unlimited capacity. Call a city {\em ample} if you can begin
at that
city with an empty tank,
refill at it, then travel through all the remaining cities, refilling at each,
and return to
the ample city, without running out of gas at any point.
@problem
Given an instance of the gasup problem, how would you efficiently compute an
ample city, if one exists?
*/

import java.util.ArrayList;
import java.util.List;

public class GasUp {
	private static class CityAndRemainingGas {
		public Integer city;
		public Integer remainingGallons;

		public CityAndRemainingGas(Integer city, Integer remainingGallons) {
			this.city = city;
			this.remainingGallons = remainingGallons;
		}
	}

	private static final int MPG = 1;

	// gallons[i] is the amount of gas in city i, and distances[i] is the
	// distance
	// city i to the next city.
	public static int findAmpleCity(List<Integer> gallons, List<Integer> distances) {
		int remainingGallons = 0;
		CityAndRemainingGas min = new CityAndRemainingGas(0, 0);
		final int numCities = gallons.size();
		for (int i = 1; i < numCities; ++i) {
			remainingGallons += gallons.get(i - 1) - distances.get(i - 1) / MPG;
			if (remainingGallons < min.remainingGallons) {
				min = new CityAndRemainingGas(i, remainingGallons);
			}
		}
		return min.city;
	}

	public static void main(String[] args) {

		List<Integer> gallons = new ArrayList<>();
		gallons.add(300/20);
		gallons.add(1000/20);
		gallons.add(400/20);
		gallons.add(300/20);
		gallons.add(300/20);
		gallons.add(300/20);
		gallons.add(200/20);
		gallons.add(1000/20);
		gallons.add(400/20);
		gallons.add(1100/20);
		gallons.add(400/20);
		gallons.add(600/20);
		gallons.add(300/20);
		List<Integer> distances = new ArrayList<>();

		distances.add(15);
		distances.add(15);
		distances.add(15);
		distances.add(20);
		distances.add(25);
		distances.add(45);
		distances.add(10);
		distances.add(45);
		distances.add(65);
		distances.add(15);
		distances.add(30);
		distances.add(25);
		distances.add(35);
		int c = findAmpleCity(gallons, distances);
		System.out.println("start city = " + c);
	}
}