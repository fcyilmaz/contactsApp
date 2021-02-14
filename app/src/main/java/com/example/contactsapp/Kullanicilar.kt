package com.example.contactsapp

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Kullanicilar(
    var username: String? ="",
    var password: String? =""
    ) {
}