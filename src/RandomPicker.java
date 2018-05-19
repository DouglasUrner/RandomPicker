import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomPicker {

  public static void main(String[] args) {
    int students = 25;
    int days = 4;

    List<Integer> queue = new ArrayList<>(students);
    for (int i = 1; i <= students; i++) {
      queue.add(i);
    }
    //System.out.println(queue.toString());

    int spd = students / days;
    int excess = students % days;

    int[][] result = new int[days][];

    // Build array.
    for (int i = 0; i < days; i++) {
      int howmany = spd + (excess-- > 0 ? 1 : 0);
      result[i] = new int[howmany];
      for (int j = 0; j < howmany; j++) {
        int index = (int) (Math.random() * (double) queue.size());
        result[i][j] = queue.remove(index);
      }
    }

    // Sort and print.
    for (int[] day : result) {
      Arrays.sort(day);
      System.out.printf("%2d: ", day.length);
      for (int stu : day) {
          System.out.printf("%2d, ", stu);
      }
      System.out.println();
    }
  }
}
