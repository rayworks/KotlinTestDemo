package org.sergiiz.thermometer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Sergii Zhuk
 *         Date: 11.03.2016
 *         Time: 21:26
 */

public class ThermoConverterTest {

	private final static float ALLOWED_DELTA = 0.01f;

	@Test
	public void thermoTestLow() {
		final float celsiusValue = -1000f;
		ThermoModel thermoModel = ThermoConverter.getTemperature(celsiusValue);
		assertEquals(celsiusValue, thermoModel.getCelsius(), ALLOWED_DELTA);
		assertEquals(-1768f, thermoModel.getFahrenheit(), ALLOWED_DELTA);
		assertEquals(-726.85f, thermoModel.getKelvin(), ALLOWED_DELTA);
	}

	@Test
	public void thermoTestMid() {
		final float celsiusValue = 232.778f;
		ThermoModel thermoModel = ThermoConverter.getTemperature(celsiusValue);
		assertEquals(celsiusValue, thermoModel.getCelsius(), ALLOWED_DELTA);
		assertEquals(505.93f, thermoModel.getKelvin(), ALLOWED_DELTA);
		assertEquals(451f, thermoModel.getFahrenheit(), ALLOWED_DELTA);
	}

	@Test
	public void thermoTestXHigh() {
		final float celsiusValue = 10000009f;
		ThermoModel thermoModel = ThermoConverter.getTemperature(celsiusValue);
		assertEquals(celsiusValue, thermoModel.getCelsius(), ALLOWED_DELTA);
		assertEquals(10000282.15f, thermoModel.getKelvin(), ALLOWED_DELTA);
		assertEquals(18000048.2f, thermoModel.getFahrenheit(), ALLOWED_DELTA);
	}
}
