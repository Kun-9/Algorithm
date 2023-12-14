package sort;

import java.io.IOException;

// 퀵 솔트
public class QuickSort {
	public static void main(String[] args) throws IOException {
		int[] arr = new int[]{5, 3, 8, 4, 9, 1, 2, 6, 7};

		int pivot = 0;
		int rt = arr.length - 1;

		binarySort(arr, pivot, rt);

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private static void binarySort(int[] arr, int left, int right) {
		if (left >= right) return;

		int pivot = sort(arr, left, right);

		// 좌측
		// left = left, right = pivot - 1
		binarySort(arr, left, pivot - 1);

		// 우측
		// left = pivot + 1, right = right
		binarySort(arr, pivot + 1, right);
	}

	private static int sort(int[] arr, int left, int right) {
		int pivot = left;
		int target = arr[pivot];
		left++;

		while (left < right) {

			while (arr[right] > target) {
				right--;
			}

			while (arr[left] <= target && left < right) {
				left++;
			}

			swap(arr, left, right);
		}
		swap(arr, left, pivot);

		return right;
	}

	static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}

