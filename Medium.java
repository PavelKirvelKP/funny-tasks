import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Medium {
	
	// O(n^2) time complexity, O(n) space complexity
	public boolean canVisitAllRooms(int[][] rooms) {
		Queue<Integer> toVisit = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		for (Integer key : rooms[0]) {
			toVisit.offer(key);
		}
		visited.add(0);

		while (visited.size() < rooms.length && !toVisit.isEmpty()) {
			int nextKey = toVisit.poll();
			if(visited.add(nextKey)) {
				for (Integer key : rooms[nextKey]) {
					toVisit.offer(key);
				}
			}
		}

		return visited.size() == rooms.length;
	}
}
