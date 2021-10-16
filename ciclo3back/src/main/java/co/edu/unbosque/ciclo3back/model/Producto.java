package co.edu.unbosque.ciclo3back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Producto")
public class Producto {

	@Id
	private Long codigo_producto;
	@Column(nullable = false, length = 255)
	private String nombre_producto;
	@Column(nullable = false, length = 255)
	private Long nit_proveedor;
	@Column(nullable = false)
	private double precio_compra;
	@Column(nullable = false)
	private double iva_compra;
	@Column(nullable = false)
	private double precio_venta;

	public Long getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(Long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public double getIva_compra() {
		return iva_compra;
	}

	public void setIva_compra(double iva_compra) {
		this.iva_compra = iva_compra;
	}

	public Long getNit_proveedor() {
		return nit_proveedor;
	}

	public void setNit_proveedor(Long nit_proveedor) {
		this.nit_proveedor = nit_proveedor;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public double getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}

}
