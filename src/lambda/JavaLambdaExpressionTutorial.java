package lambda;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class JavaLambdaExpressionTutorial {

	/**
	 * a non functional method to count the number of "1" in an array. reason of non
	 * functionality is changing the status of the local variable numberOfOne
	 * 
	 * @param arr
	 * @return
	 */
	public int countNonFunctionally(int[] arr, int n) {

		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == n)
				count++;
		}
		return count;
	}

	/**
	 * a functional method to count the number of any entry in an array. reasons of
	 * functionality: 1-not changing any status of any variables 2-getting a
	 * reference on a functionality as a parameter "pred"
	 * 
	 * @param arr
	 * @param pred
	 * @return count() returns long only
	 */
	public long countFunctionally(int[] arr, IntPredicate pred) {
		IntStream str = Arrays.stream(arr);
		return str.filter(pred).count();

	}

	/**
	 * a functional method to calculate the sum
	 * 
	 * @param arr
	 * @param pred
	 * @return
	 */
	public int sumFunctionally(int[] arr, IntPredicate pred) {
		IntStream str = Arrays.stream(arr);
		return str.filter(pred).sum();

	}

	public static void main(String[] args) {

		// implementing functional interfaces by using lambda expressions
		IntPredicate trueWhenOne = (i) -> i == 1;
		IntPredicate trueWhenZero = (i) -> i == 0;

		int[] numbersArray = new int[] { 1, 1, 0, 0, 0, 3, 3 };

		JavaLambdaExpressionTutorial tutorial = new JavaLambdaExpressionTutorial();

		System.out.print("counting \"" + 1 + "\" with a non functional method results "
				+ tutorial.countNonFunctionally(numbersArray, 1) + "\n");

		// giving the functionality as a parameter
		System.out.print("counting \"" + 1 + "\" with a functional method results "
				+ tutorial.countFunctionally(numbersArray, trueWhenOne) + "\n");

		// an advantage of functionality is using the functionality in another methods
		System.out.print("the sum of \"" + 1 + "\" entries in the array is "
				+ tutorial.sumFunctionally(numbersArray, trueWhenOne) + "\n");

		// counting the "0" in the functional Method needs only to change the
		// functionality.

		System.out.print("counting \"" + 0 + "\" with a functional method results "
				+ tutorial.countFunctionally(numbersArray, trueWhenZero) + "\n");

	}

}
