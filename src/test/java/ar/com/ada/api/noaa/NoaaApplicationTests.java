package ar.com.ada.api.noaa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.ada.api.noaa.entities.Muestra;
import ar.com.ada.api.noaa.services.MuestraService;
import ar.com.ada.api.noaa.utils.UbicacionesUtils;

@SpringBootTest
class NoaaApplicationTests {

	@Autowired
	MuestraService muestraService;
	// - Validar que las coordenadas esten dentro del rango del planeta
	// - Validar que las coordenadas NO esten dentro del rango del planeta
	// - Validar que las coordenadas esten en el hemisferio norte.

	@Test
	void testLatitudOk() {
		double latitudNoOk = -93;
		double latitudRegia = 15;

		assertTrue(UbicacionesUtils.validarLatitud(latitudRegia));
		assertFalse(UbicacionesUtils.validarLatitud(latitudNoOk));

		// Latitud: -90 + 90
		// Longitud: -180 +180
	}

	@Test
	void testLongitudOk() {
		double longitudNoOk = -186;
		double longitudRegia = 95;

		assertTrue(UbicacionesUtils.validarLongitud(longitudRegia));
		assertFalse(UbicacionesUtils.validarLongitud(longitudNoOk));
	}

	@Test
	void testCoordenadasOk() {
		double longitudOk = 54;
		double longitudNoOk = -200;
		double latitudOk = 64;
		double latitudNoOk = -97;

		// Deberíamos hacer 16 pruebitas :/
		assertTrue(UbicacionesUtils.validarCoordenadas(longitudOk, latitudOk));
		assertFalse(UbicacionesUtils.validarCoordenadas(longitudNoOk, latitudNoOk));
	}

	@Test
	void testCoordenadasFueraDelPlaneta() {
		double longitudOk = 54;
		double longitudNoOk = -200;
		double latitudOk = 64;
		double latitudNoOk = -97;

		// Deberíamos hacer 16 pruebitas :/
		assertFalse(UbicacionesUtils.validarCoordenadasFueraDelPlaneta(longitudOk, latitudOk));
		assertTrue(UbicacionesUtils.validarCoordenadasFueraDelPlaneta(longitudNoOk, latitudNoOk));
	}

	@Test
	void testSiEsHemisferioNorte() {
		double latitudOk = 64;
		double latitudNoOk = -97 ;
		double longitudOk = 10;

		Muestra m = new Muestra();
		m.setLatitud(latitudOk);
		m.setLongitud(-5555);

		assertFalse(UbicacionesUtils.validarSiEsHemisferioNorte(latitudNoOk, longitudOk));
		assertTrue(UbicacionesUtils.validarSiEsHemisferioNorte(latitudOk, longitudOk));
		assertFalse(UbicacionesUtils.validarSiEsHemisferioNorte(Math.abs(latitudNoOk), longitudOk));
		
		assertFalse(UbicacionesUtils.validarSiEsHemisferioNorte(m.getLatitud(), m.getLongitud()));
		
	}

}
