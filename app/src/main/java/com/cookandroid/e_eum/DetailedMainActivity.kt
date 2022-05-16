package com.cookandroid.e_eum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DetailedMainActivity : AppCompatActivity() {

    private  lateinit var  newRecyclerView: RecyclerView
    private lateinit var  newArrayList: ArrayList<Detailed>
     lateinit var imageId : Array<Int>
     lateinit var heading : Array<String>
     lateinit var explain : Array<String>
    lateinit var imageId2 : Array<Int>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailed_main)

        imageId = arrayOf(R.drawable.video,
            R.drawable.video2,
            R.drawable.video,
            R.drawable.video2,
            R.drawable.video,
            R.drawable.video2,
            R.drawable.video,
            R.drawable.video2,
            R.drawable.video,
            R.drawable.video2,)



        heading = arrayOf(
            "못생기다, 추하다, 못나다. 밉다",
            "오해",
            "배부르다. 부르다",
            "어지럽다",
            "슬그머니",
            "넣다. 담그다",
            "내려오다",
            "뽀뽀, 입맞춤, 키스, 맞추다",
            "솔직하다, 정직",
            "뜨다, 개안",
        )

        explain = arrayOf(
           getString(R.string.explain_a),
            getString(R.string.explain_b),
            getString(R.string.explain_c),
            getString(R.string.explain_d),
            getString(R.string.explain_e),
            getString(R.string.explain_f),
            getString(R.string.explain_g),
            getString(R.string.explain_h),
            getString(R.string.explain_i),
            getString(R.string.explain_j),

        )

        imageId2 = arrayOf(R.drawable.picture,
            R.drawable.picture2,
            R.drawable.picture3,
            R.drawable.picture4,
            R.drawable.picture5,
            R.drawable.picture6,
            R.drawable.picture7,
            R.drawable.picture8,
            R.drawable.picture9,
            R.drawable.picture10,)


        newRecyclerView = findViewById(R.id.detailed_recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Detailed>()
        getUserdata()

        }

        private fun getUserdata(){

        for(i in imageId.indices){

            val detailed = Detailed(imageId[i], heading[i])
            newArrayList.add(detailed)

        }

        val adapter = DetailedAdapter(newArrayList)
        newRecyclerView.adapter = adapter
       adapter.setOnItemClickListener(object : DetailedAdapter.onItemClickListener{
           override fun onItemClickListener(position: Int) {

              // Toast.makeText(this@DetailedMainActivity,"Click no. $position", Toast.LENGTH_SHORT).show()i

               val intent = Intent(this@DetailedMainActivity, VideoActivity::class.java)
                intent.putExtra("heading", newArrayList[position].heading)
               intent.putExtra("imageId", newArrayList[position].titleImage)
               intent.putExtra("explainId", explain[position])
               intent.putExtra("imageId2", imageId2[position])
               startActivity(intent)


           }



       })



        }
    }