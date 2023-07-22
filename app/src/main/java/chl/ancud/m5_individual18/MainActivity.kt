package chl.ancud.m5_individual18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import chl.ancud.m5_individual18.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}