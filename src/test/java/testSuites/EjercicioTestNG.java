package testSuites;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class EjercicioTestNG {

    @BeforeSuite
    public void metodo1(){
        System.out.println(("Inicio de Suite"));
    }

    @AfterSuite
    public void metodo2(){
        System.out.println(("Termino de Suite"));
    }

    @Test(priority = 1,description = "Prueba 1")
    public void metodo3(){
        System.out.println(("Test 1"));


    }

    @Test(priority = 2,description = "Prueba 2")
    public void metodo4(){
        System.out.println(("Test 2"));
        Assert.assertTrue(true);
        Assert.fail("FAIL");
    }

    @AfterMethod
    public void metodo5(){
        System.out.println(("Termino Test"));
    }
}
