package lesson4homework;

import java.time.LocalDate;

public class Employee {
    private final String personnelNumber;
    private final String phoneNumber;
    private final String name;
    private final LocalDate workingStartDate;

    public Employee(String personnelNumber, String phoneNumber, String name, LocalDate workingStartDate) {
        this.personnelNumber = personnelNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.workingStartDate = workingStartDate;
    }

    public String getPersonnelNumber() {
        return personnelNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWorkingStartDate() {
        return workingStartDate;
    }
}
