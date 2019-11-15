package com.pcz.ch5;

import com.pcz.ch4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author picongzhi
 */
public class Filtering {
    public static void main(String[] args) {
        List<Dish> vegetarianMenu = Dish.menu.stream().
                filter(Dish::isVegetarian).
                collect(Collectors.toList());
        vegetarianMenu.forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().
                filter(i -> i % 2 == 0).
                distinct().
                forEach(System.out::println);

        List<Dish> dishesLimit = Dish.menu.stream().
                filter(dish -> dish.getCalories() > 300).
                limit(3).
                collect(Collectors.toList());
        dishesLimit.forEach(System.out::println);

        List<Dish> dishesSkipt = Dish.menu.stream().filter(dish -> dish.getCalories() > 300).skip(2).collect(Collectors.toList());
        dishesSkipt.forEach(System.out::println);
    }
}
