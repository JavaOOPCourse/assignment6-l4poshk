import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();

        // ====================== TASK 1 ======================
        // TODO: Добавь минимум 5 студентов (ключ = ID)
        students.put("S001", new Student("Ali", 3.5, 20));
        students.put("S002", new Student("Bek", 4.0, 21));
        students.put("S003", new Student("Cem", 3.8, 22));
        students.put("S004", new Student("Den", 3.5, 20));
        students.put("S005", new Student("Eli", 4.0, 23));
        students.put("S006", new Student("Eli", 4.0, 23));
        // TODO: Напечатай всех студентов (ID + объект)
        for (String id : students.keySet()) {
            System.out.println("ID " + id + " Student " + students.get(id));
        }

        // TODO: Найди студента по ID и выведи его
        String searchId = "S003";
        Student found = students.get(searchId);
        System.out.println(found);

        // TODO: Удали одного студента по ID
        String removeId="S006";
        Student remove=students.remove(removeId);
        System.out.println(remove);

        // TODO: Обнови GPA у одного студента
        Student st = students.get("S002");
        st.setGpa(4.0);
        System.out.println(st);

        // ====================== SORTING (IMPORTANT) ======================
        // TODO: Создай ArrayList из всех студентов (students.values())
        ArrayList<Student> studentList = new ArrayList<>(students.values());

        // TODO 6a: Отсортируй по GPA (natural ordering) и выведи
        Collections.sort(studentList);
        for (Student s : studentList) {
            System.out.println(s);
        }
        // TODO 6b: Отсортируй по имени (Comparator) и выведи
        studentList.sort(Comparator.comparing(Student::getName));
        for (Student s : studentList) {
            System.out.println(s);
        }

        // ====================== TASK 2 ======================
        System.out.println("\n=== Task 2: Top 3 by GPA ===");
        // TODO: Создай новый список, отсортируй по GPA по убыванию, выведи первые 3
        ArrayList<Student> topList = new ArrayList<>(students.values());
        topList.sort((a, b) -> Double.compare(b.getGpa(), a.getGpa())); // GPA descending
        for (int i = 0; i < Math.min(3, topList.size()); i++) {
            System.out.println(topList.get(i));
        }

        // ====================== TASK 3 ======================
        System.out.println("\n=== Task 3: Students with same GPA ===");
        // TODO: Сгруппируй студентов по GPA и выведи только те, где больше 1 студента
        HashMap<Double, List<String>> gpaGroups = new HashMap<>();
        for (Student s : students.values()) {
            gpaGroups.putIfAbsent(s.getGpa(), new ArrayList<>());
            gpaGroups.get(s.getGpa()).add(s.getName());
        }
        for (Map.Entry<Double, List<String>> entry : gpaGroups.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println("GPA " + entry.getKey() + " → " + entry.getValue());
            }
        }

        // ====================== TASK 4 ======================
        System.out.println("\n=== Task 4: Courses ===");
        // TODO: Создай 2–3 курса, добавь студентов, выведи всё
        HashMap<Course, List<Student>> courseMap = new HashMap<>();
        Course math = new Course("Math");
        Course physics = new Course("Physics");
        Course cs = new Course("CS");

        courseMap.put(math, new ArrayList<>(Arrays.asList(students.get("S001"), students.get("S002"))));
        courseMap.put(physics, new ArrayList<>(Arrays.asList(students.get("S003"), students.get("S004"))));
        courseMap.put(cs, new ArrayList<>(Collections.singletonList(students.get("S005"))));

        System.out.println("\n=== Courses with Students ===");
        for (Map.Entry<Course, List<Student>> entry : courseMap.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        // ====================== TASK 5 ======================
        System.out.println("\n=== Task 5: GPA desc + Name ===");
        // TODO: Создай Comparator (GPA убывание → если равно, то имя возрастание) и отсортируй
        studentList.sort((a, b) -> {
            int cmp = Double.compare(b.getGpa(), a.getGpa()); // GPA descending
            if (cmp != 0) return cmp;
            return a.getName().compareTo(b.getName()); // Name ascending
        });

        for (Student s : studentList) {
            System.out.println(s);
        }
    }
}



