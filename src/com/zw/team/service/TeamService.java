package com.zw.team.service;

import com.zw.team.domain.Employee;
import com.zw.team.domain.Programmer;

/**
 * @author Zhaojie
 * @Description 关于开发团队成员的管理：添加、删除等。
 */
public class TeamService {
    private static int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;

    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    public void addMember(Employee e) throws TeamException {
        //成员已满，无法添加
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }
        //该成员不是开发人员，无法添加
        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        //该员工已在本开发团队中
        if (isExist(e)) {
            throw new TeamException("该员工已在本开发团队中");
        }
        //该员工已是某团队成员 / 该员正在休假，无法添加
        Programmer p = (Programmer) e;
        if ("BUSY".equals(p.getStatus().getNAME())) {
            throw new TeamException("该员工已是某团队成员");
        } else if ("VACATION".equals(p.getStatus().getNAME())) {
            throw new TeamException("该员正在休假，无法添加");
        }
        //团队中至多只能有一名架构师

        //团队中至多只能有两名设计师

        //团队中至多只能有三名程序员

    }

    /**
     * check if the employee has already exists the team
     *
     * @param e
     * @return
     */
    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == e.getId()) {
                return true;
            }
        }
        return false;
    }

    public void removeMember(int memberId) {

    }
}
