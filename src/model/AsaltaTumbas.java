package model;

import java.util.Random;

public class AsaltaTumbas extends Character {


    public AsaltaTumbas() {
        super(4, 5, 1, 3);
    }

    @Override
    protected String getTipo(){
        return this.getClass().getSimpleName();
    }
    @Override
    public void descansar(){
        super.maxHealth(4);
    }
    //HABILITIES
    @Override
    public int habilidad1(){
        int dado = new Random().nextInt(6) + 1;
        if(dado <= 3) return 3;
        return super.habilidad1();
    }
    @Override
    public int habilidad2(){
        return 2;
    }
    @Override
    public int habilidad3(){
        int dado = new Random().nextInt(6) + 1;
        if(dado >= 5) return -2;
        return super.habilidad3();
    }
}
