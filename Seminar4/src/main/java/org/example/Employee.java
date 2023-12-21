package org.example;


/*
Создать справочник сотрудников

Необходимо:
Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
- Табельный номер
- Номер телефона
- Имя
- Стаж
 */
public class Employee {
    private int employeeID;
    private String phoneNumber;
    private String name;
    private int yearsOfExperience;

    public Employee(int employeeID, String phoneNumber, String name, int yearsOfExperience){
        this.employeeID = employeeID;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, name: %s, phone: %s, experience: %s years",
                employeeID, name, phoneNumber, yearsOfExperience);
    }
}

