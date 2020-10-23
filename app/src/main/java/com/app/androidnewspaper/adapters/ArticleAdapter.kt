package com.app.androidnewspaper.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.androidnewspaper.R
import com.app.androidnewspaper.datas.models.ArticleModel

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
            view.findViewById<TextView>(R.id._title).text = articleModel.title.toString()
        }
    }
}