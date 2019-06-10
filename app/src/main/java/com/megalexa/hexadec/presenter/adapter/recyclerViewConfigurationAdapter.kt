package com.megalexa.hexadec.presenter.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.megalexa.hexadec.R
import com.megalexa.hexadec.utils.FeedRssRow
import com.megalexa.hexadec.utils.RowType
import com.megalexa.hexadec.utils.TextRow


class recyclerViewConfigurationAdapter(private val rows: List<RowType>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    interface RowType
    class TextRow(val nomeT: String, val positionTW: String, val textM: String) : RowType
    class FeedRssRow(val nomeF: String, val positionFW: String, val feedType: String, val feedUrl: String) : RowType

    companion object {
        private const val TYPE_TEXT = 0
        private const val TYPE_FEED = 1

    }

    class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val positionView: TextView = itemView.findViewById(R.id.textViewTextConfPosition)
        val nameView: TextView = itemView.findViewById(R.id.textViewTextConfName)
        val confTextView: TextView = itemView.findViewById(R.id.editTextConfText)
    }
    class FeedRssViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val positionView: TextView = itemView.findViewById(R.id.textViewFeedConfPosition)
        val nameView: TextView = itemView.findViewById(R.id.textViewFeedConfName)
        val typeView: TextView = itemView.findViewById(R.id.textViewFeedConfType)
        val confUrlView: TextView = itemView.findViewById(R.id.editTextConfFeedurl)
    }
    override fun getItemCount() = rows.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        TYPE_TEXT-> TextViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.text_configuration_item, parent, false))
        TYPE_FEED -> FeedRssViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.feedrss_configuration_item, parent, false))

        else -> throw IllegalArgumentException()
    }
    override fun getItemViewType(position: Int): Int =
        when (rows[position]) {
            is TextRow -> TYPE_TEXT
            is FeedRssRow -> TYPE_FEED
            else -> throw IllegalArgumentException()
        }

    private fun onBindText(holder: RecyclerView.ViewHolder, row: TextRow) {
        val TextRow = holder as TextViewHolder
        TextRow.positionView.text = row.positionTW
        TextRow.nameView.text = row.nomeT
        TextRow.confTextView.text = row.textM
    }
    private fun onBindFeed(holder: RecyclerView.ViewHolder, row: FeedRssRow) {
        val FeedRow = holder as FeedRssViewHolder
        FeedRow.positionView.text = row.positionFW
        FeedRow.nameView.text = row.nomeF
        FeedRow.typeView.text = row.feedType
        FeedRow.confUrlView.text = row.feedUrl
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        when (holder.itemViewType) {
            TYPE_TEXT -> onBindText(holder, rows[position] as recyclerViewConfigurationAdapter.TextRow)
            TYPE_FEED -> onBindFeed(holder, rows[position] as recyclerViewConfigurationAdapter.FeedRssRow)
            else -> throw IllegalArgumentException()
        }
}