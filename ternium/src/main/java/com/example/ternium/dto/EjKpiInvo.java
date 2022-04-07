package com.example.ternium.dto;

import com.example.ternium.dto.AtributoKpiInVo;

import java.util.ArrayList;
import java.util.List;

public class EjKpiInvo {

    private String kpi;
    private List<AtributoKpiInVo> atributos = new ArrayList<>();

    public String getKpi() {
        return kpi;
    }

    public void setKpi(String kpi) {
        this.kpi = kpi;
    }

    public List<AtributoKpiInVo> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<AtributoKpiInVo> atributos) {
        this.atributos = atributos;
    }

    @Override
    public String toString() {
        return "EjKpiInvo{" +
                "kpi='" + kpi + '\'' +
                ", atributos=" + atributos +
                '}';
    }
}
