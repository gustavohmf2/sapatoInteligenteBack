package br.com.sapatointeligente.utils;


public class SapatoTemp {


    private  static SapatoTemp instance;
    private static Thread id;

    public SapatoTemp() {
    }

    public static SapatoTemp getSapatoTemp() {
        if(instance == null) {
            instance = new SapatoTemp();
        }
        return instance;
    }

    public void setId(Thread id) {
        this.id = id;
    }

    public Thread getId() {
        return this.id;
    }

}
