package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var head_3 : TextView? = null
    private var head_5 : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        head_3 = findViewById(R.id.head_3)
        head_5 = findViewById(R.id.head_5)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            clickDatepicker()
            //Toast.makeText(this , "select date" , Toast.LENGTH_LONG).show()

        }

    }
    fun clickDatepicker() {
        val myCalendar = Calendar.getInstance()
        var Year = myCalendar.get(Calendar.YEAR)
        var month = myCalendar.get(Calendar.MONTH)
        var Day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, Year, month, Day ->

                val selecteddate = "$Day/${month+1}/$Year"
                //head_3?.setText(selecteddate)
                head_3?.text=selecteddate

                val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH )
                val theDate = sdf.parse(selecteddate)
                val dateinmin = theDate.time / 60000
                val currentdate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentdateinMin = currentdate.time / 60000
                val difference = currentdateinMin - dateinmin
                head_5?.text= difference.toString()
            },
            Year,
            month,
            Day,

            ).show()
    }

}