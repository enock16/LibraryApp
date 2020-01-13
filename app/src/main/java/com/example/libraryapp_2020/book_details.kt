package com.example.libraryapp_2020

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.book_details.*

class book_details :AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_details)
        val bundle=intent.extras

       ivbookimage.setImageResource(bundle!!.getInt("image"))
        textView.text = bundle.getString("name")
        textView2.text = bundle.getString("des")

    }







}

