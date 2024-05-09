package com.mihuella;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.mihuella.miembro.LugarDeTrabajo;
import com.mihuella.miembro.Miembro;
import com.mihuella.utils.TipoDoc;
import com.mihuella.organizacion.Clasificacion;
import com.mihuella.organizacion.Organizacion;
import com.mihuella.organizacion.Sector;
import com.mihuella.organizacion.TipoDeOrganizacion;
import com.mihuella.transporte.Trayecto;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class OrganizacionTest {

	private static Organizacion organizacion;
	private static List<Sector> sectores;
	private static Miembro miembroA;
	private static Miembro miembroB;

	@BeforeAll
	public static void setUp() {
		organizacion = new Organizacion("Mercado Libre SRL", "30-70308853-4", new TipoDeOrganizacion("Empresa"),
				new Clasificacion("Sector Primario"), "Avenida San Juan 3002, CABA");
		sectores = new ArrayList<>();
		sectores.add(new Sector("RRHH", organizacion));
		sectores.add(new Sector("Marketing",organizacion));
		organizacion.agregarSectores(sectores);


		List<LugarDeTrabajo> lugaresDeTrabajoA = new ArrayList<>();
		lugaresDeTrabajoA.add(new LugarDeTrabajo(organizacion, organizacion.getSectores().get(1)));
		miembroA = new Miembro("Pedro", "Sanchez", TipoDoc.DNI, "40747720", lugaresDeTrabajoA);

		List<LugarDeTrabajo> lugarDeTrabajoB = new ArrayList<>();
		lugarDeTrabajoB.add(new LugarDeTrabajo(organizacion, organizacion.getSectores().get(0)));
		miembroB = new Miembro("Juan", "Lopez", TipoDoc.DNI, "40747721", lugarDeTrabajoB);

	}

	@Test
	public void postulacionMiembro() {
		assertTrue(organizacion.getPostulaciones().contains(miembroA) && !organizacion.getMiembros().contains(
				miembroA));
	}

	@Test
	public void aceptarVinculacion() {
		assertFalse(organizacion.getMiembros().contains(miembroA));
		organizacion.aceptarVinculacion(miembroA);
		assertTrue(organizacion.getMiembros().contains(miembroA) && !organizacion.getPostulaciones().contains(
				miembroA));
	}

	@Test
	public void calcularHuellaTransporte(){
		Trayecto trayectoA = mock(Trayecto.class);
		Trayecto trayectoB = mock(Trayecto.class);
		when(trayectoA.calcularHuella()).thenReturn(20.5);
		when(trayectoB.calcularHuella()).thenReturn(29.5);
		miembroB.getLugaresDeTrabajo().get(0).agregarTrayecto(trayectoB);
		miembroA.getLugaresDeTrabajo().get(0).agregarTrayecto(trayectoA);
		organizacion.aceptarVinculacion(miembroB);

		assertEquals(50.0,organizacion.calcularHuellaTransporte(),0.1);
	}

}
