package com.example.pruebafirebase

import android.content.ContentValues.TAG
import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.newFixedThreadPoolContext


class MainActivity : AppCompatActivity() {

    private lateinit var  auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth= FirebaseAuth.getInstance()

        val Editnombre = findViewById<EditText>(R.id.editTextName)
        val Editemail = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val Editcontraseña = findViewById<EditText>(R.id.editTextTextPassword)
        val boton = findViewById<Button>(R.id.button)

        boton.setOnClickListener {
            val nombre = Editnombre.text.toString()
            val email = Editemail.text.toString()
            val contraseña = Editcontraseña.text.toString()

            if (nombre.isNotEmpty() && email.isNotEmpty() && contraseña.isNotEmpty()) {

                registerUser(email, contraseña)
            }

        }
    }

    private fun registerUser(email: String, contraseña: String){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,contraseña).addOnCompleteListener{
            if (it.isSuccessful){
                showEntrada()
            }
            else{
                showAlert()
            }
        }
    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("error")
        builder.setMessage("se ha producido un error")
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun showEntrada(){
        val homeIntent = Intent(this, Entrada::class.java).apply {

        }
         startActivity(homeIntent)
    }


}