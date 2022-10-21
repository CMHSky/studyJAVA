import java.util.Arrays;

public class SortTest {
// https://www.cnblogs.com/onepixel/articles/7674659.html
  public static void main(String[] args) {
    int[] input = {34, 56, 12, 8, 13, 89, 45, 35, 78, 52, 98, 65, 23};
    SortTest sort = new SortTest();

    // 冒泡排序
    printRs("冒泡排序", sort.bubbleSort(input.clone()));
    // 选择排序
    printRs("选择排序", sort.selectionSort(input.clone()));
    // 插入排序
    printRs("插入排序", sort.insertionSort(input.clone()));
    // 希尔排序
    printRs("希尔排序", sort.shellSort(input.clone()));
    // 归并排序
    printRs("归并排序", sort.mergeSort(input.clone()));
    // 快速排序
    printRs("快速排序", sort.quickSort(input.clone(), 0, input.length - 1));
    // 堆排序
    printRs("堆排序", sort.heapSort(input.clone()));
  }

// 打印排序结果
  public static void printRs(String name, int[] output) {
    StringBuilder sb = new StringBuilder();
    sb.append(name).append(" 排序结果：");
    sb.append("[");
    for (int i = 0; i < output.length; i++) {
      sb.append(output[i]);
      if (i != output.length - 1) {
        sb.append(", ");
      }
    }

    sb.append("]");
    System.out.println(sb.toString());
    System.out.println();
  }

// 元素交换
  private void swap(int[] input, int i, int j) {
    int temp;
    temp = input[j];
    input[j] = input[i];
    input[i] = temp;
  }

// 冒泡排序
  public int[] bubbleSort(int[] input) {
    for (int i = input.length - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (input[j] > input[j + 1]) {
          swap(input, j, j + 1);
        }
      }
    }

    return input;
  }

// 选择排序
  public int[] selectionSort(int[] input) {
    for (int i = 0; i < input.length; i++) {
      int minIndex = i;
      for (int j = i + 1; j < input.length; j++) {
        if (input[j] < input[minIndex]) {
          minIndex = j;
        }
      }

      if (minIndex != i) {
        swap(input, minIndex, i);
      }
    }

    return input;
  }

// 插入排序
  public int[] insertionSort(int[] input) {
    if (input.length <= 1) {
      return input;
    }

    int current;
    for (int i = 1; i < input.length; i++) {
      current = input[i];
      for (int j = i - 1; j >= 0; j--) {
        if (input[j] > current) {
          input[j + 1] = input[j];
          if (j == 0) {
            input[j] = current;
          }
        } else {
          input[j + 1] = current;
          break;
        }
      }
    }

    return input;
  }

// 希尔排序
  public int[] shellSort(int[] input) {
    int temp;
    int length = input.length;
    // 计算增量
    for (int d = length / 2; d >= 1; d = d / 2) {
      // d != 1 按照增量进行大致排序
      if (d != 1) {
        for (int i = 0; (i + d) < length; i++) {
          if (input[i] > input[i + d]) {
            swap(input, i, i + d);
          }
        }
      } else {
        // d == 1时进行一次正常的插入排序
        insertionSort(input);
      }
    }

    return input;
  }

// 归并排序
  public int[] mergeSort(int[] input) {
    int length = input.length;
    if (length < 2) {
      return input;
    }

    int middle = length / 2;
    int[] left = Arrays.copyOfRange(input, 0, middle);
    int[] right = Arrays.copyOfRange(input, middle, length);
    return merge(mergeSort(left), mergeSort(right));
  }

  private int[] merge(int[] left, int[] right) {
    int[] result = new int[left.length + right.length];
    int i = 0, j = 0;
    int index = 0;
    while (i < left.length || j < right.length) {
      if (i == left.length) {
        result[index] = right[j];
        j++;
        index++;
        continue;
      }

      if (j == right.length) {
        result[index] = left[i];
        i++;
        index++;
        continue;
      }

      if (left[i] <= right[j]) {
        result[index] = left[i];
        i++;
      } else {
        result[index] = right[j];
        j++;
      }

      index++;
    }

    return result;
  }

// 快速排序
  public int[] quickSort(int[] input, int left, int right) {
    if (left < right) {
      int index = partition(input, left, right);
      quickSort(input, 0, index - 1);
      quickSort(input, index + 1, right);
    }

    return input;
  }

  // 分区
  private int partition(int[] input, int left, int right) {
    int pivot = left;
    int index = left + 1;
    int temp;

    for (int i = index; i <= right; i++) {
      if (input[i] < input[pivot]) {
        swap(input, index, i);
        index++;
      }
    }

    swap(input, index - 1, pivot);
    return index - 1;
  }

// 堆排序
  public int[] heapSort(int[] input) {
    // 构建大顶堆
    buildMaxHeap(input);

    int length = input.length;
    for (int i = length - 1; i > 0; i--) {
      // 将堆顶和数组尾部元素互换
      swap(input, 0, i);
      // 重新调整堆，并且新堆的长度-1
      updateHeap(input, 0, i);
    }

    return input;
  }

  // 构建大顶堆
  private void buildMaxHeap(int[] input) {
    for (int i = input.length/2 - 1; i >= 0; i--) {
      updateHeap(input, i, input.length);
    }
  }

  // 堆调整
  private void updateHeap(int[] input, int root, int len) {
    int lChild = root * 2 + 1;
    int rChild = root * 2 + 2;
    int largest = root;

    if (lChild < len && input[lChild] > input[largest]) {
      largest = lChild;
    }

    if (rChild < len && input[rChild] > input[largest]) {
      largest = rChild;
    }

    if (largest != root) {
      swap(input, root, largest);
      updateHeap(input, largest, len);
    }
  }
}
