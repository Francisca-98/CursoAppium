package pages;

import drivers.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import static reports.Report.addStep;
import static utils.Utils.esperarObjeto;

public class CrearProductoPage {

    private AppiumDriver driver;

    public CrearProductoPage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /**
     * Objetos
     */

    @AndroidFindBy(xpath = "//*[contains(@text,\"Crear Producto\")]")
    private MobileElement tituloVistaCrearProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_producto")
    private MobileElement txtNombreProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/precio")
    private MobileElement txtPrecio;

    @AndroidFindBy(id = "com.rodrigo.registro:id/confirmar")
    private MobileElement btnConfirmar;


    public void validarVistaDesplegadaProducto(){
        if(esperarObjeto(tituloVistaCrearProducto,3)){
            addStep("Validar Vista Crear Producto desplegada", true, Status.PASSED,false);
        }
    }

    public void completarFormularioProducto(String nameProducto, String precio){
        System.out.println("[CrearProducto Page] completar Formulario");
        txtNombreProducto.setValue(nameProducto);
        this.driver.hideKeyboard();
        txtPrecio.click();
        txtPrecio.setValue(precio);
        this.driver.hideKeyboard();
        addStep("Completar Formilario de creacion producto", true, Status.PASSED,false);

    }


    public void tapGuardar(){
        if(esperarObjeto(btnConfirmar,2)){
            addStep("Validar Vista boton confirmar", true, Status.PASSED,false);
            btnConfirmar.click();
        }else{
            addStep("Error, Validar Vista  boton confirmar", true, Status.FAILED,true);

        }
    }
}
