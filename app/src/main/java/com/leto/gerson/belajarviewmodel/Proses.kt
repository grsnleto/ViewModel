package com.leto.gerson.belajarviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Proses : ViewModel() {

    val liveData = MutableLiveData<Hasil>()

    fun setHitung(panjang: String, lebar: String): LiveData<Hasil> {
        val p = panjang.toDouble()
        val l = lebar.toDouble()
        val simpan = p * l
        val hasil = Hasil(simpan.toString())
        liveData.postValue(hasil)
        return liveData
    }

    fun getHitung(): LiveData<Hasil> {
        return liveData
    }
}