import java.util.ArrayDeque;
import java.util.Queue;

public class BankSimulation {
    public static void main(String[] args) {

        Queue<String> customerQueue = new ArrayDeque<>();

        customerQueue.add("Customer 1");
        customerQueue.add("Customer 2");
        customerQueue.add("Customer 3");

        System.out.println("Current queue size: " + customerQueue.size());

        while (!customerQueue.isEmpty()) {
   
            String currentCustomer = customerQueue.poll();
            
            System.out.println("Now serving: " + currentCustomer);
            System.out.println("People remaining in line: " + customerQueue.size());
        }

    }
}