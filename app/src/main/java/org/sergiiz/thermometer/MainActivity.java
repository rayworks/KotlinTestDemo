package org.sergiiz.thermometer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

	EditText editCelsius;
	EditText editKelvin;
	EditText editFahrenheit;
	SeekBar seekBar;

	float currentCelsius = 0;

	private static final int TEMPERATURE_MAX_VALUE_CELSIUS = 250; // min value will be 0 in this case
	public static final String FORMAT_TEMPERATURE = "%.2f";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editCelsius = (EditText) findViewById(R.id.input_celsius);


		editKelvin = (EditText) findViewById(R.id.input_kelvin);
		editFahrenheit = (EditText) findViewById(R.id.input_fahrenheit);

		seekBar = (SeekBar) findViewById(R.id.seekbar);
		seekBar.setMax(TEMPERATURE_MAX_VALUE_CELSIUS);
		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				currentCelsius = progress;
				ThermoModel thermo = ThermoConverter.getTemperature(currentCelsius);
				editCelsius.setText(String.format(FORMAT_TEMPERATURE, thermo.getCelsius()));
				editFahrenheit.setText(String.format(FORMAT_TEMPERATURE, thermo.getFahrenheit()));
				editKelvin.setText(String.format(FORMAT_TEMPERATURE, thermo.getKelvin()));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				//empty
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				//empty
			}
		});

		seekBar.setProgress(TEMPERATURE_MAX_VALUE_CELSIUS / 2);
	}
}
