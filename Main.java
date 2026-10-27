import java.util.Arrays;
import java.util.Scanner;
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean running = true;
        System.out.println("Лабораторная работа номер 2");
        while (running) {
            printMainMenu();
            int choice = readInt("Выберите задание: ");
            switch (choice) {
                case 1:
                    pointMenu();
                    break;
                case 2:
                    lineMenu();
                    break;
                case 3:
                    studentMenu();
                    break;
                case 4:
                    newPointMenu();
                    break;
                case 5:
                    newStudentMenu();
                    break;
                case 6:
                    excellentStudentMenu();
                    break;
                case 0:
                    running = false;
                    System.out.println("Программа завершена");
                    break;
                default:
                    System.out.println("Такого пункта нет. Попробуйте снова.");
            }
        }
        scanner.close();
    }
    private static void printMainMenu() {
        System.out.println("\nГЛАВНОЕ МЕНЮ");
        System.out.println("1. Точка");
        System.out.println("2. Линия");
        System.out.println("3. Студент");
        System.out.println("4. Создаём Точку");
        System.out.println("5. Создаём Студента");
        System.out.println("6. Студент-отличник");
        System.out.println("0. Выход");
    }
    private static void printSubMenu(String title) {
        System.out.println("\n========== " + title + " ==========");
        System.out.println("1. Показать готовый пример");
        System.out.println("2. Создать свои объекты");
        System.out.println("0. Вернуться в главное меню");
    }
    private static void pointMenu() {
        while (true) {
            printSubMenu("ЗАДАНИЕ 1.1: ТОЧКА");
            int choice = readInt("Ваш выбор: ");
            if (choice == 0) return;
            switch (choice) {
                case 1:
                    Point p1 = new Point(2, 3);
                    Point p2 = new Point(5, 7);
                    Point p3 = new Point(-1, 4);
                    System.out.println("\nГотовый пример:");
                    System.out.println(p1);
                    System.out.println(p2);
                    System.out.println(p3);
                    break;
                case 2:
                    int count = readCount("Сколько точек создать? ");
                    for (int i = 1; i <= count; i++) {
                        System.out.println("\nТочка №" + i);
                        Point point = readPoint();
                        System.out.println("Создана точка: " + point);
                    }
                    break;
                default:
                    System.out.println("Введите 0, 1 или 2.");
            }
        }
    }
    private static void lineMenu() {
        while (true) {
            printSubMenu("ЗАДАНИЕ 1.2: ПРЯМАЯ");
            int choice = readInt("Ваш выбор: ");
            if (choice == 0) return;
            switch (choice) {
                case 1:
                    demonstrateLines();
                    break;
                case 2:
                    int count = readCount("Сколько линий создать? ");
                    for (int i = 1; i <= count; i++) {
                        System.out.println("\nЛиния №" + i);
                        Point start = readPointWithLabel("Начало линии");
                        Point end = readPointWithLabel("Конец линии");
                        Direct line = new Direct(start, end);
                        System.out.println(line);
                    }
                    break;
                default:
                    System.out.println("Введите 0, 1 или 2.");
            }
        }
    }

    private static void demonstrateLines() {
        Point start1 = new Point(1, 3);
        Point end1 = new Point(23, 8);
        Direct line1 = new Direct(start1, end1);
        Point start2 = new Point(5, 10);
        Point end2 = new Point(25, 10);
        Direct line2 = new Direct(start2, end2);
        // Третья линия использует те же объекты Point.
        Direct line3 = new Direct(line1.getStart(), line2.getEnd());
        System.out.println("\nИсходные линии:");
        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3: " + line3);
        System.out.println("\nИзменяем координаты существующих точек.");
        line1.getStart().setX(2);
        line1.getStart().setY(4);
        line2.getEnd().setX(30);
        line2.getEnd().setY(10);
        System.out.println("После изменения координат:");
        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3: " + line3);
        System.out.println("\nЗаменяем начало первой линии новым объектом.");
        line1.setStart(new Point(100, 200));
        System.out.println("После замены начала первой линии:");
        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3: " + line3);
        System.out.println( "Третья линия сохранила прежнее начало, " + "потому что ссылается на старый объект Point." );
    }
    private static void studentMenu() {
        while (true) {
            printSubMenu("ЗАДАНИЕ 3.1: СТУДЕНТ");
            int choice = readInt("Ваш выбор: ");
            if (choice == 0) return;
            switch (choice) {
                case 1:
                    demonstrateStudents();
                    break;
                case 2:
                    int count = readCount("Сколько студентов создать? ");
                    for (int i = 1; i <= count; i++) {
                        System.out.println("\nСтудент №" + i);
                        String name = readText("Имя: ");
                        int[] grades = readGrades();
                        Student student = new Student(name, grades);
                        System.out.println(student);
                    }
                    break;
                default:
                    System.out.println("Введите 0, 1 или 2.");
            }
        }
    }
    private static void demonstrateStudents() {
        int[] vasyaGrades = {3, 4, 5};
        Student vasya = new Student("Вася", vasyaGrades);
        // Петя получает ссылку на тот же массив.
        Student petya = new Student("Петя", vasya.getGrades());
        System.out.println("\nИсходные студенты:");
        System.out.println(vasya);
        System.out.println(petya);
        System.out.println("\nМеняем первую оценку Пети на 5.");
        petya.getGrades()[0] = 5;
        System.out.println(vasya);
        System.out.println(petya);
        System.out.println( "Оценки Васи тоже изменились: массив у студентов общий." );
        // Андрей получает отдельную копию массива.
        Student andrey = new Student("Андрей",  vasya.getGrades().clone());
        System.out.println("\nСоздали Андрея с копией оценок Васи.");
        System.out.println(andrey);
        System.out.println("\nМеняем вторую оценку Васи на 2.");
        vasya.getGrades()[1] = 2;
        System.out.println(vasya);
        System.out.println(petya);
        System.out.println(andrey);
        System.out.println("Оценки Андрея не изменились: у него отдельный массив.");
    }
    private static void newPointMenu() {
        while (true) {
            printSubMenu("ЗАДАНИЕ 4.1: СОЗДАЁМ ТОЧКУ");
            int choice = readInt("Ваш выбор: ");
            if (choice == 0) return;
            switch (choice) {
                case 1:
                    NewPoint p1 = new NewPoint(3, 5);
                    NewPoint p2 = new NewPoint(25, 6);
                    NewPoint p3 = new NewPoint(7, 8);
                    System.out.println("\nГотовый пример:");
                    System.out.println(p1);
                    System.out.println(p2);
                    System.out.println(p3);
                    break;
                case 2:
                    int count = readCount("Сколько точек создать? ");
                    for (int i = 1; i <= count; i++) {
                        System.out.println("\nТочка №" + i);
                        double x = readDouble("Введите X: ");
                        double y = readDouble("Введите Y: ");
                        NewPoint point = new NewPoint(x, y);
                        System.out.println("Создана точка: " + point);
                    }
                    break;
                default:
                    System.out.println("Введите 0, 1 или 2.");
            }
        }
    }
    private static void newStudentMenu() {
        while (true) {
            printSubMenu("ЗАДАНИЕ 4.7: СОЗДАЁМ СТУДЕНТА");
            int choice = readInt("Ваш выбор: ");
            if (choice == 0) return;
            switch (choice) {
                case 1:
                    NewStudent vasya = new NewStudent("Вася", 3, 4, 5);
                    NewStudent maxim = new NewStudent("Максим");
                    System.out.println("\nГотовый пример:");
                    System.out.println(vasya);
                    System.out.println(maxim);
                    break;
                case 2:
                    int count = readCount("Сколько студентов создать? ");
                    for (int i = 1; i <= count; i++) {
                        System.out.println("\nСтудент №" + i);
                        String name = readText("Имя: ");
                        int[] grades = readGrades();
                        NewStudent student = new NewStudent(name, grades);
                        System.out.println("Создан студент: " + student);
                    }
                    break;
                default:
                    System.out.println("Введите 0, 1 или 2.");
            }
        }
    }
    private static void excellentStudentMenu() {
        while (true) {
            printSubMenu("ЗАДАНИЕ 4.8: СТУДЕНТ-ОТЛИЧНИК");
            int choice = readInt("Ваш выбор: ");
            if (choice == 0) return;
            switch (choice) {
                case 1:
                    Excellent_Student vasya = new Excellent_Student("Вася", 3, 4, 5, 4);
                    Excellent_Student petya = new Excellent_Student("Петя", 5, 5, 5, 5);
                    System.out.println("\nГотовый пример:");
                    printExcellentStudent(vasya);
                    printExcellentStudent(petya);
                    break;
                case 2:
                    int count = readCount("Сколько студентов создать? ");
                    for (int i = 1; i <= count; i++) {
                        System.out.println("\nСтудент №" + i);
                        String name = readText("Имя: ");
                        int[] grades = readGrades();
                        Excellent_Student student =  new Excellent_Student(name, grades);
                        printExcellentStudent(student);
                    }
                    break;
                default:
                    System.out.println("Введите 0, 1 или 2.");
            }
        }
    }
    private static void printExcellentStudent(
            Excellent_Student student) {
        System.out.println("\nСтудент: " + student.getName());
        System.out.println("Оценки: " + Arrays.toString(student.getGrades()));
        System.out.printf("Средний балл: %.2f%n", student.averageGrade());
        System.out.println("Отличник: " + (student.isExcellent() ? "Да" : "Нет"));
    }
    private static Point readPoint() {
        double x = readDouble("Введите X: ");
        double y = readDouble("Введите Y: ");
        return new Point(x, y);
    }
    private static Point readPointWithLabel(String label) {
        System.out.println(label + ":");
        return readPoint();
    }
    private static int[] readGrades() {
        int count = readCount("Сколько оценок будет у студента? ");
        int[] grades = new int[count];
        for (int i = 0; i < count; i++) {
            grades[i] = readInt("Введите оценку №" + (i + 1) + ": ");
        }
        return grades;
    }
    private static String readText(String message) {
        while (true) {
            System.out.print(message);
            String text = scanner.nextLine().trim();
            if (!text.isEmpty()) {
                return text;
            }
            System.out.println("Ввод не должен быть пустым.");
        }
    }
    private static int readCount(String message) {
        while (true) {
            int count = readInt(message);
            if (count >= 0) {
                return count;
            }
            System.out.println("Количество не может быть отрицательным.");
        }
    }
    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число.");
            }
        }
    }
    private static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim().replace(',', '.');
            try {
                double value = Double.parseDouble(input);
                if (Double.isFinite(value)) {
                    return value;
                }
            }
            catch (NumberFormatException ignored) {
            }
            System.out.println(
                    "Введите корректное число, например 3.5."
            );
        }
    }
}
