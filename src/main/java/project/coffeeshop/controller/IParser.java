package project.coffeeshop.controller;

import java.util.List;

public interface IParser<T> {

    List<T> parse();
}
