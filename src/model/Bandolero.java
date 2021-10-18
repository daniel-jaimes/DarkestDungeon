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
    //HABILITIES
    @Override
    public int habilidad1(){
        recoverHealth(2);
        return 1;
    }
    @Override
    public int habilidad2(){
        int dano, dado1, dado2;
        Random rnd = new Random();
        dado1 = rnd.nextInt(6) + 1;
        dado2 = rnd.nextInt(6) + 1;
        dano = dado1 + dado2;
        if(dano == 7) return -5;
        return super.habilidad2();
    }
    @Override
    public int habilidad3(){
        return -1;
    }
}
