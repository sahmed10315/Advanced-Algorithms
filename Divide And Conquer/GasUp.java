
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
import java.util.Random;

public class GasUp {
	private static class CityAndRemainingGas {
		public Integer city;
		public Integer remainingGallons;

		public CityAndRemainingGas(Integer city, Integer remainingGallons) {
			this.city = city;
			this.remainingGallons = remainingGallons;
		}
	}

	private static final int MPG = 20;

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
		Random gen = new Random();
		for (int times = 0; times < 1000; ++times) {
			int n;
			if (args.length == 1) {
				n = Integer.parseInt(args[0]);
			} else {
				n = gen.nextInt(10000) + 1;
			}
			List<Integer> gallons = new ArrayList<>(n);
			int sum = 0;
			for (int i = 0; i < n; ++i) {
				int x = gen.nextInt(200) + 1;
				sum += x;
				gallons.add(x);
			}
			List<Integer> distances = new ArrayList<>(n);
			sum -= n;
			for (int i = 0; i < n; ++i) {
				int x = 0;
				if (sum > 0) {
					x = gen.nextInt(sum) + 1;
				}
				distances.add(x + 1);
				sum -= x;
			}
			distances.set(distances.size() - 1, distances.get(distances.size() - 1) + sum);

			int c = findAmpleCity(gallons, distances);
			System.out.println("start city = " + c);
		}
	}
}