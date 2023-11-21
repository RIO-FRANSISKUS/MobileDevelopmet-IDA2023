package com.example.pertemuanpertamaapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnExplicitIntent : Button
    private lateinit var btnMoveWithData : Button
    private lateinit var btnMoveWithParcelableData : Button
    private lateinit var btnImplicitIntent : Button
    private lateinit var btnMoveForResult : Button

    private lateinit var tvValue : TextView

    private val valueLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){ result ->
       if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
           val selectedValue = result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
           val text = "Hasil : $selectedValue"
           tvValue.text = text
       }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvValue = findViewById(R.id.tv_value)

        btnExplicitIntent = findViewById(R.id.btn_explicit_intent)

        btnExplicitIntent.setOnClickListener(this)

        btnMoveWithData = findViewById(R.id.btn_move_with_data)
        btnMoveWithData.setOnClickListener(this)

        btnMoveWithParcelableData = findViewById(R.id.btn_move_with_data_parcelable)
        btnMoveWithParcelableData.setOnClickListener(this)

        btnImplicitIntent = findViewById(R.id.btn_implicit_intent)
        btnImplicitIntent.setOnClickListener(this)

        btnMoveForResult = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_explicit_intent -> {
                val moveActivity = Intent(this@MainActivity, ExplicitIntentActivity::class.java)
                startActivity(moveActivity)
            }

            R.id.btn_move_with_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Adam")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
                startActivity(moveWithDataIntent)
            }

            R.id.btn_move_with_data_parcelable -> {
                val person = Person(
                    "Adam",
                    5,
                    "adam@gmail.com",
                    "Medan"
                )

                val moveWithParcelableData = Intent(this@MainActivity, ParcelableDataActivity::class.java)
                moveWithParcelableData.putExtra(ParcelableDataActivity.EXTRA_PERSON, person)
                startActivity(moveWithParcelableData)
            }

            R.id.btn_implicit_intent -> {
                val phoneNumber = "082367485467"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.btn_move_for_result -> {
                val moveForResultIntent = Intent(this@MainActivity, MoveForResultActivity::class.java)
                valueLauncher.launch(moveForResultIntent)
            }

        }
    }
}