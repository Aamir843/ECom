package dev.akhtar.ProductService.dtos;

import java.util.*;
import java.util.stream.Collectors;

public class SAP {
    //Array is acs order
    //duplocate elements
    // 2 3 1 3 5
    // 1 2  3 3 3 5 6 7 0


    public void removeDuplicates(int[] A) {
        int n = A.length;

        List<Integer> ans = new ArrayList<>();
        ans.add(A[0]);
        for (int i = 1; i < n; i++) {
            if (A[i] != A[i - 1]) {
                ans.add(A[i]);
            }

        }

        for(int a : ans) {
            System.out.println(a + " ,");
        }

    }

    public static void main(String[] args) {
//        SAP obj =  new SAP();
//
//        int[] arr = {1, 2,  3, 3 ,3 ,5 ,6, 7};
//
//        List<Integer> l= Arrays.stream(arr).filter(i->i%2==1).mapToObj(i->i*i*i).toList();
//
//
//        List<Integer> a= Arrays.stream(arr)
//                .filter(i->i%2==1)
//                .mapToObj(i->i*i*i)
//                .collect(Collectors.toList());
//
//        System.out.println(a);
//
//        obj.removeDuplicates(arr);

        List<String> fruits = List.of("Mango","Grapes","Guava");

        fruits.stream().map(f-> f +" "+f.length()).forEach(System.out::println);







    }








    }





