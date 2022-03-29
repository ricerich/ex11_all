package com.example.ex04_spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity()
{
    public override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "스피너 테스트"

        var movie = arrayOf("쿵푸팬더", "짱구는 못말려",
            "아저씨", "아바타", "대부", "국가대표", "토이스토리3",
            "마당을 나온 암탉", "죽은 시인의 사회", "서유기")
        var arr1 = arrayOf(R.drawable.mov21, R.drawable.mov22, R.drawable.mov23,
                               R.drawable.mov24, R.drawable.mov25, R.drawable.mov26,
                               R.drawable.mov27, R.drawable.mov28, R.drawable.mov29,
                               R.drawable.mov30)

        var spinner = findViewById<Spinner>(R.id.spinner1)

        var adapter: ArrayAdapter<String>
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, movie)

        spinner.adapter = adapter

        //어댑터뷰 이벤트 처리 - 이건 안된!!!
//        spinner.setOnItemClickListener { adapterView, view, i, l ->
//
////            var iv1 = findViewById<ImageView>(R.id.ivPoster)
////            iv1.scaleType = ImageView.ScaleType.FIT_CENTER
////            iv1.setPadding(5,5,5,5)
//////            iv1.setImageResource(R.drawable.mov21)
////            iv1.setImageResource(arr1[i])
//
//        }

        //이게 됨!
//        tv1.setText("aaa")
//        tv1.text = "aaa"
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long)
            {
                var iv1 = findViewById<ImageView>(R.id.ivPoster)
                iv1.scaleType = ImageView.ScaleType.FIT_CENTER
                iv1.setPadding(5,5,5,5)
                iv1.setImageResource(R.drawable.mov21)
                iv1.setImageResource(arr1[p2])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }
}

