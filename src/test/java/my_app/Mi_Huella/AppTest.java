package my_app.Mi_Huella;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import org.w3c.dom.ls.LSException;

import com.mihuella.CalculoHUFacade;
import com.mihuella.Medicion;
import com.mihuella.Parametro;
import com.mihuella.Periodicidad;

/**
 * Unit test for simple App.
 */
public class AppTest {

  private List<Parametro> parametros;
  private List<Medicion> mediciones = new ArrayList<>();
  private Medicion medicionA;
  private Medicion medicionB;
//  @Test
//  public void nuevoTest() {
//    List<Sector> sectores = new ArrayList<Sector>();
//    sectores.add(new Sector("RRHH"));
//    sectores.add(new Sector("Marketing"));
//    List<Miembro> miembros = new ArrayList<>();
//    Organizacion organizacion =
//        new Organizacion("MercadoLibreSRL", "201661231", new TipoDeOrganizacion("Empresa"),
//            new Clasificacion("Empresa de Sector Primario"),
//            new UbicacionGeografica("40.7128", "74.0060"), sectores, miembros);
//
//
//  }
  /*
  @Before
  public void setUp(){
    parametros = new ArrayList<>();
    parametros.add(new Parametro("nafta", 1.75));
    parametros.add(new Parametro("electricidad", 2.5));
    medicionA = new Medicion("Combustion Fija","nafta",1500.0,Periodicidad.MENSUAL, "02/2023");
    medicionB = new Medicion("Combustion Fija","electricidad",700.0,Periodicidad.MENSUAL, "02/2023");
    mediciones.add(medicionA);
    mediciones.add(medicionB);
  }

  @Test
  public void calculoHuellaMedicion(){
    assertEquals( CalculoHUFacade.calcularHuellaXMedicion(medicionA,parametros), (double) 2625,0.1);
  }

  @Test
  public void calculoTotalHuella() {
    assertEquals( CalculoHUFacade.calcularHuellaTotal(mediciones,parametros),4375 ,0.1);
  }
*/
}
