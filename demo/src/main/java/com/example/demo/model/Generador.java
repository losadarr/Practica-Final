package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("GENERADOR")
public class Generador {
    private @Column("ID") @Id Long id;
    private @Column("RPM") Long rpm;
    private @Column("VOLTAJE") Long voltaje;
    private @Column("PRESION") Long presion;
    private @Column("ESTADO") String estado;

    public Generador() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRpm() {
        return rpm;
    }

    public void setRpm(Long rpm) {
        this.rpm = rpm;
    }

    public Long getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(Long voltaje) {
        this.voltaje = voltaje;
    }

    public Long getPresion() {
        return presion;
    }

    public void setPresion(Long presion) {
        this.presion = presion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        Generador other = (Generador) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}