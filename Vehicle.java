import java.util.Arrays;

public class Vehicle {
    private double distance; // дистанция
    private String type; // тип транспортного средства
    private String color; // цвет
    private double speed; // скорость в км/ч
    private static boolean hasEngine; // есть ли двигатель
    private String engineType; // тип двигателя
    private double price; // цена
    private String[] owners; // владельцы
    private double time;

    // Конструктор
    public Vehicle(String type, String color, double speed, boolean hasEngine, String engineType, double price, String[] owners) {
        this.type = type;
        this.color = color;
        this.speed = speed;
        this.hasEngine = hasEngine;
        this.engineType = engineType;
        this.price = price;
        this.owners = owners;
        this.distance = distance;
    }
    // Геттеры и сеттеры
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
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
    // Метод для ускорения
    public void accelerate(double increment) {
        this.speed += increment;
        System.out.println("Ускорение. Новая скорость: " + this.speed + " км/ч");
    }
    // Метод для замедления
    public void decelerate(double decrement) {
        this.speed -= decrement;
        if (this.speed < 0) {
            this.speed = 0;
        }
        System.out.println("Замедление. Новая скорость: " + this.speed + " км/ч");
    }

    // Метод для расчета пройденного расстояния
    public double distance(double time) {
        this.time = time;
        return speed * time;
        // расстояние = скорость * время
    }
    // Метод газ
    public void gas() {
        for (int time = 0; true; time++) {
            double d = distance(time);
            System.out.println("Все еще едем, скорость "
                    + this.speed + "\nРасстоояние " + d);
            if (this.speed < 110) {
                this.speed += 10;
            }
            if (d < 10000)
                continue;
            System.out.println("Прибыли! С вас 100 рублей");
            break;
        }
    }

    public static void main(String[] args) {
        String[] owners = {"Иван", "Петр"};
        Vehicle vehicle = new Vehicle("Автомобиль", "Красный", 60, true, "Бензиновый", 15000, owners);
        System.out.println("Тип: " + vehicle.getType() +" Цвет: " + vehicle.getColor() + " Скорость: " + vehicle.getSpeed() + " км/ч " +
                " Владелец: " + Arrays.toString(vehicle.getOwners()) + " Цена: " + vehicle.getPrice() +
                " Тип двигателя: " + vehicle.getEngineType() + " Есть двигатель: " + (hasEngine ? "Да" : "Нет"));
        vehicle.gas(); // Запуск метода газ
    }
}



