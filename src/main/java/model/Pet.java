package model;

public class Pet {
    private String name;
    private String status;

    // Конструктор
    public Pet(String name, String status) {
        this.name = name;
        this.status = status;
    }

    // Геттеры и сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
