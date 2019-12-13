package com.example.myunittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mainViewModel: MainViewModel

    private lateinit var edtWidth: EditText
    private lateinit var edtLength: EditText
    private lateinit var edtHeight: EditText
    private lateinit var tvResult: TextView
    private lateinit var btnCalculateVolume: Button
    private lateinit var btnCalculateSurfaceArea: Button
    private lateinit var btnCalculateCircumference: Button
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = MainViewModel(CuboidModel())

        edtWidth = findViewById(R.id.edt_width)
        edtLength = findViewById(R.id.edt_length)
        edtHeight = findViewById(R.id.edt_height)
        tvResult = findViewById(R.id.tv_result)
        btnCalculateVolume = findViewById(R.id.btn_calculate_volume)
        btnCalculateCircumference = findViewById(R.id.btn_calculate_circumference)
        btnCalculateSurfaceArea = findViewById(R.id.btn_calculate_surface_area)
        btnSave = findViewById(R.id.btn_save)

        btnSave.setOnClickListener(this)
        btnCalculateCircumference.setOnClickListener(this)
        btnCalculateSurfaceArea.setOnClickListener(this)
        btnCalculateVolume.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val length = edtLength.text.toString().trim()
        val width = edtLength.text.toString().trim()
        val height = edtLength.text.toString().trim()

        when {
            length.isEmpty() -> edtLength.error = "Field ini tidak boleh kosong"
            width.isEmpty() -> edtLength.error = "Field ini tidak boleh kosong"
            height.isEmpty() -> edtLength.error = "Field ini tidak boleh kosong"
            else -> {
                val l = length.toDouble()
                val w = length.toDouble()
                val h = length.toDouble()

                when {
                    view.id == R.id.btn_save -> {
                        mainViewModel.save(l, w, h)
                        visible()
                    }
                    view.id == R.id.btn_calculate_volume -> {
                        tvResult.text = mainViewModel.getVolume().toString()
                        gone()
                    }
                    view.id == R.id.btn_calculate_surface_area -> {
                        tvResult.text = mainViewModel.getSurfaceArea().toString()
                        gone()
                    }
                    view.id == R.id.btn_calculate_circumference -> {
                        tvResult.text = mainViewModel.getCircumference().toString()
                        gone()
                    }
                }
            }
        }
    }

    private fun visible() {
        btnCalculateVolume.visibility = View.VISIBLE
        btnCalculateCircumference.visibility = View.VISIBLE
        btnCalculateSurfaceArea.visibility = View.VISIBLE
        btnSave.visibility = View.GONE
    }

    private fun gone() {
        btnCalculateVolume.visibility = View.GONE
        btnCalculateCircumference.visibility = View.GONE
        btnCalculateSurfaceArea.visibility = View.GONE
        btnSave.visibility = View.VISIBLE
    }
}
