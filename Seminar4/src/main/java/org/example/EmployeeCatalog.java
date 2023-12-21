package org.example;

import java.util.ArrayList;

/*
Добавить метод, который ищет сотрудника по стажу (может быть список)
Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
Добавить метод, который ищет сотрудника по табельному номеру
Добавить метод добавление нового сотрудника в справочник
 */
public class EmployeeCatalog {
    private ArrayList<Employee> catalog;
    private int size;
    public EmployeeCatalog(){
        this.catalog = new ArrayList<>();
        this.size = 0;
    }

    public ArrayList<Employee> getCatalog() {
        return catalog;
    }

    public int getSize() {
        return size;
    }

    public ArrayList<Employee> findEmployeesByExperience(int yearsOfExperience){
        ArrayList<Employee> resultEmployeesByExperience = new ArrayList<>();
        for (int i = 0; i < catalog.size(); i++) {
            if(catalog.get(i).getYearsOfExperience() == yearsOfExperience){
                resultEmployeesByExperience.add(catalog.get(i));
            }
        }
        return resultEmployeesByExperience;
    }

    public ArrayList<String> findEmployeesPhoneByName(String name){
        ArrayList<String> resultEmployeesPhoneByName = new ArrayList<>();
        for (int i = 0; i < catalog.size(); i++) {
            if(catalog.get(i).getName().equals(name)){
                resultEmployeesPhoneByName.add(catalog.get(i).getName());
            }
        }
        return resultEmployeesPhoneByName;
    }

    public Employee findEmployeeByEmployeeID(int employeeID){
        for (int i = 0; i < catalog.size(); i++) {
            if(catalog.get(i).getEmployeeID() == employeeID){
                return catalog.get(i);
            }
        }
        return null;
    }

    public void addNewEmployee(Employee employee){
        catalog.add(employee);
        size++;
    }

}
