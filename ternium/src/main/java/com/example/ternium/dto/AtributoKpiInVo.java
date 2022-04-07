package com.example.ternium.dto;

public class AtributoKpiInVo {

    private String atributo;
    private String valor;

    public AtributoKpiInVo(String atributo, String valor) {
        this.atributo = atributo;
        this.valor = valor;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "AtributoKpiInVo{" +
                "atributo='" + atributo + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }
}
