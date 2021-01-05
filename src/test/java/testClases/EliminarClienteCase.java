package testClases;

import pages.CarruselPage;
import pages.ClientePage;
import pages.RegsitroPage;

public class EliminarClienteCase {
    CarruselPage carruselPage = new CarruselPage();
    RegsitroPage regsitroPage = new RegsitroPage();
    ClientePage clientePage = new ClientePage();


    String nombre = "Fran432";
    String borrar = "BORRAR";

    public void flujoEliminar(){
        carruselPage.validarVistaDesplegada();
        carruselPage.recorrerCarrusel();
        carruselPage.tapBtnHecho();

        regsitroPage.validarVistaDesplegada();
        regsitroPage.validarCliente(nombre);
        regsitroPage.obtencionCliente(nombre);

        clientePage.validarDetalleCliente();
        clientePage.tapEliminar();
        clientePage.validarPopUpEliminar();
        clientePage.completarFormularioBorrar(borrar);
        clientePage.tapOk();

        regsitroPage.validarVistaDesplegada();
        regsitroPage.validarClienteEliminado(nombre);









    }
}
