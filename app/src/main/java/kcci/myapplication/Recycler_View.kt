package kcci.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

/**
 * Created by BALCK_NUT on 2017-05-31.
 */
class Recycler_View : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        with(recycler_view) {
            layoutManager = LinearLayoutManager(this@Recycler_View)
            adapter = FeedAdapter()
        }
    }

}