package com.movilesi.practicafirebase20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Firebase.database
        val myRef = database.reference

        /*
        myRef.child("ejemplo").child("1").setValue(Card("1","rojo","corazones"))
        myRef.child("ejemplo").child("2").setValue(Card("9","rojo","treboles"))
        myRef.child("ejemplo").child("3").setValue(Card("3","rojo","diamantes"))
        myRef.child("ejemplo").child("4").setValue(Card("5","negro","espadas"))


        myRef.child("users").child("user_id:01").setValue(User("tona","franco",28,"tona@hotmail.com"))
        myRef.child("users").child("user_id:02").setValue(User("alex","tapia",26,"alex@hotmail.com"))
        myRef.child("users").child("user_id:03").setValue(User("ema","gonzalez",25,"ema@hotmail.com"))

         */

        myRef.child("movies").child("1").setValue(Pelis("Back to the future", "1985", "tt0088763", "movie", "https://filmartgallery.com/products/back-to-the-future-4", "EU", "Comedia/Ciencia ficción"))
        myRef.child("movies").child("2").setValue(Pelis("Star Wars Episode: VI", "1983", "tt0086190", "movie", "https://www.pinterest.es/pin/289778557267244296/?send=true", "EU", "\n" +
                "Acción/Aventura/Fantasía/Ciencia ficción"))
        myRef.child("movies").child("3").setValue(Pelis("Jurassic Park","1993","tt0107290","movie","https://moviepostermexico.com/products/poster-pelicula-jurassic-park","EU","Accion/Aventura/Ciencia ficción"))

        myRef.child("movies").child("1").get().addOnSuccessListener { response ->
            //TODO value
            Log.d("firebaseResponse", response.value.toString())
        }.addOnFailureListener {
            Log.e("firebaseResponse", "Error getting data", it)
        }
    }

}