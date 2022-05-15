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

    public Clima() {
    }

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
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}