package task3.task2.view;

public class ShopView {

    public static final String INPUT_DEPARTMENT = "Input department (departmentName=,location=,product=,service=) -> ";
    public static final String INPUT_ACTION = "Input action (1 - add department, 2-remove department, 3-sort departments, 0-exit) -> ";
    public static final String RESULT = "\n\tDepartments: \n";
    public static final String SORT_RESULT = "\tDepartments sorted by name: \n";

    public void printMessage(String msg, String result){
        System.out.println(msg + result+"\n");
    }
    public void printMessage(String msg){
        System.out.print(msg);
    }

    public void printMenu(){
        System.out.println("\nMenu: \n");
        System.out.println("\t Press 1 to create department");
        System.out.println("\t Press 2 delete department");
        System.out.println("\t Press 3 to sort department");
        System.out.println("\t Press 0 to exit\n");
    }

}
