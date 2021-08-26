package ar.com.ada.api.noaa.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "boya")
public class Boya {

    @Id
    @Column(name = "boya_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boyaId;

    @Column(name = "colores_luz_id")
    private Integer colorLuz;

    @Column(name = "longitud_instalacion")
    private double longitudInstalacion;

    @Column(name = "latitud_instalacion")
    private double latitudInstalacion;

    @OneToMany(mappedBy = "boya", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Muestra> muestras = new ArrayList<>();

    public Integer getBoyaId() {
        return boyaId;
    }

    public void setBoyaId(Integer boyaId) {
        this.boyaId = boyaId;
    }

    public ColorEnum getColorLuz() {
        return ColorEnum.parse(colorLuz);
    }

    public void setColorLuz(ColorEnum colorLuz) {
        this.colorLuz = colorLuz.getValue();
    }

    public double getLongitudInstalacion() {
        return longitudInstalacion;
    }

    public void setLongitudInstalacion(double longitudInstalacion) {
        this.longitudInstalacion = longitudInstalacion;
    }

    public double getLatitudInstalacion() {
        return latitudInstalacion;
    }

    public void setLatitudInstalacion(double latitudInstalacion) {
        this.latitudInstalacion = latitudInstalacion;
    }

    public List<Muestra> getMuestras() {
        return muestras;
    }

    public void setMuestras(List<Muestra> muestras) {
        this.muestras = muestras;
    }

    public void agregarMuestra(Muestra muestra) {
        this.muestras.add(muestra);
    }



    public enum ColorEnum {
        ROJO(1), AMARILLO(2), VERDE(3), AZUL(4);

        private final Integer value;

        private ColorEnum(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public static ColorEnum parse(Integer id) {
            ColorEnum status = null; // Default
            for (ColorEnum item : ColorEnum.values()) {
                if (item.getValue().equals(id)) {
                    status = item;
                    break;
                }
            }
            return status;
        }
    }
    
}
