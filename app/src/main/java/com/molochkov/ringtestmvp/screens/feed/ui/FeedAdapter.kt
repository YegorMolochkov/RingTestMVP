package com.molochkov.ringtestmvp.screens.feed.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.molochkov.ringtestmvp.R
import com.molochkov.ringtestmvp.screens.feed.data.FeedEntry
import com.molochkov.ringtestmvp.utils.photo.PhotoLoader
import kotlinx.android.synthetic.main.item_feed.view.*
import java.util.concurrent.TimeUnit

class FeedAdapter(private val photoLoader: PhotoLoader,
                  private val clickListener: (ImageView, String) -> Unit) :
    RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    private val feed: MutableList<FeedEntry> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_feed, parent, false)
        return FeedViewHolder(view)
    }

    override fun getItemCount(): Int = feed.size


    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(feed[position])
    }

    fun addItems(items: List<FeedEntry>) {
        feed.addAll(items)
        notifyDataSetChanged()
    }

    inner class FeedViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(entry: FeedEntry) = with(entry) {
            val hoursAgo = TimeUnit.MILLISECONDS.toHours(System.currentTimeMillis() - created).toInt()
            view.infoTv.text =
                    view.context.resources.getQuantityString(R.plurals.entry_info, hoursAgo, author, hoursAgo)
            view.contentTv.text = title
            view.commentsNumberTv.text =
                    view.context.resources.getQuantityString(R.plurals.comments_number, comments, comments)
            if (thumbnail == null) {
                view.image.visibility = View.GONE
            } else {
                view.image.visibility = View.VISIBLE
                photoLoader.loadPhoto(thumbnail, view.image)
                view.image.setOnClickListener {
                    clickListener(view.image, thumbnail)
                }
            }
            view.image.setOnClickListener {
                imageUrl?.let { clickListener(view.image, imageUrl) }
            }
        }
    }
}


