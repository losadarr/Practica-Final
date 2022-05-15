package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("CONTACTO")
public class Contacto {
    private @Column("ID") @Id Long id;
    private @Column("NOMBRE") String nombre;
    private @Column("APELLIDOS") String apellidos;
    private @Column("CORREO") String correo;
    private @Column("DIRECCION") String direccion;
    private @Column("PAIS") String pais;
    private @Column("ESTADO") String estado;
    private @Column("ZIP") Long zipLong;
    private @Column("TARIFA") String tarifa;
    private @Column("DESEA_PROMO") Boolean deseaPromo;
    private @Column("DESEA_COM") Boolean deseaCom;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Long getZipLong() {
        return zipLong;
    }
    public void setZipLong(Long zipLong) {
        this.zipLong = zipLong;
    }
    public String getTarifa() {
        return tarifa;
    }
    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }
    public Boolean getDeseaPromo() {
        return deseaPromo;
    }
    public void setDeseaPromo(Boolean deseaPromo) {
        this.deseaPromo = deseaPromo;
    }
    public Boolean getDeseaCom() {
        return deseaCom;
    }
    public void setDeseaCom(Boolean deseaCom) {
        this.deseaCom = deseaCom;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
        result = prime * result + ((correo == null) ? 0 : correo.hashCode());
        result = prime * result + ((deseaCom == null) ? 0 : deseaCom.hashCode());
        result = prime * result + ((deseaPromo == null) ? 0 : deseaPromo.hashCode());
        result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
        result = prime * result + ((estado == null) ? 0 : estado.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((pais == null) ? 0 : pais.hashCode());
        result = prime * result + ((tarifa == null) ? 0 : tarifa.hashCode());
        result = prime * result + ((zipLong == null) ? 0 : zipLong.hashCode());
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
        Contacto other = (Contacto) obj;
        if (apellidos == null) {
            if (other.apellidos != null)
                return false;
        } else if (!apellidos.equals(other.apellidos))
            return false;
        if (correo == null) {
            if (other.correo != null)
                return false;
        } else if (!correo.equals(other.correo))
            return false;
        if (deseaCom == null) {
            if (other.deseaCom != null)
                return false;
        } else if (!deseaCom.equals(other.deseaCom))
            return false;
        if (deseaPromo == null) {
            if (other.deseaPromo != null)
                return false;
        } else if (!deseaPromo.equals(other.deseaPromo))
            return false;
        if (direccion == null) {
            if (other.direccion != null)
                return false;
        } else if (!direccion.equals(other.direccion))
            return false;
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
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (pais == null) {
            if (other.pais != null)
                return false;
        } else if (!pais.equals(other.pais))
            return false;
        if (tarifa == null) {
            if (other.tarifa != null)
                return false;
        } else if (!tarifa.equals(other.tarifa))
            return false;
        if (zipLong == null) {
            if (other.zipLong != null)
                return false;
        } else if (!zipLong.equals(other.zipLong))
            return false;
        return true;
    }

    
}
