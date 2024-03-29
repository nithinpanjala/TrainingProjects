package CountingPairs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CountingPairsSolution {

	/*
	 * countPairs function.
	 *
	 * return an INTEGER.
	 * 
	 * @param list of integer numbers, k as int
	 * 
	 */

	public static int countPairs2(List<Integer> numbers, int k) {

		int count = 0;
		Set<Integer> set = new HashSet<Integer>();

		for (Integer num : numbers) {
			set.add(num);
		}

		for (Integer num : set) {
			if (set.contains(num + k)) {
				count++;
			}
		}

		return count;
}

	
	public static int countPairs(List<Integer> numbers, int k) {

		int kDifference = 0;
		Map<Integer, Integer> counter = new HashMap<Integer, Integer>();

		for (int num : numbers) {
			int countOfNumbers = counter.getOrDefault(num, 0);
			countOfNumbers++;
			counter.put(num, countOfNumbers);

			if (k == 0) {

				if (countOfNumbers == 2) {
					kDifference++;
				}
			} else if (countOfNumbers == 1) {

				if (counter.containsKey(num - k)) {
					kDifference++;
				}
				if (counter.containsKey(num + k)) {
					kDifference++;
				}

			}
		}
		return kDifference;
	}
	
/*----------------------Main Method------------------------------------ */
	
	public static class CountingPairsMain {
		public static void main(String[] args) throws IOException {
			Scanner scanner = new Scanner(System.in);

			
			int n = scanner.nextInt();

			int k = scanner.nextInt();
			List<Integer> arr = new ArrayList<Integer>();

			for (int i = 0; i < n; i++) {
				int listele = scanner.nextInt();
				arr.add(listele);
			}

			int result = CountingPairsSolution.countPairs(arr, k);
			
			System.out.println(result);
			System.out.println("**********************");

			int result2 = CountingPairsSolution.countPairs2(arr, k);
			System.out.println(result2);

			scanner.close();
		}
	}

}
