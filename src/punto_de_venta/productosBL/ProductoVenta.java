/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto_de_venta.productosBL;

/**
 *
 * @author Daniel
 */
public class ProductoVenta {
    String Codigo,Nombre;
    double precio;
    int cantidad,stock,numFilaEnTabla;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getNumFilaEnTabla() {
        return numFilaEnTabla;
    }

    public void setNumFilaEnTabla(int numFilaEnTabla) {
        this.numFilaEnTabla = numFilaEnTabla;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
