public class Employee {
    private int id;
    private String name;
    private String surName;
    private String patronymic;
    private int salary;
    private Integer department;
    private static int counter = 1;
    private Integer percent;

    //Условие
    public Employee(String name, String surName, String patronymic, int salary, int department) {
        this.surName = surName;
        this.name = name;
        this.patronymic = patronymic;
        this.salary = salary;
        this.department = department;
        this.id = counter;
        counter += 1;
    }

    //Гетеры

    public String getSurName() {
        return surName;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getSumSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public int getSalary(int i) {
        return 0;
    }

    public int getDepartment() {
        return department;
    }

    //Сетеры

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    //toString

    public String toString() {
        return "ID " + id + " Ф.И.О " + surName + " " + name + " " + patronymic + " Отдел " + department + " Зарплата " + salary;
    }

    public String toStringNotDepartment() {
        return "ID " + id + " Ф.И.О " + surName + " " + name + " " + patronymic + " Зарплата " + salary;
    }

    public String toStringSalary() {
        return surName + " " + name + " " + patronymic + " Зарплата " + salary;

    }
}

