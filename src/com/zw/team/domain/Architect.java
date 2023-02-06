package com.zw.team.domain;

/**
 * @author Zhaojie
 */
public class Architect extends Designer {
    private int stock;

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails() + "\tDesigner\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment().getDescription();
    }
}
