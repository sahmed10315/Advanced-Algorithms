import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.Math.min;
 
public class JobSequencing implements Comparable<JobSequencing> {
	char id;
	int deadline, profit;

	public JobSequencing(char id, int dead, int profit) {
		this.id = id;
		this.deadline = dead;
		this.profit = profit;
	}

	@Override
	public int compareTo(JobSequencing o) {
		return o.profit - this.profit;
	}

	public static int findMaxDeadline(ArrayList<JobSequencing> jobs) {
		int max = Integer.MIN_VALUE;
		for (JobSequencing temp : jobs)
			max = Math.max(temp.deadline, max);
		System.out.println("max_dead:" + max);
		return max;
	}

	public static void printJobs(ArrayList<JobSequencing> jobs) {
		int maxDeadline = findMaxDeadline(jobs);

		boolean slots[] = new boolean[maxDeadline];
		char result[] = new char[maxDeadline];
		Arrays.fill(slots, false);
		Arrays.fill(result, '0');

		Collections.sort(jobs);

		for (JobSequencing job : jobs) {
			for (int j = min(maxDeadline, job.deadline) - 1; j >= 0; j--) {
				if (slots[j] == false) {
					System.out.println("setting slot " + j + " for job " + job.id);
					slots[j] = true;
					result[j] = job.id;
					break;
				}
			}
		}
	}

	public static void main(String args[]) {
		ArrayList<JobSequencing> arr = new ArrayList<JobSequencing>();
		arr.add(new JobSequencing('a', 2, 100));
		arr.add(new JobSequencing('b', 1, 19));
		arr.add(new JobSequencing('c', 2, 27));
		arr.add(new JobSequencing('d', 1, 25));
		arr.add(new JobSequencing('e', 3, 15));
		System.out.println("Following jobs need to be " + "executed for maximum profit");
		JobSequencing.printJobs(arr);
	}
}