package Models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "opcional")
public class Opcional {
	

	@Id
	@Column(name="IdOpcional")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdOpcional;
	
	@Column(name="Tipo")
	private String Descripcion;
	
	@Column(name="Precio")
	private double Precio;
	
		
	@OneToMany(mappedBy = "Opcionales", fetch = FetchType.LAZY)
	private List<VentaDetalle> VentaOpcional;
	
	public Opcional() {
		
	}
	
	public Opcional(String descripcion, double precio) {
		Descripcion = descripcion;
		Precio = precio;
	}	

	public Integer getIdOpcional() {
		return IdOpcional;
	}

	public void setIdOpcional(Integer idOpcional) {
		IdOpcional = idOpcional;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		Precio = precio;
	}

	public List<VentaDetalle> getVentaOpcional() {
		return VentaOpcional;
	}

	public void setVentaOpcional(List<VentaDetalle> ventaOpcional) {
		VentaOpcional = ventaOpcional;
	}



}
