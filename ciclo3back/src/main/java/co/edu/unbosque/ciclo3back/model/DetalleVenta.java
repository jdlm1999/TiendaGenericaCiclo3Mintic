package co.edu.unbosque.ciclo3back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Detalle_Venta")
public class DetalleVenta {

	@Id
	private Long codigo_detalle_venta;
	@Column(nullable = false, length = 11)
	private int cantidad_producto;
	@Column(nullable = false, length = 20)
	private Long codigo_producto;
	@Column(nullable = false, length = 20)
	private Long codigo_venta;
	@Column(nullable = false)
	private double valor_total;
	@Column(nullable = false)
	private double valor_venta;
	@Column(nullable = false)
	private double valor_iva;

	public Long getCodigo_detalle_venta() {
		return codigo_detalle_venta;
	}

	public void setCodigo_detalle_venta(Long codigo_detalle_venta) {
		this.codigo_detalle_venta = codigo_detalle_venta;
	}

	public int getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public Long getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(Long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public Long getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(Long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}

	public double getValor_iva() {
		return valor_iva;
	}

	public void setValor_iva(double valor_iva) {
		this.valor_iva = valor_iva;
	}
}
