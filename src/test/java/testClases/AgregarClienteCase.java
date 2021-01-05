package testClases;

import pages.CarruselPage;
import pages.CrearClientePage;
import pages.RegsitroPage;

public class AgregarClienteCase {
    CarruselPage carruselPage = new CarruselPage();
    RegsitroPage regsitroPage = new RegsitroPage();
    CrearClientePage crearClientePage = new CrearClientePage();

    String nombre = "Fran432";
    String ID = "1234";
    String fono = "12345";
    String dir = "Calle falsa 123";
    String notas = "Sin notas";


    public void flujo(){
        carruselPage.validarVistaDesplegada();
        carruselPage.recorrerCarrusel();
        carruselPage.tapBtnHecho();

        regsitroPage.validarVistaDesplegada();
        regsitroPage.tapBtnMas();
        regsitroPage.tapBtnCrearCliente();

        crearClientePage.validarVistaDesplegada();
        crearClientePage.completarFormulario(nombre, ID, fono, dir, notas);
        crearClientePage.tapGuardar();

        regsitroPage.validarVistaDesplegada();
        regsitroPage.validarCliente(nombre);
        regsitroPage.obtencionCliente(nombre);

    }
}
