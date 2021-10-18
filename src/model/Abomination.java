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
        return 3;
    }
    @Override
    public int habilidad2(){
        int dano, dado1, dado2;
        Random rnd = new Random();
        dado1 = rnd.nextInt(6) + 1;
        dado2 = rnd.nextInt(6) + 1;
        dano = dado1 + dado2;
        return dano;
    }
    @Override
    public int habilidad3(){
        return -1;
    }



}
