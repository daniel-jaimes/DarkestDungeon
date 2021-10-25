package model;

import java.util.Random;

public class Abomination extends Character {

    public Abomination() {
        super(3, 4, 1, 2);
    }

    @Override
    protected String getTipo(){
        return this.getClass().getSimpleName();
    }
    @Override
    public void descansar(){
        super.maxHealth(3);
    }
    //HABILITIES
    @Override
    public int habilidad1(){
        System.out.println(descripcionHabilidad1());
        return 3;
    }
    @Override
    public int habilidad2(){
        int hurt, dado1, dado2;
        Random rnd = new Random();
        dado1 = rnd.nextInt(6) + 1;
        dado2 = rnd.nextInt(6) + 1;
        hurt = dado1 + dado2;
        System.out.println(descripcionHabilidad2());
        return hurt;
    }
    @Override
    public int habilidad3(){
        System.out.println(descripcionHabilidad3());
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
