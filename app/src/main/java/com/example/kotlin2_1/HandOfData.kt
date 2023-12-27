package com.example.kotlin2_1

object HandOfData {

    private var data: Data? = null

    fun setData(data: Data) {
        this.data = data
    }
    fun getData() = data
}