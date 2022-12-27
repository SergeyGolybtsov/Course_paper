public class Main {
    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        employees[0] = new Employee("Андрей", "Липаткин", "Алексеевич", 34200, 1);
        employees[1] = new Employee("Сергей", "Понаморев", "Викторович", 52600, 1);
        employees[2] = new Employee("Максим", "Волков", "Игоревич", 23600, 2);
        employees[3] = new Employee("Светлана", "Милохина", "Петровна", 63100, 2);
        employees[4] = new Employee("Иван", "Комаров", "Алексеевич", 45030, 3);
        employees[5] = new Employee("Алексей", "Квасов", "Вадимович", 10000, 3);
        employees[6] = new Employee("Александр", "Потапов", "Викторович", 17800, 4);
        employees[7] = new Employee("Виктор", "Голубцов", "Александрович", 34600, 4);
        employees[8] = new Employee("Мария", "Березовская", "Максимовна", 23500, 5);
        employees[9] = new Employee("Юлия", "Понаморева", "Вительевна", 36700, 5);

        employees[4].setSalary(45230);
        employees[5].setDepartment(3);


        System.out.println("Списки работников");
        System.out.println();
        printEmployees();
        System.out.println();
        System.out.println("Сумма затрат на З/П в месяц: " + findSumSalary());
        System.out.println();
        System.out.println("Cотрудник с минимальной зарплатой: " + findMinSalary());
        System.out.println();
        System.out.println(("Cотрудник с максимальной зарплатой: ") + findMaxSalary());
        System.out.println();
        System.out.println("Среднее значение зарплаты: " + findAverageSalary());
        System.out.println();
        findName();
        System.out.println();
        System.out.println();
        indexSalary(13);
        System.out.println("Минимальная зарплата в отделе: " + findMinSalaryDepartment(1));
        System.out.println();
        System.out.println("Максимальная зарплата в отделе: " + findMaxSalaryDepartment(3));
        System.out.println();
        System.out.println("Среднюю зарплату по отделу: " + findAverageSalaryByDepartment(5));
        System.out.println();
        System.out.println("Затрат на зарплату по отделу: " + findSalaryCostsByDepartment(3));
        System.out.println();
        indexTheSalaryOfAllEmployees(3, 1);
        printEmployeesWithSalaryLessThanTheNumber(12400);
        System.out.println();
        printEmployeesWithSalaryMoreThanTheNumber(38000);


    }

    //Легкий уровень
    public static void printEmployees() {
        for (Employee element : employees) {
            System.out.println(element);
        }
    }

    public static double findSumSalary() {
        double salarySum = 0;
        for (Employee employee : employees) {
            salarySum = salarySum + employee.getSalary();
        }
        return salarySum;
    }

    public static Employee findMinSalary() {
        Employee tempEmployee = null;
        double minSalary = Double.MAX_VALUE;
        for (Employee employee : employees) {
            if (minSalary >= employee.getSalary()) {
                minSalary = employee.getSalary();
                tempEmployee = employee;
            }
        }
        return tempEmployee;
    }

    public static Employee findMaxSalary() {
        Employee tempEmployee = null;
        double maxSalary = Double.MIN_VALUE;
        for (Employee employee : employees) {
            if (maxSalary <= employee.getSalary()) {
                maxSalary = employee.getSalary();
                tempEmployee = employee;
            }
        }
        return tempEmployee;
    }

    public static double findAverageSalary() {
        double averageSalary = findSumSalary();
        int numberOfPeople = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                numberOfPeople += 1;
            }

        }
        averageSalary = averageSalary / numberOfPeople;
        return averageSalary;
    }

    public static void findName() {
        for (Employee employee : employees) {
            System.out.println(employee.getSurName() + " " + employee.getName() + " " + employee.getPatronymic());
        }
    }

    //Повышенная сложнось...
    public static void indexSalary(int percent) {
        for (Employee employee : employees) {
            int currentSalary = employee.getSalary();
            employee.setSalary((int) (currentSalary * (percent / 100f + 1)));
        }
    }

    //Продолжение следует(((

    public static Employee findMinSalaryDepartment(int department) {
        int minSalary = Integer.MAX_VALUE;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() != department) {
                continue;
            }
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static Employee findMaxSalaryDepartment(int department) {
        int maxSalary = Integer.MIN_VALUE;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() != department) {
                continue;
            }
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static int findSalaryCostsByDepartment(int deportment) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == deportment) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public static float findAverageSalaryByDepartment(int department) {
        int members = 0;
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
                members += 1;
            }
        }
        return sum / (float) members;
    }

    public static void indexTheSalaryOfAllEmployees(int percent, int department) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                int currentSalary = employee.getSalary();
                employee.getSalary((int) (currentSalary * (percent / 100f + 1)));
                System.out.println(employee.toStringNotDepartment());
            }
        }
    }

    public static void printEmployeesWithSalaryLessThanTheNumber(int salary) {
        for (Employee employee : employees) {
            if (employee.getSalary() < salary) {
                System.out.println(employee.toStringNotDepartment());
            }
        }
    }

    public static void printEmployeesWithSalaryMoreThanTheNumber(int salary) {
        for (Employee employee : employees) {
            if (employee.getSalary() >= salary) {
                System.out.println(employee.toStringNotDepartment());
            }
        }
    }

}
    






