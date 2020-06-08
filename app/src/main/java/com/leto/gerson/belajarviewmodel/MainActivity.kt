package com.leto.gerson.belajarviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: Proses

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(Proses::class.java)
        viewModel.getHitung().observe(this, getHitung)

        btnhasil.setOnClickListener {
            hitung(isi_panjang.text.toString().trim(), isi_lebar.text.toString().trim())
        }
    }

    fun hitung(panjang: String, lebar: String) {
        if (panjang.isEmpty() || lebar.isEmpty()) {
            Toast.makeText(applicationContext,"Data Kosong!", Toast.LENGTH_SHORT).show()
        } else {
           viewModel.setHitung(isi_panjang.text.toString().trim(), isi_lebar.text.toString().trim())
        }
    }

    val getHitung = Observer<Hasil> {
        it.let {
            hasilHitung.text = it?.hasil
        }
    }
}
