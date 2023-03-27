package com.example.uccitapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Admissions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admissions)

        val apply:TextView=findViewById(R.id.application)
        //When user presses on the apply button they will be taken to the UCC application page
        apply.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://ucc.edu.jm/apply/undergraduate")))
        }
    }
}