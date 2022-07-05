package com.incorta.observability.java.reflection;

public class Sheep extends Animal implements Moving {
    private String id;
    private String name;
    String nickName;
    private double weight;
    public String owner;

    public Sheep() {
    }

    public Sheep(String id, String name, String nickName, double weight, String owner) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.weight = weight;
        this.owner = owner;
    }

    public Sheep(String sheepId) {
        this.id = sheepId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

    public double getWeight() {
        return weight;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String getSound() {
        return "maaaa2";
    }

    @Override
    public void eats() {
        System.out.println("Eats grass");
    }

    @Override
    public String getMovement() {
        String movement = "walks on four";
        System.out.println(movement);
        return movement;
    }

    @Override
    public String toString() {
        return "Sheep{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", nickName='" + nickName + '\'' +
            ", weight=" + weight +
            ", owner='" + owner + '\'' +
            '}';
    }
}
