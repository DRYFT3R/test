package com.example.ternium.dto;

import java.util.List;

public class GpsPatenteOutVO2 {

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

        private String ultimaLatitud;
        private String ultimaLongitud;
        private String fechaLectura;

        public String getUltimaLatitud() {
            return ultimaLatitud;
        }

        public void setUltimaLatitud(String ultimaLatitud) {
            this.ultimaLatitud = ultimaLatitud;
        }

        public String getUltimaLongitud() {
            return ultimaLongitud;
        }

        public void setUltimaLongitud(String ultimaLongitud) {
            this.ultimaLongitud = ultimaLongitud;
        }

        public String getFechaLectura() {
            return fechaLectura;
        }

        public void setFechaLectura(String fechaLectura) {
            this.fechaLectura = fechaLectura;
        }

        @Override
        public String toString() {
            return "GpsLogitudVo{" +
                    "ultimaLatitud='" + ultimaLatitud + '\'' +
                    ", ultimaLongitud='" + ultimaLongitud + '\'' +
                    ", fechaLectura='" + fechaLectura + '\'' +
                    '}';
        }
    }
}
