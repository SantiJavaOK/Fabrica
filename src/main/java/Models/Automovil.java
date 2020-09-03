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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "automovil")
public class Automovil {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdAutomovil;
	
	@Column
	private String Modelo;
	
	@Column
	private double Precio;
	
	@OneToMany(mappedBy = "Automovil", cascade = CascadeType.ALL)
	private List<Venta> idVenta;
	
	public Automovil() {
		
	}

	public Automovil(String modelo, double precio) {
		Modelo = modelo;
		Precio = precio;
	}	
	
	public Integer getIdAutomovil() {
		return IdAutomovil;
	}

	public void setIdAutomovil(Integer idAutomovil) {
		IdAutomovil = idAutomovil;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		Precio = precio;
	}
	
	

}
