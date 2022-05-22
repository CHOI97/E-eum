package com.cookandroid.e_eum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
//사전
class ContentMainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private  lateinit var contentList: ArrayList<Content>
    private lateinit var contentAdapter: ContentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.each_main)


        init()
    }

    private fun init(){
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this,2)

        contentList = ArrayList()
        addDataToList(2)



        contentAdapter = ContentAdapter(contentList)
        recyclerView.adapter = contentAdapter

        contentAdapter.onItemClick = {
            val intent = Intent(this, DetailedMainActivity::class.java)
            intent.putExtra("content", it)
            startActivity(intent)

        }

    }


    private fun addDataToList(value: Int) {
        if(value==2)
        { contentList.add(Content(R.drawable.person, "인간"))
       contentList.add(Content(R.drawable.life, "삶"))
        contentList.add(Content(R.drawable.food, "식생활"))
        contentList.add(Content(R.drawable.clothes, "의생활"))
       contentList.add(Content(R.drawable.house, "주생활"))
       contentList.add(Content(R.drawable.social, "사회생활"))
       contentList.add(Content(R.drawable.economy, "경제생활"))
       contentList.add(Content(R.drawable.study, "교육"))
        contentList.add(Content(R.drawable.place, "나라명 및 지명"))
       contentList.add(Content(R.drawable.church, "종교"))
        contentList.add(Content(R.drawable.movie, "문화"))
       contentList.add(Content(R.drawable.ic_baseline_public_24, "정치와 행정"))
       contentList.add(Content(R.drawable.nature, "자연"))
       contentList.add(Content(R.drawable.aniaml, "동식물"))
        contentList.add(Content(R.drawable.notion, "개념"))
        contentList.add(Content(R.drawable.els, "기타"))}

        if(value==3)
        {contentList.add(Content(R.drawable.person, "법률"))
        contentList.add(Content(R.drawable.life, "교통"))
        contentList.add(Content(R.drawable.food, "의학"))
        contentList.add(Content(R.drawable.clothes, "정보통신"))
        contentList.add(Content(R.drawable.house, "불교"))
        contentList.add(Content(R.drawable.social, "천주교"))
        contentList.add(Content(R.drawable.economy, "기독교"))
        contentList.add(Content(R.drawable.study, "국어 교과 용어"))
        contentList.add(Content(R.drawable.place, "경제"))
        contentList.add(Content(R.drawable.church, "정치"))}
    }



}