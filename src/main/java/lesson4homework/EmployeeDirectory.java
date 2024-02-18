package lesson4homework;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

public class EmployeeDirectory {
    private final List<Employee> employeeList;

    public EmployeeDirectory() {
        this.employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        Objects.requireNonNull(employee);
        employeeList.add(employee);
    }

    public List<Employee> getEmployeesByYearsAndMonthsOfWork(int yearsOfWork, int monthsOfWork) {
        if (yearsOfWork < 0 || monthsOfWork < 0) {
            throw new IllegalArgumentException();
        }
        int summaryMonthsOfWork = yearsOfWork * 12 + monthsOfWork;
        LocalDate currentDate = LocalDate.now();
        return employeeList.stream().filter(employee -> {
            LocalDate workingStartDate = employee.getWorkingStartDate();
            LocalDate localDate = currentDate.minusYears(workingStartDate.getYear()).minusMonths(workingStartDate.getMonthValue());
            int realSummaryMonthsOfWork = localDate.getYear() * 12 + localDate.getMonthValue();
            return summaryMonthsOfWork == realSummaryMonthsOfWork;
        }).toList();
    }

    public List<String> getPhoneNumbersByEmployeeNames(List<String> employeeNames) {
        final Set<String> employeeNamesSet = new HashSet<>(employeeNames);
        return employeeList.stream().filter(employee -> employeeNamesSet.contains(employee.getName()))
                .map(Employee::getPhoneNumber).toList();
    }

    public Optional<Employee> findEmployeeByPersonnelNumber(String personnelNumber) {
        Predicate<Employee> employeePredicate = employee -> employee.getPersonnelNumber().equals(personnelNumber);
        return employeeList.stream().filter(employeePredicate).findFirst();
    }
}
