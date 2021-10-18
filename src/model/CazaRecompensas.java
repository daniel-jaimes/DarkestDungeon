package model;

import java.util.Random;

public class CazaRecompensas extends Character {

    public CazaRecompensas() {
        super(3, 3, 2, 3);
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
        recoverStress(1);
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
    //DESCRIPCIONES DE HABILIDAD - TO DO
    private String descripcionHabilidad1() {
        return "Habilidad1 - no tiene efecto";
    }
    private String descripcionHabilidad2() {
        return "Habilidad2 - no tiene efecto";
    }
    private String descripcionHabilidad3() {
        return "Habilidad3 - no tiene efecto";
    }

}
