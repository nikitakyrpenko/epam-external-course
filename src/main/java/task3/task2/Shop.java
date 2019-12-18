package task3.task2;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private String name;
    private List<Department> departments;
    private int departmentsCount;

    public Shop(String name){
        this.name = name;
        this.departments = new ArrayList<>();
        this.departmentsCount = 0;
    }

    public void pushDepartment(Department department){
        departments.add(department);
        departmentsCount++;
    }

    public void deleteDepartment(Department department) {
        departments.remove(department);
        departmentsCount--;
    }



    @Override
    public String toString() {
        return departments.toString();
    }

    public class Department{
        private String departmentName;
        private String location;
        private String productType;
        private String service;

        public Department(String departmentName, String location, String productType, String service) {
            this.departmentName = departmentName;
            this.location = location;
            this.productType = productType;
            this.service = service;
        }

        @Override
        public boolean equals(Object obj) {
           Department dep = (Department) obj;
           if (this.departmentName.equals(dep.departmentName) &&
                   this.location.equals(dep.location) &&
                   this.productType.equals(dep.productType) &&
                   this.service.equals(dep.service))
               return true;
           return false;
        }

        @Override
        public String toString() {
            return "Department{" +
                    "departmentName='" + departmentName + '\'' +
                    ", location='" + location + '\'' +
                    ", productType='" + productType + '\'' +
                    ", service='" + service + '\'' +
                    '}';
        }
    }


}
