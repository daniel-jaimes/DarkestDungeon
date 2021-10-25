package model;

import java.util.Random;

public class Bandolero extends Character {
    public Bandolero() {
        super(5, 4, 2, 4);
    }

    @Override
    protected String getTipo(){
        return this.getClass().getSimpleName();
    }
    @Override
    public void descansar(){
        super.maxHealth(5);
    }
    //HABILITIES - return hurt
    @Override
    public int habilidad1(){
        recoverHealth(2);
        System.out.println(descripcionHabilidad1());
        return 1;
    }
    @Override
    public int habilidad2(){
        System.out.println(descripcionHabilidad2());
        return -1;
    }
    @Override
    public int habilidad3(){
        int dado = new Random().nextInt(6) + 1;
        if(dado >= 4) {
            System.out.println(descripcionHabilidad3());
            return 3;
        }
        return super.habilidad3();
    }
    //DESCRIPCIONES DE HABILIDAD - TO DO
    @Override
    String descripcionHabilidad1() {
        return "Recupera 2 de salud y 1 de dano";
    }
    @Override
    String descripcionHabilidad2() {
        return "Menos 1 de dano";
    }
    @Override
    String descripcionHabilidad3() {
        return "3 de dano";
    }

}
