package com.zw.team.test;

import com.zw.team.domain.Employee;
import com.zw.team.service.NameListService;
import com.zw.team.service.TeamException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author Zhaojie
 */
public class NameListServiceTest {
    @Test
    void testGetAllEmployees() {
        NameListService service = new NameListService();
        Employee[] list = service.getAllEmployees();

        assertEquals(12, list.length);

        for (int i = 0; i < 12; i++) {
            System.out.println(list[i]);
        }
    }

    @Test
    void testGetEmployee() {
        NameListService service = new NameListService();
        int id = 13;

        try {
            service.getEmployee(id);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }

}
