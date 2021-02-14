package com.example.contactsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_kayit.*

class KayitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kayit)

        val database = FirebaseDatabase.getInstance()

        val refUsers = database.getReference("kullanicilar")


        buttonKayitOl.setOnClickListener {
            val kullanici_adi = editTextKayitKullaniciAdi.text
            val sifre = editTextKayitSifre.text
            //val nesne = userInfo("asd",1,"123123")
            val kullanici = Kullanicilar(kullanici_adi.toString(),sifre.toString())
            refUsers.push().setValue(kullanici)
            val intent = Intent(this,MainActivity::class.java)
            finish()
            startActivity(intent)
        }
    }
}