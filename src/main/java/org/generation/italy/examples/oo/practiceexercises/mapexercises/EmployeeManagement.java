package org.generation.italy.examples.oo.practiceexercises.mapexercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmployeeManagement  {
    static void main() {
        List<Employee> employers=new ArrayList<Employee>();
        Employee e1=new Employee("Daniele","Sciarrini","male",1234,100);
        Employee e2=new Employee("Vincenzo","Frecciarulo","male",1235,1000);
        Employee e3=new Employee("Pippo","Poco","male",1233,1500);
        Employee e4=new Employee("Pluto","Tanto","male",1232,1600);
        Employee e5=new Employee("Paperina","Qui","female",1231,1600);
        Employee e6=new Employee("Minnie","Topi","male",4123,1700);
        Employee e7=new Employee("Mio","Zio","male",3212,1200);
        Employee e8=new Employee("Mio","Nonno","male",2123,1500);
        Employee e9=new Employee("Gianna","Celeste","female",3123,1300);
        Employee e10=new Employee("Elon","Musk","male",9123,2100);

        employers.add(e1);
        employers.add(e2);
        employers.add(e3);
        employers.add(e4);
        employers.add(e5);
        employers.add(e6);
        employers.add(e7);
        employers.add(e8);
        employers.add(e9);
        employers.add(e10);

       HashMap<Integer,Employee> emp =new HashMap<>();

        for(Employee e: employers){
            emp.put(e.getId(),e);
        }

//      public String getEmployeeNameById(int id){
//
//        }


    }
//    @Override
//    public int compare(Object o1, Object o2) {
//        return 0;
//    }




}
