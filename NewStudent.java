import java.util.Arrays;

public class NewStudent {
    private String name;
    private int[] grades;


    public NewStudent(String name, int... grades) {
        this.name = name;
        this.grades = grades;
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
