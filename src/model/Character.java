package model;

public class Character {
    private int health;
    private int stress;
    private int minScope;
    private int maxScope;
    private boolean life;
    public Character(int health, int stress, int minScope, int maxScope) {
        this.health = health;
        this.stress = stress;
        this.minScope = minScope;
        this.maxScope = maxScope;
        this.life = true;
    }

    @Override
    public String toString(){
        return "[tipo=" + getTipo() + ", salud=" + this.health + ", estres=" + this.stress + "]";
    }
    protected String getTipo(){
        return "Soy la clase papasote";
    }
    public void descansar(){
        System.out.println("A MEJORAR A OTRO!");
    }
    //SETTERS
    void maxHealth(int health){
        this.health = health;
    }
    //HABILITIES
    public int habilidad1(){
        System.out.println("Habilidad basica");
        return 1;
    }
    public int habilidad2(){
        System.out.println("Habilidad basica");
        return 1;
    }
    public int habilidad3(){
        System.out.println("Habilidad basica");
        return 1;
    }
    public boolean checkStress(){
        return 0 < this.stress;
    }
    public void danar(int dano){
        if(this.health <= dano && this.health >= 0) this.life = false;
        else this.health -= dano;
        if (dano < 0){
            if(this.stress <= Math.abs(dano))this.life = false;
            else this.stress = this.stress - Math.abs(dano);
        }
    }
    //SETTERS
    private void setStress(int stress) {
        this.stress = stress;
    }
    private void setHealth(int health){
        this.health = health;
    }
    protected void recoverStress(int stress){
        setStress(getStress() + stress);
    }
    protected void recoverHealth(int health){
        setHealth(getHealth() + health);
    }
    //GETTERS
    protected int getStress() {
        return this.stress;
    }
    protected int getHealth(){
        return this.health;
    }


    public int menu(){
        int dano = 0;
        System.out.println("Turno de: " + this);
        System.out.print("1 - " + descripcionHabilidad1() + "\n2 - " + descripcionHabilidad2() + "\n3 - " + descripcionHabilidad3());
        dano += habilidad1();
        dano += habilidad2();
        dano += habilidad3();
        return dano;
    }

    //DESCRIPCIONES DE HABILIDAD
    private String descripcionHabilidad1() {
        return "Habilidad1 - no tiene efecto";
    }
    private String descripcionHabilidad2() {
        return "Habilidad2 - no tiene efecto";
    }
    private String descripcionHabilidad3() {
        return "Habilidad3 - no tiene efecto";
    }

    public int habilidadRandom(int valor){
        int dano = 0;
        switch(valor){
            case 0:
                dano = habilidad1();
                break;
            case 1:
                dano = habilidad2();
                break;
            case 2:
                dano = habilidad3();
                break;
            case 3:
                dano = 0;
                //Ha fallado
                break;
        }
        return dano;
    }
}
