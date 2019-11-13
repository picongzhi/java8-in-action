package com.pcz.ch3;

import com.pcz.ch2.FilteringApples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author picongzhi
 */
public class Lambdas {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Hello!");
        runnable.run();

        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
        System.out.println(filter(inventory, (Apple apple) -> "green".equals(apple.getColor())));

        Comparator<Apple> comparator = (Apple apple1, Apple apple2) -> apple1.getWeight().compareTo(apple2.getWeight());
        inventory.sort(comparator);
        System.out.println(inventory);
    }

    public static List<Apple> filter(List<Apple> inventory, ApplePredicate applePredicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (applePredicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    public static class Apple {
        private Integer weight = 0;
        private String color = "";

        public Apple(Integer weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{color=" + color + ", weight=" + weight + "}";
        }
    }

    interface ApplePredicate {
        public boolean test(Apple apple);
    }
}
