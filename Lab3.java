import java.util.ArrayList;
import java.util.List;
public class Lab3 {
    private int health;
    private String eyeColor;
    private String skinColor;
    private List<String> skills;
    // Конструктор
    public Lab3(int health, String eyeColor, String skinColor) {
        this.health = health;
        this.eyeColor = eyeColor;
        this.skinColor = skinColor;
        this.skills = new ArrayList<>();
    }
    // Геттеры и сеттеры
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public String getEyeColor() {
        return eyeColor;
    }
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }
    public String getSkinColor() {
        return skinColor;
    }
    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }
    public List<String> getSkills() {
        return skills;
    }
    // Метод для приобретения нового навыка
    public void learnSkill(String skill) {
        if (!skills.contains(skill)) {
            skills.add(skill);
            System.out.println("Новый навык приобретен: " + skill);
        } else {
            System.out.println("Данный навык уже имеется: " + skill);
        }
    }
    // Метод для нанесения урона
    public void takeDamage(int damage) {
        if (damage < 0) {
            System.out.println("Урон не может быть негативным.");
            return;
        }
        health -= damage;
        if (health < 0) {
            health = 0;
        }
        System.out.println("Персонаж получил урон: " + damage + ". Текущее здоровье: " + health);
    }
    public static void main(String[] args) {
        Lab3 character = new Lab3(100, "синие", "светлая");
        character.learnSkill("Мечник");
        character.learnSkill("Маг");
        character.takeDamage(30);
        character.takeDamage(80);
    }
}