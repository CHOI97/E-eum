package com.cookandroid.e_eum;

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager

internal class NewsActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var mAdapter: RecyclerView.Adapter<*>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private val myDataset = arrayOf("1", "2")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dic)
        recyclerView = findViewById<View>(R.id.my_recycler_view) as RecyclerView

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView!!.setHasFixedSize(true)

        // use a linear layout manager
        layoutManager = LinearLayoutManager(this)
        recyclerView!!.layoutManager = layoutManager

        // specify an adapter (see also next example)
        mAdapter = MyAdapter(myDataset)
        recyclerView!!.adapter = mAdapter
    }
}