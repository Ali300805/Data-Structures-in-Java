import java.util.ArrayList;
import java.util.List;

public class ExamCheckInSystem {
    private List<String> students;

    public ExamCheckInSystem() {
        this.students = new ArrayList<>();
    }

    public void checkIn(String name) {
        if (students.contains(name)) {
            System.out.println("ERROR: " + name + " already checked in");
            return;
        }
        students.add(name);
        System.out.println(name + " checked in");
    }

    public void showReport() {
        System.out.println("\nCHECK-IN REPORT:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
        System.out.println("Total: " + students.size());
    }

    public void search(String name) {
        if (students.contains(name)) {
            int pos = students.indexOf(name) + 1;
            System.out.println(name + " is at position " + pos);
        } else {
            System.out.println(name + " not checked in");
        }
    }

    public static void main(String[] args) {
        ExamCheckInSystem system = new ExamCheckInSystem();

        system.checkIn("Ali");
        system.checkIn("Maria");
        system.checkIn("Carlos");
        system.checkIn("Sofia");

        system.checkIn("Ali");

        system.search("Maria");
        system.search("Pedro");

        system.showReport();
    }
}
