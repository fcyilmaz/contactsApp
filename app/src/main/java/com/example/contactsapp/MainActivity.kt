package com.example.contactsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_kayit.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = FirebaseDatabase.getInstance()

        val refUsers = database.getReference("kullanicilar")

        var username = editTextKullaniciAdi.text
        var password = editTextSifre.text

        textViewKayitOl.setOnClickListener {
            val intent = Intent(this,KayitActivity::class.java)
            startActivity(intent)
        }

        buttonGirisYap.setOnClickListener {
            finish()
            refUsers.addValueEventListener(object : ValueEventListener{
                override fun onCancelled(error: DatabaseError) {
                }

                override fun onDataChange(ds: DataSnapshot) {

                    for (p in ds.children){
                        val kisi = p.getValue(Kullanicilar::class.java)

                        if (kisi!=null){
                            if (username.toString()==kisi.username){
                                if (password.toString()==kisi.password){
                                    val intent = Intent(this@MainActivity,KullaniciActivity::class.java)
                                    startActivity(intent)
                                    Log.e("gidiliyor",kisi.username.toString())
                                }
                            }
                        }
                    }

                }

            })

        }
    }
}