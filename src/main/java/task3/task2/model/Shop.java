package task3.task2.model;

public class Shop {

    private static String name;
    private static Department[] departments;

    static {
        name = "shopName";
        departments = new Department[1];
    }

    private  Shop(){}

    public static Department parse(String line){
        String[] params = line.split("[,]");
        return new Shop.Department(params[0], params[1], params[2],params[3]);
    }

    public static Department[] getDepartments(){ return departments;}



     protected static class Department{
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

        public String getDepartmentName(){return  departmentName;}

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


