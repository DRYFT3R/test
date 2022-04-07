package com.example.ternium.dto;

import java.util.List;

public class GpsPatenteOutVo {

    List<GpsLogitudVo> ubicacion;

    public List<GpsLogitudVo> getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(List<GpsLogitudVo> ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "GpsPatenteOutVO{" +
                "ubicacion=" + ubicacion +
                '}';
    }

    public static class GpsLogitudVo {

        private String latitud;
        private String longitud;
        private String ultimoReporte;
        private String placa;

        public String getLatitud() {
            return latitud;
        }

        public void setLatitud(String latitud) {
            this.latitud = latitud;
        }

        public String getLongitud() {
            return longitud;
        }

        public void setLongitud(String longitud) {
            this.longitud = longitud;
        }

        public String getUltimoReporte() {
            return ultimoReporte;
        }

        public void setUltimoReporte(String ultimoReporte) {
            this.ultimoReporte = ultimoReporte;
        }

        public String getPlaca() {
            return placa;
        }

        public void setPlaca(String placa) {
            this.placa = placa;
        }

        @Override
        public String toString() {
            return "GpsLogitudVo{" +
                    "latitud='" + latitud + '\'' +
                    ", longitud='" + longitud + '\'' +
                    ", ultimoReporte='" + ultimoReporte + '\'' +
                    ", placa='" + placa + '\'' +
                    '}';
        }
    }
}
