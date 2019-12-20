package task3.task2.model;

import java.util.Arrays;
import java.util.Comparator;

public class ShopModel {

    private int departmentsCount;
    private Shop.Department[] departments = Shop.getDepartments();

    public ShopModel(){
        this.departmentsCount = 0;
    }

    public Shop.Department[] getDepartments(){return departments;}

    public void pushDepartment(Shop.Department department){
        if (departments.length == departmentsCount)
            resize(departments.length * 2);
        departments[departmentsCount++] = department;
    }

    public void deleteDepartment(Shop.Department department) {
        for (int i =0; i < departments.length; i++)
            if (departments[i].equals(department)) {
                System.arraycopy(departments, i + 1, departments, i, departments.length - 1 - i);
                break;
            }
        departmentsCount--;
        if (departmentsCount == departments.length/2)
            resize(departments.length/2);
    }

    public Shop.Department[] sortDepartments() {
        Shop.Department[] copy = Arrays.copyOf(departments, departments.length);
        Arrays.sort(copy, new Comparator<Shop.Department>() {
            @Override
            public int compare(Shop.Department o1, Shop.Department o2) {
                return o1.getDepartmentName().compareTo(o2.getDepartmentName());
            }
        });
        return copy;
    }
        private void resize(int capacity){
            departments = Arrays.copyOf(departments, capacity);
    }


}
