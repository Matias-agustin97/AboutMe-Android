package com.example.aboutyou

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener{
            addNickname(it)//it es como this, hace referenca a esta view, en este caso el boton
            //it solo funciona si es el unico parametro en la funcion
        }

        findViewById<TextView>(R.id.nickname_text).setOnClickListener{
            changeNick(it)
        }
    }


    private fun changeNick(view: View){
        val editText=findViewById<EditText>(R.id.nickname_edit)
        val doneButton =findViewById<Button>(R.id.done_button)


        editText.requestFocus()
        editText.visibility=View.VISIBLE
        doneButton.visibility=View.VISIBLE

        view.visibility=View.GONE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)

    }


    private fun addNickname(view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
        nicknameTextView.text= editText.text

        editText.visibility=View.GONE // hide the view

        view.visibility=View.GONE//view es el objeto al que reacciona este evento, en
        //este caso el boon de DONE
        nicknameTextView.visibility=View.VISIBLE

        //analiza este choclo... oculta el teclado
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}