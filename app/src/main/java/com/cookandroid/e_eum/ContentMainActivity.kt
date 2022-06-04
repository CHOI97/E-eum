package com.cookandroid.e_eum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.e_eum.databinding.ActivityContentMainBinding

//사전
class ContentMainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private  lateinit var contentList: ArrayList<Content>
    private lateinit var contentAdapter: ContentAdapter
    private lateinit var viewbinding: ActivityContentMainBinding
    private lateinit var tempintent : Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding  = ActivityContentMainBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)
        init()
    }

    private fun init(){

        viewbinding.recyclerView.setHasFixedSize(true)
        viewbinding.recyclerView.layoutManager = GridLayoutManager(this,2)
        contentList = ArrayList()
        tempintent = intent
        addDataToList(tempintent.getStringExtra("category"))
        Log.d("tempintent",tempintent.getStringExtra("category").toString())


        contentAdapter = ContentAdapter(contentList)
        viewbinding.recyclerView.adapter = contentAdapter

        contentAdapter.onItemClick = {
            val intent = Intent(this, DetailedMainActivity::class.java)
            intent.putExtra("content", it.code)
            startActivity(intent)

        }

    }


    private fun addDataToList(value: String?) {
        if(value=="CTE")
        { contentList.add(Content(R.drawable.person, "인간","CTE001"))
       contentList.add(Content(R.drawable.life, "삶","CTE002"))
        contentList.add(Content(R.drawable.food, "식생활","CTE003"))
        contentList.add(Content(R.drawable.clothes, "의생활","CTE004"))
       contentList.add(Content(R.drawable.house, "주생활","CTE005"))
       contentList.add(Content(R.drawable.social, "사회생활","CTE006"))
       contentList.add(Content(R.drawable.economy, "경제생활","CTE007"))
       contentList.add(Content(R.drawable.study, "교육","CTE008"))
        contentList.add(Content(R.drawable.place, "나라명 및 지명","CTE009"))
       contentList.add(Content(R.drawable.church, "종교","CTE010"))
        contentList.add(Content(R.drawable.movie, "문화","CTE011"))
       contentList.add(Content(R.drawable.ic_baseline_public_24, "정치와 행정","CTE012"))
       contentList.add(Content(R.drawable.nature, "자연","CTE013"))
       contentList.add(Content(R.drawable.aniaml, "동식물","CTE014"))
        contentList.add(Content(R.drawable.notion, "개념","CTE015"))
        contentList.add(Content(R.drawable.els, "기타","CTE016"))}

        if(value == "SPE")
        {contentList.add(Content(R.drawable.person, "법률", "SPE001"))
        contentList.add(Content(R.drawable.life, "교통", "SPE002"))
        contentList.add(Content(R.drawable.food, "의학", "SPE003"))
        contentList.add(Content(R.drawable.clothes, "정보통신", "SPE004"))
        contentList.add(Content(R.drawable.house, "불교", "SPE005"))
        contentList.add(Content(R.drawable.social, "천주교", "SPE006"))
        contentList.add(Content(R.drawable.economy, "기독교", "SPE007"))
        contentList.add(Content(R.drawable.study, "국어 교과 용어", "SPE008"))
        contentList.add(Content(R.drawable.place, "경제", "SPE009"))
        contentList.add(Content(R.drawable.church, "정치", "SPE010"))}
    }



}