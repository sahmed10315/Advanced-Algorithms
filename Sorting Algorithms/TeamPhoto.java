
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Player implements Comparable<Player> {
	public Integer height;

	public Player(Integer h) {
		height = h;
	}

	@Override
	public int compareTo(Player that) {
		return Integer.compare(height, that.height);
	}
}

class Team {

	private List<Player> players;

	public Team(List<Integer> height) {
		players = new ArrayList<Player>(height.size());
		for (int i = 0; i < height.size(); ++i) {
			players.add(new Player(height.get(i)));
		}
	}

	// Checks if A can be placed in front of B.
	public static boolean validPlacementExists(Team A, Team B) {
		List<Player> ASorted = A.sortPlayersByHeight();
		List<Player> BSorted = B.sortPlayersByHeight();
		for (int i = 0; i < ASorted.size() && i < BSorted.size(); ++i) {
			if (ASorted.get(i).compareTo(BSorted.get(i)) >= 0) {
				return false;
			}
		}
		return true;
	}

	private List<Player> sortPlayersByHeight() {
		List<Player> sortedPlayers = new ArrayList<Player>(players);
		Collections.sort(sortedPlayers);
		return sortedPlayers;
	}
}

public class TeamPhoto {
	public static void main(String[] args) {
		List<Integer> height = null;
		height = Arrays.asList(0, 3, 2);
		Team t3 = new Team(height);
		height = Arrays.asList(1, 4, 2);
		Team t4 = new Team(height);
		Team.validPlacementExists(t4, t3);
	}
}