package ru.codreview.lombok.builder;

import lombok.Builder;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@Builder //реализация паттерна билдер
@ToString
public class Car {
    String color;
    String plate;
    int maxSpeed;
    @Singular //позволяет добавлять элементы поштучно
    List<String> drivers;

    //переопределяем методы билдера
    static class CarBuilder {
        CarBuilder color(String color) {
            this.color = color + " custom";
            return this;
        }

        Car build() {
            System.out.println("i am custom");
            return new Car(color, plate, maxSpeed, drivers);
        }
    }


    public static void main(String[] args) {
        Car car = Car.builder()
                .color("Red")
                .plate("P")
                .driver("Sasha")
                .driver("Fedor")
                .build();
        System.out.println(car);
    }

}
