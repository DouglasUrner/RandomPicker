import java.time.*;
import java.time.format.DateTimeFormatter;
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

    int spd = students / days;
    int excess = students % days;

    int[][] result = new int[days][];

    // Build array - selecting students at random.
    for (int i = 0; i < days; i++) {
      int howmany = spd + (excess-- > 0 ? 1 : 0);
      result[i] = new int[howmany];
      for (int j = 0; j < howmany; j++) {
        int index = (int) (Math.random() * (double) queue.size());
        result[i][j] = queue.remove(index);
      }
    }

    long epochTimeMilliSec = System.currentTimeMillis();
    ZoneId tz = ZoneId.of("America/Vancouver");
    //LocalDate today = LocalDate.now( z );

    long next = epochTimeMilliSec;

    // Sort and print.
    for (int[] day : result) {
      Arrays.sort(day);
      System.out.printf("%s: ", epochToDate(next, tz));
      for (int stu : day) {
          System.out.printf("%2d, ", stu);
      }
      System.out.println();
      next = findNextClassDay(next, tz);
    }
  }

  private static long findNextClassDay(long last, ZoneId tz) {
    final long twoDays = 2 * 24 * 60 * 60 * 1000;
    long next = last + twoDays;
    ZonedDateTime dt = Instant.ofEpochMilli(next).atZone(tz);

    if (dt.getDayOfWeek() == DayOfWeek.SATURDAY ||
        dt.getDayOfWeek() == DayOfWeek.SUNDAY) {
      next += twoDays;
    }

    return next;
  }

  private static String epochToDate(long last, ZoneId tz) {
    ZonedDateTime dt = Instant.ofEpochMilli(last).atZone(tz);
    return dt.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
  }
}
