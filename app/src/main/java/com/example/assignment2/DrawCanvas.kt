package com.example.assignment2

import android.app.AlertDialog
import com.example.assignment2.R.id.drawing_view
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.dhaval2404.colorpicker.ColorPickerDialog
import com.github.dhaval2404.colorpicker.model.ColorShape

import com.google.android.material.card.MaterialCardView
import com.mihir.drawingcanvas.drawingView

class DrawCanvas : AppCompatActivity() {
    private var selectedValue: Int = 0
    lateinit var drawingView: drawingView
    lateinit var clearButton: MaterialCardView
    lateinit var undoButton: MaterialCardView
    lateinit var redoButton: MaterialCardView
    lateinit var brushButton: MaterialCardView
    lateinit var colorButton: MaterialCardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContentView(R.layout.activity_draw_canvas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        drawingView = findViewById<drawingView>(drawing_view)

    undoButton = findViewById<MaterialCardView>(R.id.undoButton)
    undoButton.setOnClickListener{
        drawingView.undo()
    }
    redoButton = findViewById<MaterialCardView>(R.id.redoButton)
    redoButton.setOnClickListener {
        drawingView.redo()
    }
    brushButton = findViewById<MaterialCardView>(R.id.brushButton)
    brushButton.setOnClickListener {
        showDialog()
    }
    colorButton= findViewById<MaterialCardView>(R.id.colorButton)
    colorButton.setOnClickListener {
        ColorPickerDialog
            .Builder(this)
            .setTitle("Pick Theme")
            .setColorShape(ColorShape.SQAURE)
            .setDefaultColor(R.color.black)
            .setColorListener { color, colorHex ->
                drawingView.setBrushColor(color)
            }
            .show()
    }
    clearButton = findViewById(R.id.clearButton)
    clearButton.setOnClickListener {
        drawingView.clearDrawingBoard()
    }
    }
    private fun showDialog() {
        val seekBar = SeekBar(this)
        seekBar.max = 100  // Set the maximum value for the SeekBar
        seekBar.progress = selectedValue  // Set initial progress to the stored value

        // Creating a TextView to display the current value of SeekBar
        val valueTextView = TextView(this)
        valueTextView.text = "Selected Value: $selectedValue"

        // Create the dialog
        val dialog = AlertDialog.Builder(this)
            .setTitle("Select a Value")
            .setView(seekBar)  // Add SeekBar to dialog
            .setPositiveButton("OK") { _, _ ->
                // Store the selected value when "OK" is clicked
                selectedValue = seekBar.progress
                Toast.makeText(this, "Selected Value: $selectedValue", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel") { _, _ -> }
            .create()

        // Set SeekBar listener to update the displayed value dynamically
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                valueTextView.text = "Selected Value: $progress"  // Update value dynamically
                drawingView.setSizeForBrush(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Show the dialog
        dialog.show()
    }
}