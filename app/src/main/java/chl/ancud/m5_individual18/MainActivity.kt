package chl.ancud.m5_individual18

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import chl.ancud.m5_individual18.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mSharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mSharedPreferences = getSharedPreferences("cookie", Context.MODE_PRIVATE)
        binding.btGuardar.setOnClickListener {
            val texto = binding.etTexto.text.toString()
            val entero = binding.etEntero.text.toString().toInt()
            val decimal = binding.etDecimal.text.toString().toFloat()
            val boleano = binding.switch1.isChecked

            guardarDatos(texto, entero, decimal, boleano)
        }

        binding.btMostrar.setOnClickListener {
            mostrarDatos()
        }

        binding.btBorrar.setOnClickListener {
            borrarDatos()
        }
    }

    private fun guardarDatos(texto: String, entero: Int, decimal: Float, boleano: Boolean) {
        mSharedPreferences.edit().putString("miTexto", texto).apply()
        mSharedPreferences.edit().putInt("miEntero", entero).apply()
        mSharedPreferences.edit().putFloat("miDecimal", decimal).apply()
        mSharedPreferences.edit().putBoolean("miBooleano", boleano).apply()
    }

    private fun mostrarDatos(){
        val texto = mSharedPreferences.getString("miTexto", "")
        val entero = mSharedPreferences.getInt("miEntero", 0)
        val decimal = mSharedPreferences.getFloat("miDecimal", 0.0f)
        val boleano = mSharedPreferences.getBoolean("miBooleano", false)

        binding.tvTexto.text = texto
        binding.tvEntero.text = entero.toString()
        binding.tvDecimal.text = decimal.toString()
        binding.tvSwitch.text = boleano.toString()

        binding.switch1.isChecked = boleano
    }

    private fun borrarDatos() {
        binding.tvTexto.text = ""
        binding.tvEntero.text = ""
        binding.tvDecimal.text = ""
        binding.tvSwitch.text = ""

        binding.etTexto.text.clear()
        binding.etEntero.text.clear()
        binding.etDecimal.text.clear()
        binding.switch1.isChecked = false

        mSharedPreferences.edit().clear().apply()

    }
}