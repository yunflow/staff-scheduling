package com.zw.team.test;

import com.zw.team.domain.Employee;
import com.zw.team.service.NameListService;
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

}
