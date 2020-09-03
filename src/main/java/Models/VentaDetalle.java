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
@Table(name= "ventaDetalle")
public class VentaDetalle {


	@Id
	@Column(name="IdVentaDetalle")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdVentaDetalle;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdVenta")
	private Venta Venta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdOpcional")
	private Opcional Opcionales;
	
	@Column
	private double Precio;

	public VentaDetalle() {
		
	}
	
	
	public VentaDetalle(Integer idVentaDetalle, Models.Venta venta, Opcional opcionales, double precio) {
		IdVentaDetalle = idVentaDetalle;
		Venta = venta;
		Opcionales = opcionales;
		Precio = precio;
	}


	public Integer getIdVentaDetalle() {
		return IdVentaDetalle;
	}

	public void setIdVentaDetalle(Integer idVentaDetalle) {
		this.IdVentaDetalle = idVentaDetalle;
	}

	public Venta getVenta() {
		return Venta;
	}

	public void setVenta(Venta venta) {
		this.Venta = venta;
	}


	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		this.Precio = precio;
	}


	public Opcional getOpcionales() {
		return Opcionales;
	}


	public void setOpcionales(Opcional opcionales) {
		this.Opcionales = opcionales;
	}



}
