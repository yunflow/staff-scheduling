package com.zw.team.domain;

import com.zw.team.service.Status;

/**
 * @author Zhaojie
 */
public class Designer extends Programmer {
    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails() + "\tDesigner\t" + getStatus() + "\t" + bonus + "\t\t\t" + getEquipment().getDescription();
    }
}
