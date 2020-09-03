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

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name= "venta")
public class Venta {
	

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdVenta;
	
	@OneToMany(mappedBy = "Venta", fetch = FetchType.LAZY)
	private List<VentaDetalle> ventaDetalle;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdAutomovil")
	private Automovil Automovil;
	
	@Column
	private Integer Cantidad;
	
	@Column
	private double Total;
	
	
	public Venta() {
		
	}
	
	public Venta(Integer idVenta, Automovil modelo, Integer cantidad, double total,
			List<VentaDetalle> ventaDetalle) {

		IdVenta = idVenta;
		Automovil = modelo;
		Cantidad = cantidad;
		Total = total;
		this.ventaDetalle = ventaDetalle;
	}

	public Integer getIdVenta() {
		return IdVenta;
	}

	public void setIdVenta(Integer idVenta) {
		IdVenta = idVenta;
	}


	public Integer getCantidad() {
		return Cantidad;
	}

	public void setCantidad(Integer cantidad) {
		Cantidad = cantidad;
	}

	public double getTotal() {
		return Total;
	}

	public void setTotal(double total) {
		Total = total;
	}


	public List<VentaDetalle> getVentaDetalle() {
		return ventaDetalle;
	}


	public void setVentaDetalle(List<VentaDetalle> ventaDetalle) {
		this.ventaDetalle = ventaDetalle;
	}



	public Automovil getModelo() {
		return Automovil;
	}



	public void setModelo(Automovil modelo) {
		Automovil = modelo;
	}
	
	

}
