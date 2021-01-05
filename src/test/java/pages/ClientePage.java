package pages;

import drivers.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

import static reports.Report.addStep;
import static utils.Utils.esperarObjeto;

public class ClientePage {

    private AppiumDriver driver;

    public ClientePage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /**
     * Objetos
     */

    @AndroidFindBy(id = "com.rodrigo.registro:id/title")
    private MobileElement tituloNombreCliente;

    @AndroidFindBy(id = "com.rodrigo.registro:id/vc_anadirVenta")
    private MobileElement btnAgregarVenta;

    @AndroidFindBy(xpath = "//*[contains(@text,\"Eliminar cliente\")]")
    private MobileElement btnEliminarCliente;

    /**
     * POPUP ElIMINAR
     */

    @AndroidFindBy (id = "com.rodrigo.registro:id/textView1")
    private MobileElement tituloEliminar;

    @AndroidFindBy (id = "com.rodrigo.registro:id/editTextDialogUserInput")
    private MobileElement txtEliminar;

    @AndroidFindBy (id = "android:id/button1")
    private MobileElement btnOk;


    public void validarDetalleCliente(){
        if(esperarObjeto(tituloNombreCliente,2)){
            addStep("Validar Vista Detalle Cliente", true, Status.PASSED,false);
        }else{
            addStep("Error, Validar Vista Detalle cliente", true, Status.FAILED,true);

        }

    }


    public void tapEliminar() {

        Utils.swipeAbajo();
        Utils.swipeAbajo();
        btnEliminarCliente.click();
    }

    public void validarPopUpEliminar(){
        if(esperarObjeto(tituloEliminar,2)){
            addStep("Validar Vista Eliminar Cliente", true, Status.PASSED,false);
        }else{
            addStep("Error, Validar Vista Eliminar cliente", true, Status.FAILED,true);

        }

    }

    public void completarFormularioBorrar(String borrar) {
        System.out.println("[CrearCliente Page] completar Formulario");
        txtEliminar.setValue(borrar);
        this.driver.hideKeyboard();

    }

    public void tapOk() {
        btnOk.click();
    }
}
