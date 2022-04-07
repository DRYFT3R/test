package com.example.ternium.dto;

import java.util.ArrayList;
import java.util.List;

public class KpiParametroInVo {

    private String entidad;
    private List<Parametro> parametros = new ArrayList<>();

    public List<Parametro> getParametros() {
        return parametros;
    }

    public void setParametros(List<Parametro> parametros) {
        this.parametros = parametros;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public static class Parametro {

        private String str;
        private List<String> listStr;
        private Long number;
        private List<Long> listNumber;

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public List<String> getListStr() {
            return listStr;
        }

        public void setListStr(List<String> listStr) {
            this.listStr = listStr;
        }

        public Long getNumber() {
            return number;
        }

        public void setNumber(Long number) {
            this.number = number;
        }

        public List<Long> getListNumber() {
            return listNumber;
        }

        public void setListNumber(List<Long> listNumber) {
            this.listNumber = listNumber;
        }

        @Override
        public String toString() {
            return "Parametro{" +
                    "str='" + str + '\'' +
                    ", listStr=" + listStr +
                    ", number=" + number +
                    ", listNumber=" + listNumber +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "KpiParametroInVo{" +
                "entidad='" + entidad + '\'' +
                ", parametros=" + parametros +
                '}';
    }
}
