import java.util.ArrayList;
import java.util.List;
public class Vehicle {
    private String type; // тип (автомобиль, велосипед и т.п.)
    private String color; // цвет
    private double speed; // скорость
    private boolean hasEngine; // есть ли двигатель
    private String engineType; // тип двигателя (если имеется)
    private double price; // цена
    private String[] owners; // владельцы
    // Конструктор
    public Vehicle(String type, String color, double speed, boolean hasEngine, String engineType, double price, String[] owners) {
        this.type = type;
        this.color = color;
        this.speed = speed;
        this.hasEngine = hasEngine;
        this.engineType = engineType;
        this.price = price;
        this.owners = owners;
    }
    // Геттеры и сеттеры
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public boolean hasEngine() {
        return hasEngine;
    }
    public void setHasEngine(boolean hasEngine) {
        this.hasEngine = hasEngine;
    }
    public String getEngineType() {
        return engineType;
    }
    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String[] getOwners() {
        return owners;
    }
    public void setOwners(String[] owners) {
        this.owners = owners;
    }
    // Метод ускорения
    public void accelerate(double increment) {
        this.speed += increment;
        System.out.println("Ускорение! Новая скорость: " + this.speed);
    }
    // Метод замедления
    public void decelerate(double decrement) {
        this.speed -= decrement;
        if (this.speed < 0) {
            this.speed = 0; // Скорость не может быть отрицательной
        }
        System.out.println("Замедление! Новая скорость: " + this.speed);
    }
    // Метод расчета пройденного расстояния
    public double calculateDistance(double time) {
        return this.speed * time;
    }
    // Метод газ
    public void gas() {
        new Thread(() -> {
            try {
                while (true) {
                    System.out.println("Ускорение: " + speed + " м/с");
                    Thread.sleep(1000); // Задержка в 1 секунду
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
    public static class Main {
        public static void main(String[] args) {
            String[] owners = {"Иван", "Петр"};
            Vehicle vehicle = new Vehicle("Автомобиль", "Красный", 60.0, true, "Бензиновый", 25000.0, owners);
            vehicle.accelerate(10); // Увеличиваем скорость
            vehicle.decelerate(5); // Уменьшаем скорость
            double distance = vehicle.calculateDistance(2); // Расчет расстояния за 2 часа
            System.out.println("Пройденное расстояние: " + distance + " км");
            vehicle.gas(); // Запуск метода газ
        }
    }
}