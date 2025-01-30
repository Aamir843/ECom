package dev.akhtar.ProductService.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ascendion {


    class Student {
        Integer id;
        String name ;
        List<Integer> deptIds;
    }
    class Department {
        Integer departmentId;
        String deptName;
    }

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<Student>();
        List<Department> departmentList = new ArrayList<Department>();

        // All the departments with atleast two students
    }
}
