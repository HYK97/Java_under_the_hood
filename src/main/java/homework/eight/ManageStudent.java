package homework.eight;

public class ManageStudent {
    public static void main(String[] args) {
        Student student =null;
        Student[] students = addStudent();
        printStudents(students);

    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }

    }
    public static Student[] addStudent() {
        Student[] students = new Student[3];
        students[0]= new Student("Lim");
        students[1]= new Student("Min");
        students[2]= new Student("Sook","Seoul","01011222233","asdasd@gmail.com");
        return students;
    }
}
