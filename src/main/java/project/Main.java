package project;

import project.controller.CoffeeController;

public class Main {

    public static void main(String[] args) {
        CoffeeController coffeeController = new CoffeeController(30,3);
        coffeeController.reply();

    }
}
