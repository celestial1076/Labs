import java.util.Arrays;

public class Vehicle {
    private String type; // тип транспортного средства
    private String color; // цвет
    private double speed; // скорость в км/ч
    private boolean hasEngine; // есть ли двигатель
    private String engineType; // тип двигателя
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
    public double calculateDistance(double time) {
        return speed * time; // расстояние = скорость * время
    }
    // Метод газ
    public void gas() {
        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) { // Ускорение в течение 5 секунд
                    accelerate(10); // Увеличиваем скорость на 10 км/ч каждую секунду
                    Thread.sleep(1000); // Ждем 1 секунду
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    public static void main(String[] args) {
        String[] owners = {"Иван", "Петр"};
        Vehicle vehicle = new Vehicle("Автомобиль", "Красный", 60, true, "Бензиновый", 15000, owners);
        System.out.println("Тип: " + vehicle.getType());
        System.out.println("Цвет: " + vehicle.getColor());
        System.out.println("Скорость: " + vehicle.getSpeed() + " км/ч");
        System.out.println("Владелец: " + Arrays.toString(vehicle.getOwners()));
        System.out.println("Цена: " + vehicle.getPrice());
        System.out.println("Тип двигателя: " + vehicle.getEngineType());

        vehicle.gas(); // Запуск метода газ
    }
}
