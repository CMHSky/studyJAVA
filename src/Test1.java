import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {
  public static void main(String[] args) {
//    int[] input_1 = new int[] {98, 72, 86, 60, 65, 12, 23, 50};
    int[] input_1 = new int[] {98, 72, 86};
    int[] input_2 = new int[] {8, 38, 25, 58, 52, 82, 70, 60};
    int[] input_3 = new int[] {10, 28, 15, 12, 34, 9, 8, 56};
    Test1 ctx = new Test1();
  }

  public void print(int[] input) {
    int pathCount = computePathCount(input.length);
  }


  public boolean isMaxHeap(int[] input) {
    boolean isMaxHeap = false;
    for (int i = 0; i < input.length/2; i++) {
      try {
        if (input[i] >= input[2*i + 1] && input[i] >= input[2*i + 2]) {
          continue;
        } else {
          return isMaxHeap;
        }
      } catch (Exception ex) {
        continue;
      }
    }

    isMaxHeap = true;
    return isMaxHeap;
  }

  public boolean isMinHeap(int[] input) {
    boolean isMinHeap = false;
    for (int i = 0; i < input.length/2; i++) {
      try {
        if (input[i] <= input[2*i + 1] && input[i] <= input[2*i + 2]) {
          continue;
        } else {
          return isMinHeap;
        }
      } catch (Exception ex) {
        continue;
      }
    }

    isMinHeap = true;
    return isMinHeap;
  }

  private int computeDeep(int length) {
    int n = 0;
    while (true) {
      if ((int) Math.pow(2, n) > length) {
        break;
      }

      n++;
    }

    return n;
  }

  private int computePathCount(int length) {
    int deep = computeDeep(length);
    int buttomNodeCount = length - ((int) Math.pow(2, deep - 1) - 1);
    int pathCount = (buttomNodeCount / 2) + (int) Math.pow(2, deep - 2);
    return pathCount;
  }

}
