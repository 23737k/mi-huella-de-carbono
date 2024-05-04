package com.mihuella;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class OrganizacionTest {

	private static Organizacion organizacion;
	private static List<Sector> sectores;
	private static Miembro miembro;

	@BeforeAll
	public static void setUp() {
		sectores = new ArrayList<>();
		sectores.add(new Sector("RRHH"));
		sectores.add(new Sector("Marketing"));
		organizacion = new Organizacion("Mercado Libre SRL", "30-70308853-4", new TipoDeOrganizacion("Empresa"),
				new Clasificacion("Sector Primario"), null, sectores, new ArrayList<Miembro>(),
				new ArrayList<Medicion>());
	}

	@Test
	public void postulacionMiembro() {
		List<LugarDeTrabajo> lugaresDeTrabajo = new ArrayList<LugarDeTrabajo>();
		lugaresDeTrabajo.add(new LugarDeTrabajo(organizacion, organizacion.getSectores().get(1)));
		miembro = new Miembro("Pedro", "Sanchez", TipoDoc.DNI, "40747720", lugaresDeTrabajo);

		assertTrue(organizacion.getPostulaciones().contains(miembro) && !organizacion.getMiembros().contains(miembro));
	}

	@Test
	public void aceptarVinculacion() {
		organizacion.aceptarVinculacion(miembro);
		assertTrue(organizacion.getMiembros().contains(miembro) && !organizacion.getPostulaciones().contains(miembro));

	}

}
