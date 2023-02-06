package com.zw.team.domain;

import com.zw.team.service.Status;

/**
 * @author Zhaojie
 */
public class Programmer extends Employee {
    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Equipment getEquipment() {
        return equipment;
    }

    public Status getStatus() {
        return status;
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return getDetails() + "\tProgrammer\t" + status + "\t\t\t\t\t" + equipment.getDescription();
    }
}
