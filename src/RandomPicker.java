import java.util.ArrayList;
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

    int[][] result = new int[days][spd + (excess > 0 ? 1 : 0)];

    for (int i = 0; i < days; i++) {
      int howmany = spd + (excess-- > 0 ? 1 : 0);
      System.out.printf("%2d: ", howmany);
      for (int j = 0; j < howmany; j++) {
        int index = (int) (Math.random() * (double) queue.size());
        result[i][j] = queue.remove(index);
        System.out.printf("%2d, ", result[i][j]);
      }
      System.out.println();
      //int index = (int) (Math.random() * (double) queue.size());
      //System.out.printf("%2d\n", queue.remove(index));
    }
  }
}
