package com.example.pruebaproyectofinal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LogIn : AppCompatActivity() {

    private lateinit var edtUsuario: EditText
    private lateinit var edtContraseña: EditText
    private lateinit var btLogin: Button
    private lateinit var btRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        edtUsuario = findViewById(R.id.edtUsuario)
        edtContraseña = findViewById(R.id.edtContraseña)
        btLogin = findViewById(R.id.btLogin)
        btRegister = findViewById(R.id.btRegister)

        btRegister.setOnClickListener{

            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)

        }
    }
}