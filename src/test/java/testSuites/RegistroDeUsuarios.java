package testSuites;

import drivers.DriverContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testClases.AgregarClienteCase;
import testClases.AgregarProductoCase;
import testClases.EliminarClienteCase;

import static drivers.DriverContext.setUP;

public class RegistroDeUsuarios {

    @BeforeMethod
    public void iniciarSession(){

        setUP("emulator-5554","Android","/Users/franciscaacevedo/registroDeUsuarios.apk","",true);

    }
    @AfterMethod
    public void cerrarSession(){

        DriverContext.quitDriver();
    }

    @Test(priority = 1, description = "Agregar Cliente")
    public void agregarCliente(){
        AgregarClienteCase test = new AgregarClienteCase();
        test.flujo();

    }

    @Test(priority = 2, description = "Eliminar Cliente")
    public void eliminarCliente(){
        EliminarClienteCase test = new EliminarClienteCase();
        test.flujoEliminar();

    }

    @Test(priority = 3, description = "Crear Producto")
    public void crearProducto(){
        AgregarProductoCase test = new AgregarProductoCase();
        test.flujoCrearProducto();

    }

}
