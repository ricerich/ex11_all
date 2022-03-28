package com.example.ex01_listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var edt1 = findViewById<EditText>(R.id.edtItem)
        var btn1 = findViewById<Button>(R.id.btnAdd)

        //어댑터"뷰"
        var list1 = findViewById<ListView>(R.id.listView1)

        //어댑터 만들어서 어댑터뷰에 꽂는다

//        var arr1 = arrayOf("사과","딸기","당근")//일반배열, 고정크기, 갯수정해짐!
        var arr1 = ArrayList<String>()
        //심플버전으로 어댑터 만들꺼임
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arr1)

        //어댑터를 -> 어댑터뷰에
        list1.adapter = adapter

        btn1.setOnClickListener {
            arr1.add(edt1.text.toString())//어댑터에 쓸 3번배열 값을 바꾼다.
            adapter.notifyDataSetChanged()//바뀐 배열을 가지고, 어댑터를 갱신한다.
        }

        list1.setOnItemLongClickListener { adapterView, view, position, l ->
            arr1.removeAt(position)//배열을 바꾼다
            adapter.notifyDataSetChanged()//바뀐 배열을 가지고, 어댑터를 갱신한다.
            false
        }
    }
}