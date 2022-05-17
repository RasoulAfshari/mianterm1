package com.example.mianterm

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getStateLogin(this)

//        val builder=AlertDialog.Builder(this).create()
//        val view=layoutInflater.inflate(R.layout.dialog,null)
//        builder.setView(view)
//        builder.setCancelable(false)
//        builder.show()

        val btn_ok:Button=findViewById(R.id.btn_ok)
        val chbox:CheckBox=findViewById(R.id.chbox)
        btn_ok.setOnClickListener {
            if(chbox.isChecked){

                var intent: Intent =Intent(this,viewmore::class.java)
                finish()
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this, "تایید قوانین !!!!", Toast.LENGTH_SHORT).show()
            }

        }








    }
    private fun getStateLogin(context: Context) {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("login_pref", Context.MODE_PRIVATE)
        if (sharedPreferences.getBoolean("state", false)) {
            var intent: Intent = Intent(this, viewmore::class.java)
            finish()
            startActivity(intent)
        }
    }
}