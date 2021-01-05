package testClases;

import pages.CarruselPage;
import pages.CrearProductoPage;
import pages.RegsitroPage;

public class AgregarProductoCase {
    CarruselPage carruselPage = new CarruselPage();
    RegsitroPage regsitroPage = new RegsitroPage();
    CrearProductoPage crearProductoPage = new CrearProductoPage();

    String nombreProducto = "Escritorio12";
    String precio = "100000";


    public void flujoCrearProducto(){
        carruselPage.validarVistaDesplegada();
        carruselPage.recorrerCarrusel();
        carruselPage.tapBtnHecho();

        regsitroPage.validarVistaDesplegada();
        regsitroPage.tapBtnMas();
        regsitroPage.tapBtnCrearProducto();

        crearProductoPage.validarVistaDesplegadaProducto();
        crearProductoPage.completarFormularioProducto(nombreProducto,precio);
        crearProductoPage.tapGuardar();

        regsitroPage.tapBtnProducto();
        regsitroPage.validarProducto(nombreProducto,precio);









    }
}
