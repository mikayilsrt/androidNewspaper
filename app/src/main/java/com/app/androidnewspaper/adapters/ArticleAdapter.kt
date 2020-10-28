package com.app.androidnewspaper.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.androidnewspaper.R
import com.app.androidnewspaper.datas.models.ArticleModel
import com.app.androidnewspaper.views.article.ArticleActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import kotlinx.serialization.json.Json

class ArticleAdapter(
        var articleList: List<ArticleModel> = listOf()
) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)

        return ViewHolder(row)
    }

    override fun getItemCount(): Int {
        return this.articleList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(articleList[position])
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(articleModel: ArticleModel) {
            val imageView = view.findViewById<ImageView>(R.id._articleMediaCover)
            val factory: DrawableCrossFadeFactory = DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()

            view.findViewById<TextView>(R.id._title).text = articleModel.title.toString()
            view.findViewById<TextView>(R.id._abstract).text = articleModel.abstract.toString()

            if(articleModel.media.isNotEmpty() && articleModel.media.first().mediaMetadata.isNotEmpty()) {
                Glide
                    .with(view.context)
                    .load(articleModel.media.first().mediaMetadata[1].url.toString())
                    .transition(withCrossFade(factory))
                    .transform(RoundedCorners(17))
                    .into(imageView)
            }

            view.setOnClickListener { ArticleActivity.start(view.context, Json.stringify(ArticleModel.serializer(), articleModel)) }
        }
    }
}