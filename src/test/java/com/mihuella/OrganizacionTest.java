package com.mihuella;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class OrganizacionTest {

	private static Organizacion organizacion;
	private static List<Sector> sectores;
	private static Miembro miembro;

	@BeforeClass
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

		assertThat(organizacion.getPostulaciones().contains(miembro) && !organizacion.getMiembros().contains(miembro));
	}

	@Test
	public void aceptarVinculacion() {
		organizacion.aceptarVinculacion(miembro);
		assertThat(organizacion.getMiembros().contains(miembro) && !organizacion.getPostulaciones().contains(miembro));

	}

}
