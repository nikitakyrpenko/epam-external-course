package task3.task2;

public class Main {



    public static void main(String... args){
        Shop shop = new Shop("shopName");
        Shop.Department department = shop.new Department("test1","loc1","product1","service1");
        Shop.Department department2 = shop.new Department("test2","loc1","product2","service2");

        shop.pushDepartment(department);
        shop.pushDepartment(department2);
        System.out.println(shop);

        shop.deleteDepartment(department);
        System.out.println(shop);
    }


}
