package cat.itacademy.barcelonactiva.gasull.carlos.s05.t01.n01.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "sucursal")
public class Sucursal {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Getter @Setter
    @Column (name = "nombre")
    private String nombreSucursal;

    @Getter @Setter
    @Column (name = "pais")
    private String paisSucursal;

    @Getter @Setter
    @Column (name = "tipoSucursal")
    private String tipoSucursal;

    public Sucursal(String alfajores_antonio, String argentina){

    }
    public Sucursal(String nombre, String pais,String tipoSucursal ){
        this.nombreSucursal = nombre;
        this.paisSucursal = pais;
        this.tipoSucursal = tipoSucursal;
    }

}
