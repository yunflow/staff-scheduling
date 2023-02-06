package com.zw.team.service;

import com.zw.team.domain.*;

/**
 * @author Zhaojie
 * @Description 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法。
 */
public class NameListService {
    private Employee[] employees; // employees用来保存公司所有员工对象

    /**
     * 根据项目提供的Data类构建相应大小的employees数组
     * 再根据Data类中的数据构建不同的对象，
     * 包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
     * 将对象存于数组中
     */
    public NameListService() {
        // create list
        employees = new Employee[Data.EMPLOYEES.length];

        for (int i = 0; i < Data.EMPLOYEES.length; i++) {

            // get employee type
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);

            // get id, name, age, salary
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);

            // implement equipment, bonus, stock
            Equipment equipment = null;
            double bonus;
            int stock;

            // EMPLOYEE, PROGRAMMER, DESIGNER, ARCHITECT
            switch (type) {
                case Data.EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case Data.PROGRAMMER:
                    equipment = creatEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case Data.DESIGNER:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case Data.ARCHITECT:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;
            }
        }
    }

    /**
     * @param index
     * @return
     */
    private Equipment creatEquipment(int index) {
        int type = Integer.parseInt(Data.EQUIPMENTS[index][0]);

        switch (type) {
            case Data.PC:
                return new PC(Data.EQUIPMENTS[index][1], Data.EQUIPMENTS[index][2]);
            case Data.NOTEBOOK:
                return new NoteBook(Data.EQUIPMENTS[index][1], Double.parseDouble(Data.EQUIPMENTS[index][2]));
            case Data.PRINTER:
                return new Printer(Data.EQUIPMENTS[index][1], Data.EQUIPMENTS[index][2]);
        }

        return null;
    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }

        throw new TeamException("not proper ID");
    }
}
