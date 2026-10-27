import java.util.Arrays;

public class Excellent_Student {
    private String name;
    private int[] grades;

    public Excellent_Student(String name, int... grades) {
        this.name = name;
        this.grades = grades;
    }

    public double averageGrade() {
        if (grades.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public boolean isExcellent() {
        if (grades.length == 0) {
            return false;
        }
        for (int grade : grades) {
            if (grade != 5) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return name + ": " + Arrays.toString(grades);
    }

    public String getName() { return name; }
    public int[] getGrades() { return grades; }

    public void setGrades(int[] grades) { this.grades = grades; }
    public void setName(String name) { this.name = name; }
}
