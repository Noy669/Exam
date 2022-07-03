package com.example.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {


    private lateinit var snackView: Snackbar
    private lateinit var mainRoot: ConstraintLayout
    private lateinit var inflater: LayoutInflater
    private lateinit var btnLogin: Button
    private lateinit var passwordEditText: EditText
    private lateinit var loginEditText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFun()

        btnLogin.setOnClickListener {
            val loginTemp = loginEditText.text.toString()
            val passwordTemp = passwordEditText.text.toString()
            loginTemp.trim()
            passwordTemp.trim()
            if (loginTemp.length > 7
                && !loginTemp[0].isDigit()
                && passwordTemp.length > 7
                && passwordTemp[0].isUpperCase()
            ) {
                supportFragmentManager.beginTransaction()
                    .add(R.id.second_fragment, "TAG")
                    .addToBackStack(mainRoot)
            }

        else if (!(passwordTemp.length < 7
                    && passwordTemp[0].isDigit()
                    ))
        {
            addPassSnacbar()
        } else {
            addUserSnacbar()
        }
    }}

    private fun initFun() {
        loginEditText = findViewById(R.id.et_user)
        passwordEditText = findViewById(R.id.et_password)
        mainRoot = findViewById(R.id.main_root)
        btnLogin = findViewById(R.id.bt_login)
        inflater = layoutInflater
    }

    private fun addUserSnacbar() {
        val snack = Snackbar.make(mainRoot, "‘Username is not valid", Snackbar.LENGTH_LONG)
        snackView = snack
        snackView.show()


    }

    private fun addPassSnacbar() {
        val snack = Snackbar.make(mainRoot, "Password is not valid", Snackbar.LENGTH_LONG)
        snackView = snack
        snackView.show()

    }

}