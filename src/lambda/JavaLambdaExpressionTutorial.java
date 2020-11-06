package lambda;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class JavaLambdaExpressionTutorial {

	/**
	 * non functional programming to count the number of "n" in an array. reason of
	 * the non functionality is for example changing the status of the local
	 * variable "count"
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
	 * a method to count the number of any entry in an array. the entries are being
	 * determined by the function given as a parameter
	 * 
	 * @param arr
	 * @param pred: a function
	 * @return count()
	 */
	public long countFunctionally(int[] arr, IntPredicate predFunction) {
		IntStream str = Arrays.stream(arr);
		return str.filter(predFunction).count();

	}

	/**
	 * a method to calculate the sum of certain entries in an array. the entries are
	 * being determined by the function given as a parameter
	 * 
	 * @param arr
	 * @param pred: a function to
	 * @return
	 */
	public int sumFunctionally(int[] arr, IntPredicate predFunction) {
		IntStream str = Arrays.stream(arr);
		return str.filter(predFunction).sum();

	}

	public static void main(String[] args) {

		// implementing functional interfaces by using lambda expressions. these functions can be 
		//given as parameter to different methods
		
		IntPredicate trueWhenOne = (i) -> i == 1;
		IntPredicate trueWhenZero = (i) -> i == 0;

		//an array to test the functions on
		int[] numbersArray = new int[] { 1, 1, 0, 0, 0, 3, 3 };

		JavaLambdaExpressionTutorial tutorial = new JavaLambdaExpressionTutorial();

		System.out.print("counting \"" + 1 + "\" non functionally resulted "
				+ tutorial.countNonFunctionally(numbersArray, 1) + "\n");

		// giving the functionality as a parameter
		System.out.print("counting \"" + 1 + "\" functionally resulted "
				+ tutorial.countFunctionally(numbersArray, trueWhenOne) + "\n");

		// an advantage of functional programming is using the functionality in another methods
		System.out.print("the sum of \"" + 1 + "\" entries in the array is "
				+ tutorial.sumFunctionally(numbersArray, trueWhenOne) + "\n");

		// counting the "0" in the functional Method needs only to change the
		// functionality.

		System.out.print("counting \"" + 0 + "\" functionally method resulted "
				+ tutorial.countFunctionally(numbersArray, trueWhenZero) + "\n");

	}

}
