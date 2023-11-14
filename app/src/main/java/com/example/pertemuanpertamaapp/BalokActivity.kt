package com.example.pertemuanpertamaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

class BalokActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtLenght: EditText
    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var tvHasil: TextView
    private lateinit var btnCalculate: Button
    private lateinit var btnBack: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balok)

        edtLenght = findViewById(R.id.edt_lenght)
        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_Height)

        tvHasil = findViewById(R.id.hasil_tv)

        btnCalculate = findViewById(R.id.btn_calculate)
        btnBack = findViewById(R.id.btn_back)

        btnBack.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }

        btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            tvHasil.text = result
        }
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_calculate){
            val inputLenght = edtLenght.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            var isEmptyString = false

            if (inputLenght.isEmpty()){
                isEmptyString = true
                edtLenght.error = "Tidak boleh kosong"
            }
            if (inputWidth.isEmpty()){
                isEmptyString = true
                edtWidth.error = "Tidak boleh kosong"
            }
            if (inputHeight.isEmpty()){
                isEmptyString = true
                edtHeight.error = "Tidak boleh kosong"
            }

            if (!isEmptyString){
                val volume = inputLenght.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tvHasil.text = volume.toString()
            }

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(STATE_RESULT, tvHasil.text.toString())
    }

    companion object{
        private const val STATE_RESULT = "state_result"
    }
}