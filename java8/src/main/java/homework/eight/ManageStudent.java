package homework.eight;

public class ManageStudent {
    public static void main(String[] args) {
        Student student =null;
        Student[] students = addStudent();
        printStudents(students);

        checkEquals();

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

    public static void checkEquals() {
        Student a =new Student("Sook","Seoul","01011222233","asdasd@gmail.com");
        Student b =new Student("Sook","Seoul","01011222233","asdasd@gmail.com");
        if (a.equals(b)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");

        }
    }
}
