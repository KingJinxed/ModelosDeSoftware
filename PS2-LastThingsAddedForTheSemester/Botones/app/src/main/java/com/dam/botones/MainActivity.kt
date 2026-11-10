package com.dam.botones

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ToggleButton
import android.widget.Switch
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.RadioButton
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.chip.Chip

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button: Button = findViewById(R.id.button)
        val imageButton: ImageButton = findViewById(R.id.imageButton)
        val toggleButton: ToggleButton = findViewById(R.id.toggleButton)
        val switchButton: Switch = findViewById(R.id.switchButton)
        val checkBox: CheckBox = findViewById(R.id.checkBox)
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val seekBar: SeekBar = findViewById(R.id.seekBar)
        val fab: FloatingActionButton = findViewById(R.id.fab)
        val chip: Chip = findViewById(R.id.chip)

        button.setOnClickListener {
            Toast.makeText(this, "Boton clicked!", Toast.LENGTH_SHORT).show()
        }

        imageButton.setOnClickListener {
            Toast.makeText(this, "Boton de imagen!", Toast.LENGTH_SHORT).show()
        }

        toggleButton.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, if (isChecked) "Toggle encendido" else "Toggle Apagado", Toast.LENGTH_SHORT).show()
        }

        switchButton.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, if (isChecked) "Switch encendido" else "Switch Apagado", Toast.LENGTH_SHORT).show()
        }

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, if (isChecked) "Check encendido" else "Check Apagado", Toast.LENGTH_SHORT).show()
        }

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val selected = findViewById<RadioButton>(checkedId)
            Toast.makeText(this, "Radio: ${selected.text}", Toast.LENGTH_SHORT).show()
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(sb: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser) Toast.makeText(this@MainActivity, "Nivel: $progress", Toast.LENGTH_SHORT).show()
            }
            override fun onStartTrackingTouch(sb: SeekBar) {}
            override fun onStopTrackingTouch(sb: SeekBar) {}
        })

        fab.setOnClickListener {
            Toast.makeText(this, "Flotante!", Toast.LENGTH_SHORT).show()
        }

        chip.setOnClickListener {
            chip.isChecked = !chip.isChecked
            Toast.makeText(this, "Chip: ${if (chip.isChecked) "Precionado" else "No precionado"}", Toast.LENGTH_SHORT).show()
        }
    }
}