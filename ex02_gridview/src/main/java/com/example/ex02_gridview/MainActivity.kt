package com.example.ex02_gridview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        //1.어댑터뷰
        var gv1 = findViewById<GridView>(R.id.gridView1)
        
        //2.어댑터
//        var adapter1 = ArrayAdapter(1,2,3)//이건 심플 버전
        var adapter1 = MyGridAdapter(this)//복잡 버전 -> 클래스로 따로 만들어줘야함(baseAdpater 상속받는걸로해서)

        //3.어댑터를 어댑터뷰에 꽂는다
        gv1.adapter = adapter1
        
    }

    inner class MyGridAdapter(var context: Context) : BaseAdapter() {


        //3번 데이터
        var arr1 = arrayOf(
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
            R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
            R.drawable.mov09, R.drawable.mov10,
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
            R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
            R.drawable.mov09, R.drawable.mov10,
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
            R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
            R.drawable.mov09, R.drawable.mov10
        )

        override fun getCount(): Int
        {
            return arr1.size
        }

        override fun getItem(p0: Int): Any {
            return 0
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {

            var view1 = ImageView(context)
//            view1.setImageResource(R.drawable.mov01)
            view1.setImageResource(arr1[position])

            return view1//어댑터뷰에 1줄(1칸)에 들어갈 디자인을 꽂는다
        }

    }


}


