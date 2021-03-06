package model;

import java.util.Random;

public class CazaRecompensas extends Character {
    private final int health = 3;
    private final int stress = 3;
    public CazaRecompensas() {
        super(2, 3);
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
        recoverStress(1);
        System.out.println(descripcionHabilidad1());
        return 1;
    }
    @Override
    public int habilidad2(){
        int hurt, dado1, dado2;
        Random rnd = new Random();
        dado1 = rnd.nextInt(6) + 1;
        dado2 = rnd.nextInt(6) + 1;
        hurt = dado1 + dado2;
        if(hurt == 7) {
            System.out.println(descripcionHabilidad2());
            return -5;
        }
        return super.habilidad2();
    }
    @Override
    public int habilidad3(){
        System.out.println(descripcionHabilidad3());
        return -1;
    }
    //DESCRIPCIONES DE HABILIDAD - TO DO
    @Override
    String descripcionHabilidad1() {
        return "Recupera 1 de estres y 1 de dano";
    }
    @Override
    String descripcionHabilidad2() {
        return "Menos 5 de dano";
    }
    @Override
    String descripcionHabilidad3() {
        return "Menos 1 de dano";
    }

}
