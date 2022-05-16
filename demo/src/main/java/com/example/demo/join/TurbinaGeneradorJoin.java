package com.example.demo.join;

public class TurbinaGeneradorJoin {
    private Long turbinaId;
    private Long generadorId;
    private Boolean turbinaEncendido;
    private Long turbinaCarga;
    private Long generadorVoltaje;
    private String generadorEstado;
    
    public TurbinaGeneradorJoin() {
    }

    public TurbinaGeneradorJoin(Long turbinaId, Long generadorId, Boolean turbinaEncendido, Long turbinaCarga,
            Long generadorVoltaje, String generadorEstado) {
        this.turbinaId = turbinaId;
        this.generadorId = generadorId;
        this.turbinaEncendido = turbinaEncendido;
        this.turbinaCarga = turbinaCarga;
        this.generadorVoltaje = generadorVoltaje;
        this.generadorEstado = generadorEstado;
    }

    public Long getTurbinaId() {
        return turbinaId;
    }

    public void setTurbinaId(Long turbinaId) {
        this.turbinaId = turbinaId;
    }

    public Long getGeneradorId() {
        return generadorId;
    }

    public void setGeneradorId(Long generadorId) {
        this.generadorId = generadorId;
    }

    public Boolean getTurbinaEncendido() {
        return turbinaEncendido;
    }

    public void setTurbinaEncendido(Boolean turbinaEncendido) {
        this.turbinaEncendido = turbinaEncendido;
    }

    public Long getTurbinaCarga() {
        return turbinaCarga;
    }

    public void setTurbinaCarga(Long turbinaCarga) {
        this.turbinaCarga = turbinaCarga;
    }

    public Long getGeneradorVoltaje() {
        return generadorVoltaje;
    }

    public void setGeneradorVoltaje(Long generadorVoltaje) {
        this.generadorVoltaje = generadorVoltaje;
    }

    public String getGeneradorEstado() {
        return generadorEstado;
    }

    public void setGeneradorEstado(String generadorEstado) {
        this.generadorEstado = generadorEstado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((generadorId == null) ? 0 : generadorId.hashCode());
        result = prime * result + ((turbinaId == null) ? 0 : turbinaId.hashCode());
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
        TurbinaGeneradorJoin other = (TurbinaGeneradorJoin) obj;
        if (generadorId == null) {
            if (other.generadorId != null)
                return false;
        } else if (!generadorId.equals(other.generadorId))
            return false;
        if (turbinaId == null) {
            if (other.turbinaId != null)
                return false;
        } else if (!turbinaId.equals(other.turbinaId))
            return false;
        return true;
    }

    
}
