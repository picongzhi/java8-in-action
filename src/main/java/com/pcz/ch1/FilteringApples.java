package com.pcz.ch1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author picongzhi
 */
public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
        System.out.println(filterApples(inventory, FilteringApples::isGreenApple));
        System.out.println(filterApples(inventory, FilteringApples::isHeavyApple));
        System.out.println(filterApples(inventory, (Apple apple) -> "green".equals(apple.getColor())));
        System.out.println(filterApples(inventory, (Apple apple) -> apple.getWeight() > 150));
        System.out.println(filterApples(inventory, (Apple apple) -> apple.getWeight() < 80 || "brown".equals(apple.getColor())));
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterHeacyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
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
}
