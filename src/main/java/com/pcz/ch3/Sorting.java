package com.pcz.ch3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")));

        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        inventory.set(1, new Apple(30, "green"));
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        System.out.println(inventory);

        inventory.set(1, new Apple(20, "red"));
        inventory.sort((apple1, apple2) -> apple1.getWeight().compareTo(apple2.getWeight()));
        System.out.println(inventory);

        inventory.set(1, new Apple(10, "red"));
        inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(inventory);
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

    static class AppleComparator implements Comparator<Apple> {
        @Override
        public int compare(Apple apple1, Apple apple2) {
            return apple1.getWeight().compareTo(apple2.getWeight());
        }
    }
}
