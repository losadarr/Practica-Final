package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("CLIMA")
public class Clima {

    private @Column("ID") @Id Long id;
    private @Column("TEMPERATURA") Long temperatura;
    private @Column("DESCRIPCION") String descripcion;
    private @Column("PRECIPITACION") Long precipitacion;
    private @Column("VELOCIDAD_VIENTO") Long velocidad_viento;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getTemperatura() {
        return temperatura;
    }
    public void setTemperatura(Long temperatura) {
        this.temperatura = temperatura;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Long getPrecipitacion() {
        return precipitacion;
    }
    public void setPrecipitacion(Long precipitacion) {
        this.precipitacion = precipitacion;
    }
    public Long getVelocidad_viento() {
        return velocidad_viento;
    }
    public void setVelocidad_viento(Long velocidad_viento) {
        this.velocidad_viento = velocidad_viento;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((precipitacion == null) ? 0 : precipitacion.hashCode());
        result = prime * result + ((temperatura == null) ? 0 : temperatura.hashCode());
        result = prime * result + ((velocidad_viento == null) ? 0 : velocidad_viento.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Clima other = (Clima) obj;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (precipitacion == null) {
            if (other.precipitacion != null)
                return false;
        } else if (!precipitacion.equals(other.precipitacion))
            return false;
        if (temperatura == null) {
            if (other.temperatura != null)
                return false;
        } else if (!temperatura.equals(other.temperatura))
            return false;
        if (velocidad_viento == null) {
            if (other.velocidad_viento != null)
                return false;
        } else if (!velocidad_viento.equals(other.velocidad_viento))
            return false;
        return true;
    }

    
}