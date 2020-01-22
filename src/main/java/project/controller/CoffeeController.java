package project.controller;

import project.model.CoffeeModel;
import project.model.CoffeeTypes;
import project.model.entities.Coffee;
import project.view.CoffeeView;

public class CoffeeController {

    private CoffeeModel<Coffee> coffeeModel;
    private CoffeeView coffeeView;


    public CoffeeController(long price, double volume){
        IParser coffeeParser = new CoffeeParser(price, volume);
        coffeeModel = new CoffeeModel<>(coffeeParser.parse());
        coffeeView = new CoffeeView();

    }


    public void reply(){
        coffeeView.printMessage(CoffeeView.LOAD_INFO, coffeeModel.getCoffees().toString());
        coffeeView.printMessage(CoffeeView.SORT_INFO, coffeeModel.sortByPriceVolumeRatio().toString());
        coffeeView.printMessage(CoffeeView.FILTER_PRICE_INFO, coffeeModel.filterByPriceMoreThen(2).toString());
        coffeeView.printMessage(CoffeeView.FILTERED_SORT_INFO, coffeeModel.filterByCoffeeSort(CoffeeTypes.ROBUSTA).toString());
    }
}
