package mx.edu.ittepic.ladm_u4_practica2_campos_aguirre

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var x = 0f
    var contShake = 0
    var distancia = 0f
    var sensorManager : SensorManager?= null
    var proximidad : Proximidad ?= null
    var acelerometro : Acelerometro ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Lienzo(this))
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        proximidad = Proximidad(this)
        acelerometro = Acelerometro(this)

        sensorManager?.registerListener(proximidad,sensorManager?.getDefaultSensor(Sensor.TYPE_PROXIMITY), SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager?.registerListener(acelerometro,sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL)



    }
}

