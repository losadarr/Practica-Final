package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("TURBINAS")
public class Turbina {

    private @Column("ID") @Id Long id;
    private @Column("ANGULO") Long angulo;
    private @Column("ALTURA") Long altura;
    private @Column("VELOCIDAD_MAX") Long velocidad_max;
    private @Column("ENCENDIDO") Boolean on;
    private @Column("CARGA") Long carga;

    public Turbina(Long id, Long angulo, Long altura, Long velocidad_max, Boolean on) {
        this.id = id;
        this.angulo = angulo;
        this.altura = altura;
        this.velocidad_max = velocidad_max;
        this.on = on;
        this.carga = 50L;
    }

    public Turbina() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAngulo() {
        return angulo;
    }

    public void setAngulo(Long angulo) {
        this.angulo = angulo;
    }

    public Long getAltura() {
        return altura;
    }

    public void setAltura(Long altura) {
        this.altura = altura;
    }

    public Long getVelocidad_max() {
        return velocidad_max;
    }

    public void setVelocidad_max(Long velocidad_max) {
        this.velocidad_max = velocidad_max;
    }

    public Boolean getOn() {
        return on;
    }

    public void setOn(Boolean on) {
        this.on = on;
    }

    public Long getCarga() {
        return carga;
    }

    public void setCarga(Long carga) {
        this.carga = carga;
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
        Turbina other = (Turbina) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
