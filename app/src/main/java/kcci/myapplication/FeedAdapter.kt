package kcci.myapplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_list.view.*
import kotlinx.android.synthetic.main.item_text.view.*
import java.lang.IllegalArgumentException

/**
 * Created by BALCK_NUT on 2017-05-31.
 */
class FeedAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val VIEW_TYPE_PHOTO = 1
    val VIEW_TYPE_TEXT = 2

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position : Int) {
        when (holder) {

            is PhotoHolder -> holder.bindView("작가 $position", "설명 $position")
            is TextHolder -> holder.bindView("작가 $position", "설명 $position")

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            VIEW_TYPE_PHOTO -> return PhotoHolder(parent)
            VIEW_TYPE_TEXT -> return TextHolder(parent)
        }
        throw IllegalArgumentException("Unknown view type : $viewType")
    }


    override fun getItemViewType(position: Int): Int {
        return if (position %2 == 0) VIEW_TYPE_PHOTO else VIEW_TYPE_TEXT
    }

    inner class TextHolder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.
            from(parent.context).inflate(R.layout.item_text, parent, false)) {

        fun bindView(author: String, description: String) {
            with(itemView) {
                text_author.text = author
                text_description.text = description
            }
        }
    }

    inner class PhotoHolder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.
            from(parent.context).inflate(R.layout.item_list, parent, false)) {

        fun bindView(author: String, description: String) {
            with(itemView) {
                item_photo.setImageResource(R.drawable.kotlin)
                photo_author.text = author
                photo_description.text = description
            }
        }
    }
}
