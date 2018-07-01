package br.com.sapatointeligente.utils;

public enum TipoGatilho {

    PESO("Peso"),
    PRESSAO("Pressao"),
    TEMPODEPE("Tempo de pe"),
    DISTANCIAPERCORRIDA("Distancia percorrida"),
    DOENCA("Doenca");

    private String name;

    TipoGatilho(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
