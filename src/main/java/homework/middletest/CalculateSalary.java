package homework.middletest;

public class CalculateSalary {
    public static void main(String[] args) {
        CalculateSalary cal = new CalculateSalary();
        cal.calculateSalaries();
    }

    public void calculateSalaries() {
        Employee[] employees = {
                new Employee("LeeDaeRi", 1, 1000000000),
                new Employee("KimManager", 2, 100000000),
                new Employee("WhangDesion", 3, 70000000),
                new Employee("ParkArchi", 4, 80000000),
                new Employee("LeeDevelop", 5, 60000000)

        };
        for (Employee employee : employees) {
            System.out.format("%s = %d\n", employee.getName(), getSalaryIncrease(employee));
        }
    }

    public long getSalaryIncrease(Employee employee) {
        long salary = employee.getSalary();
        int type = employee.getType();
        switch (type) {
            case 1:
                return (long) (salary - (salary * 0.95));
            case 2:
                return (long) (salary + (salary * 0.1));
            case 3:
                return (long) (salary + (salary * 0.2));
            case 4:
                return (long) (salary + (salary * 0.2));
            case 5:
                return salary + salary;
            default:
                return 0;
        }
    }
}
