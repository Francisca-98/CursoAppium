package pages;

import drivers.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static reports.Report.addStep;
import static utils.Utils.esperarObjeto;

public class RegsitroPage {

    private AppiumDriver driver;

    public RegsitroPage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /**
     * Objetos
     */
    @AndroidFindBy (xpath = "//*[contains(@text,\"Registro\")]")
    private MobileElement tituloVistaRegistro;

    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup")
    private MobileElement tituloVistaProducto;

    @AndroidFindBy (id = "com.rodrigo.registro:id/fab_expand_menu_button")
    private MobileElement btnMas;

    @AndroidFindBy (id = "com.rodrigo.registro:id/action_cliente")
    private MobileElement btnCrearCliente;

    @AndroidFindBy (id = "com.rodrigo.registro:id/nombre_cliente")
    private List<MobileElement> labelsClientes;

    @AndroidFindBy (id = "com.rodrigo.registro:id/action_producto")
    private MobileElement btnCrearProducto;

    @AndroidFindBy (id = "com.rodrigo.registro:id/nombre_producto")
    private List<MobileElement> labelsProductos;

    @AndroidFindBy (id = "com.rodrigo.registro:id/precio_producto")
    private List<MobileElement> labelsPrecio;



    public void validarVistaDesplegada(){
       if(esperarObjeto(tituloVistaRegistro,2)){
           addStep("Validar Vista Registro Desplegada", true, Status.PASSED,false);
       }else{
           addStep("Error, Validar Vista Registro Desplegada", true, Status.FAILED,true);

       }
    }

    public void tapBtnMas(){
        if (esperarObjeto(btnMas,2)){
            addStep("Tap boton '+'",false,Status.PASSED,false);
            btnMas.click();
        }else{
            addStep("Error, Tap boton '+'",true,Status.FAILED,true);

        }

    }

    public void tapBtnCrearCliente(){
        if(esperarObjeto(btnCrearCliente,2)){
            addStep("Tap al boton 'Crear Cliente'",false,Status.PASSED,false);
            btnCrearCliente.click();
        }else{
            addStep("Error, Tap boton 'Crear Cliente' No encontrado",true,Status.FAILED,true);

        }
    }

    public void tapBtnCrearProducto(){
        if(esperarObjeto(btnCrearProducto,2)){
            addStep("Tap al boton 'Crear Producto'",false,Status.PASSED,false);
            btnCrearProducto.click();
        }else{
            addStep("Error, Tap boton 'Crear Producto' No encontrado",true,Status.FAILED,true);

        }
    }

    public void validarCliente(String nombreCliente){
        System.out.println("[RegistroCliente] validar Cliente");

        boolean clienteEncontrado = false;
       for(int i = 0; i<=labelsClientes.size(); i++){
           String nombreClienteActual = labelsClientes.get(i).getText();
           if (nombreClienteActual.equals(nombreCliente)){
               clienteEncontrado = true;
               break;
           }
       }
       if (clienteEncontrado){
           addStep("Cliente: "+nombreCliente+" registrado exitosamente",true,Status.PASSED,false);

       }else{
           addStep("Cliente: "+nombreCliente+" No encontrado",true,Status.FAILED,true);

       }
    }

    public void obtencionCliente(String nombreCliente){
        System.out.println("ObtenerCliente] validar Cliente");

        boolean clienteEncontrado = false;

        for(int i = 0; i<=labelsClientes.size(); i++){
            String nombreClienteActual = labelsClientes.get(i).getText();
            if (nombreClienteActual.equals(nombreCliente)){
                MobileElement cliente = (MobileElement) DriverContext.getDriver().findElement (By.xpath("//*[contains(@text,\""+nombreCliente+"\")]"));
                cliente.click();
                clienteEncontrado = true;
                break;
            }
        }
        if (clienteEncontrado){
            addStep("Cliente: "+nombreCliente+" existe en listado",true,Status.PASSED,false);

        }else{
            addStep("Cliente: "+nombreCliente+" No encontrado",true,Status.FAILED,true);

        }
    }

    public void validarClienteEliminado(String nombreCliente){
        System.out.println("[EliminarCliente] validar Cliente");

        boolean clienteEncontrado = false;

        for(int i = 0; i<labelsClientes.size(); i++){
            String nombreClienteActual = labelsClientes.get(i).getText();
            if (nombreClienteActual.equals(nombreCliente)){
                clienteEncontrado = true;
                break;
            }
        }

        if (clienteEncontrado){
            addStep("Cliente: "+nombreCliente+" no se elimina exitosamente",true,Status.FAILED,true);

        }else{
            addStep("Cliente: "+nombreCliente+" se elimina exitosamente",true,Status.PASSED,false);

        }
    }

    public void tapBtnProducto(){
        if(esperarObjeto(tituloVistaProducto,2)){
            addStep("Tap al boton 'Pestaña Producto'",false,Status.PASSED,false);
            tituloVistaProducto.click();
        }else{
            addStep("Error, Tap boton 'Pestaña Producto' No encontrado",true,Status.FAILED,true);

        }
    }

    public void validarProducto(String nombreProducto, String precio){
        System.out.println("[RegistroProducto] validar Producto");

        boolean productoEncontrado = false;
        for(int i = 0; i<=labelsProductos.size(); i++){
            String nombreProductoActual = labelsProductos.get(i).getText();
            String precioActual = labelsPrecio.get(i).getText();
            if (nombreProductoActual.equals(nombreProducto)&& (precioActual.equals(precio+".00"))){
                productoEncontrado = true;
                break;
            }
        }
        if (productoEncontrado){
            addStep("Producto: "+nombreProducto+" registrado exitosamente",true,Status.PASSED,false);

        }else{
            addStep("Producto: "+nombreProducto+" No encontrado",true,Status.FAILED,true);

        }
    }


}
