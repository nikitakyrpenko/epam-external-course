package task3.task2.contoller;
import task3.task2.model.Shop;
import task3.task2.model.ShopModel;
import task3.task2.view.ShopView;

import java.util.Arrays;
import java.util.Scanner;


public class ShopController {

    private ShopModel shopModel;
    private ShopView shopView;
    private Scanner scanner = new Scanner(System.in);

    public ShopController(){
        this.shopModel = new ShopModel();
        this.shopView = new ShopView();
    }

    public void startDialog(){
       shopView.printMenu();
        main:
        while (true){
            shopView.printMessage(ShopView.INPUT_DEPARTMENT);
            String line = validate(scanner.nextLine());
            shopView.printMessage(ShopView.INPUT_ACTION);
            int i = Integer.parseInt(scanner.nextLine());
            switch (i){
                case 1:
                    shopModel.pushDepartment(Shop.parse(line));
                    shopView.printMessage(ShopView.RESULT, Arrays.toString(shopModel.getDepartments()));
                    break ;
                case 2:
                    shopModel.deleteDepartment(Shop.parse(line));
                    shopView.printMessage(ShopView.RESULT, Arrays.toString(shopModel.getDepartments()));
                    break ;
                case 3:
                    shopModel.pushDepartment(Shop.parse(line));
                    shopView.printMessage(ShopView.SORT_RESULT, Arrays.toString(shopModel.sortDepartments()));
                    break ;
                case 0:
                    break main;
            }
        }
    }

    private String validate(String line){
        return line.trim().replaceAll("\\p{P}",",");
    }


}
