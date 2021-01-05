package testSuites;

import drivers.DriverContext;
import io.appium.java_client.MobileElement;
import io.qameta.allure.model.Status;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testClases.Test_Carrusel;

import static drivers.DriverContext.setUP;
import static reports.Report.addStep;

public class EjemploDriver {

    @BeforeMethod
    public void iniciarSession(){

        setUP("emulator-5554","Android","/Users/franciscaacevedo/registroDeUsuarios.apk","",true);

    }

    @Test
    public void test1(){
        System.out.println("Prueba");
        MobileElement btnNext = (MobileElement) DriverContext.getDriver().findElementById("com.rodrigo.registro:id/next");
        btnNext.click();
        btnNext.click();
        addStep("Validar tercera vista Carrusel",true, Status.PASSED,false);
    }

    @AfterMethod
    public void cerrarSession(){

        DriverContext.quitDriver();
    }

    @Test(description = "Validacion Carrusel")
    public void Test_Carrusel(){
        Test_Carrusel test = new Test_Carrusel();
        test.validacion();
    }

}
