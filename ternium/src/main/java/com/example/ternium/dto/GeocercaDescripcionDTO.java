package com.example.ternium.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

public class GeocercaDescripcionDTO implements Serializable {


    public GeocercaDescripcionDTO() {
    }

    public GeocercaDescripcionDTO(BigDecimal latitude, BigDecimal longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private Long id;

    private Long geocercaId;

    private Long vertexIdLong;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private String instancia;

    private ZonedDateTime createAt;

    private ZonedDateTime updatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGeocercaId() {
        return geocercaId;
    }

    public void setGeocercaId(Long geocercaId) {
        this.geocercaId = geocercaId;
    }

    public Long getVertexIdLong() {
        return vertexIdLong;
    }

    public void setVertexIdLong(Long vertexIdLong) {
        this.vertexIdLong = vertexIdLong;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getInstancia() {
        return instancia;
    }

    public void setInstancia(String instancia) {
        this.instancia = instancia;
    }

    public ZonedDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(ZonedDateTime createAt) {
        this.createAt = createAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GeocercaDescripcionDTO geocercaDescripcionDTO = (GeocercaDescripcionDTO) o;
        if (geocercaDescripcionDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), geocercaDescripcionDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "GeocercaDescripcionDTO{" +
                "id=" + getId() +
                ", geocercaId=" + getGeocercaId() +
                ", vertexIdLong=" + getVertexIdLong() +
                ", latitude=" + getLatitude() +
                ", longitude=" + getLongitude() +
                ", instancia='" + getInstancia() + "'" +
                ", createAt=" + createAt +
                ", updatedAt=" + updatedAt +
                "}";
    }
}
