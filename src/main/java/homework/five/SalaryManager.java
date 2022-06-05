package homework.five;

public class SalaryManager {
    public static void main(String[] args) {
        int yearlySalary=20000000;
        SalaryManager sm =new SalaryManager();
        double monthlySalary = sm.getMonthlySalary(yearlySalary);

        System.out.println("세후 실수령액 = " + monthlySalary);
    }

    public double getMonthlySalary(int yearlySalary) {
        double monthSalary = yearlySalary / 12;
        System.out.println("세전 금액 = " + monthSalary);
        double tax = calculateTax(monthSalary);
        double nationalPerson=calculateNationalPerson(monthSalary);
        double healthInsurance = calculateHealthInsurance(monthSalary);
        double minus = tax + nationalPerson + healthInsurance;
        monthSalary-=minus;
        return monthSalary;
    }

    public double calculateTax(double monthSalary) {
        double tax = monthSalary * 0.125;
        System.out.println("내야할 세금 = " + tax);
        return tax;
    }
    public double calculateNationalPerson(double monthSalary) {
        double pension = monthSalary * 0.081;
        System.out.println("국민 연금 공제금액 = " + pension);
        return pension;
    }

    public double calculateHealthInsurance(double monthSalary) {
        double insurance = monthSalary * 0.135;
        System.out.println("건강보험 공제금액 = " + insurance);
        return insurance;
    }
}
