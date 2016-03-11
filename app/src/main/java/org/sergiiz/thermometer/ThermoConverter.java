package org.sergiiz.thermometer;

/**
 * @author Sergii Zhuk
 *         Date: 10.03.2016
 *         Time: 23:43
 */

public final class ThermoConverter {

	private ThermoConverter(){
		// hidden
	}

	public static ThermoModel getTemperature(float celsius){
		float fahr =  celsius * 9/5 +32f;
		float kel =  celsius + 273.15f;
		return new ThermoModel(celsius, kel, fahr);
	}

}
