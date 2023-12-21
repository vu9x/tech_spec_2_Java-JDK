package org.example;

import java.util.ArrayList;
import java.util.Iterator;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        EmployeeCatalog list = generatedList();

        //Добавить метод, который ищет сотрудника по стажу (может быть список)
        System.out.println("Answer 1:");
        ArrayList<Employee> answer1 = list.findEmployeesByExperience(1);
        for (int i = 0; i < answer1.size(); i++) {
            System.out.println(answer1.get(i).toString());
        }
        //Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
        System.out.println("Answer 2:");
        ArrayList<String> phones = list.findEmployeesPhoneByName("John");
        for (int i = 0; i < phones.size(); i++) {
            System.out.println(phones.get(i));
        }
        //Добавить метод, который ищет сотрудника по табельному номеру
        System.out.println("Answer 3:");
        Employee answer3 = list.findEmployeeByEmployeeID(1);
        System.out.println(answer3);

        //Добавить метод добавление нового сотрудника в справочник
        System.out.println("Answer 4:");
        list.addNewEmployee(new Employee(5, "+79995555555", "Elizabeth", 1));
        for (int i = 0; i < list.getCatalog().size(); i++) {
            System.out.println(list.getCatalog().get(i));
        }
    }

    static EmployeeCatalog generatedList(){
        EmployeeCatalog catalog = new EmployeeCatalog();

        catalog.addNewEmployee(new Employee(1, "+79991111111", "John", 1));
        catalog.addNewEmployee(new Employee(2, "+79992222222", "Michael", 2));
        catalog.addNewEmployee(new Employee(3, "+79993333333", "Kate", 3));
        catalog.addNewEmployee(new Employee(4, "+79991111111", "John", 1));

        return catalog;
    }
}