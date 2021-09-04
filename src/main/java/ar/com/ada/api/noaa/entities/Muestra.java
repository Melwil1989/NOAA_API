package ar.com.ada.api.noaa.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "muestra")
public class Muestra {

    public Muestra() {

    }

    @Id
    @Column(name = "muestra_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer muestraId;

    @Transient
    private Integer boyaId;

    @Column(name = "horario_muestra")
    private Date horarioMuestra;

    @Column(name = "matricula_embarcacion")
    private String matriculaEmbarcacion;

    @Column
    private double longitud;

    @Column
    private double latitud;

    @Column(name = "altura_al_nivel_del_mar")
    private double alturaAlNivelDelMar;

    @ManyToOne
    @JoinColumn(name = "boya_id", referencedColumnName = "boya_id")
    private Boya boya;

    public Integer getMuestraId() {
        return muestraId;
    }

    public void setMuestraId(Integer muestraId) {
        this.muestraId = muestraId;
    }

    public Boya getBoya() {
        return boya;
    }

    public void setBoya(Boya boya) {
        this.boya = boya;
        this.boya.agregarMuestra(this);
    }

    public Date getHorarioMuestra() {
        return horarioMuestra;
    }

    public void setHorarioMuestra(Date horarioMuestra) {
        this.horarioMuestra = horarioMuestra;
    }

    public String getMatriculaEmbarcacion() {
        return matriculaEmbarcacion;
    }

    public void setMatriculaEmbarcacion(String matriculaEmbarcacion) {
        this.matriculaEmbarcacion = matriculaEmbarcacion;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getAlturaAlNivelDelMar() {
        return alturaAlNivelDelMar;
    }

    public void setAlturaAlNivelDelMar(double alturaAlNivelDelMar) {
        this.alturaAlNivelDelMar = alturaAlNivelDelMar;
    }

    public Integer getBoyaId() {
        return boyaId;
    }
    
}
