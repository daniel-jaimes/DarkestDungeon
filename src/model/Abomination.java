package model;

import java.util.Random;

public class Abomination extends Character {
    private final int health = 3;
    private final int stress = 4;
    public Abomination() {
        super(4, 2);
        super.setHealthAndStress(health, stress);
    }
    @Override
    public Character copy() {
        return super.copy();
    }
    @Override
    protected String getTipo(){
        return this.getClass().getSimpleName();
    }
    @Override
    public void descansar(){
        super.setHealth(health);
        super.setStress(stress);
    }
    //HABILITIES
    @Override
    public int habilidad1(){
        return 3;
    }
    @Override
    public int habilidad2(){
        int hurt, dado1, dado2;
        Random rnd = new Random();
        dado1 = rnd.nextInt(6) + 1;
        dado2 = rnd.nextInt(6) + 1;
        hurt = dado1 + dado2;
        return hurt;
    }
    @Override
    public int habilidad3(){
        return -1;
    }
    @Override
    String descripcionHabilidad1() {
        return "3 de dano";
    }
    @Override
    String descripcionHabilidad2() {
        return "Entre 2 y 12 de dano";
    }
    @Override
    String descripcionHabilidad3() {
        return "Menos 1 de dano";
    }
}
