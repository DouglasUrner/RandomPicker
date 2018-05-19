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

    for (int i = 0; i < days; i++) {
      int howmany = spd + (excess-- > 0 ? 1 : 0);
      System.out.printf("%2d: ", howmany);
      for (int j = 0; j < howmany - 1; j++) {
        int index = (int) (Math.random() * (double) queue.size());
        System.out.printf("%2d, ", queue.remove(index));
      }
      int index = (int) (Math.random() * (double) queue.size());
      System.out.printf("%2d\n", queue.remove(index));
    }

  }
}
