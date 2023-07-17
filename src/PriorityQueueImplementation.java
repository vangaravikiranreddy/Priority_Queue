import java.util.ArrayList;
import java.util.Arrays;

public class PriorityQueueImplementation {
    public static void main(String[] args) {
      PriorityQueueServices priorityQueueServices = new PriorityQueueServices();

      priorityQueueServices.BuildMinPriorityQueue(new ArrayList<>(Arrays.asList(8, 12, 3, 6,15)));

      System.out.println(priorityQueueServices.getMinValue());

      priorityQueueServices.insert(2);

      System.out.println(priorityQueueServices.getMinValue());

      priorityQueueServices.delete();

      System.out.println(priorityQueueServices.getMinValue());

      priorityQueueServices.delete();

      System.out.println(priorityQueueServices.getMinValue());
    }
}