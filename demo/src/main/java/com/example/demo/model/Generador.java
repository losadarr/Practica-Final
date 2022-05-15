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
        result = prime * result + ((estado == null) ? 0 : estado.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((presion == null) ? 0 : presion.hashCode());
        result = prime * result + ((rpm == null) ? 0 : rpm.hashCode());
        result = prime * result + ((voltaje == null) ? 0 : voltaje.hashCode());
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
        if (estado == null) {
            if (other.estado != null)
                return false;
        } else if (!estado.equals(other.estado))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (presion == null) {
            if (other.presion != null)
                return false;
        } else if (!presion.equals(other.presion))
            return false;
        if (rpm == null) {
            if (other.rpm != null)
                return false;
        } else if (!rpm.equals(other.rpm))
            return false;
        if (voltaje == null) {
            if (other.voltaje != null)
                return false;
        } else if (!voltaje.equals(other.voltaje))
            return false;
        return true;
    }

    
}