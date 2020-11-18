package com.sun.premierleague.ui.match

import android.view.View
import com.sun.premierleague.R
import com.sun.premierleague.base.BaseViewHolder
import com.sun.premierleague.base.OnItemClick
import com.sun.premierleague.data.model.MatchItem
import com.sun.premierleague.utils.loadImage
import kotlinx.android.synthetic.main.item_recyclerview_match.view.*

class MatchViewHolder(private val itemView: View) :
    OnItemClick<MatchItem>,
    BaseViewHolder<MatchItem>(itemView) {
    private var itemData: MatchItem? = null

    override fun onBind(matchItem: MatchItem) {
        itemData = matchItem
        itemView.run {
            textDate.text = matchItem.matchDate
            textScore.text = context.getString(
                R.string.text_score,
                matchItem.matchHomeTeamScore,
                matchItem.matchAwayTeamScore
            )
            textTime.text = matchItem.matchTime
            val boo = matchItem.matchStatus.isEmpty()
            textTime.visibility = getVisibility(boo)
            imageRing.visibility = getVisibility(boo)
            textScore.visibility = getVisibility(!boo)
            textHomeTeam.text = matchItem.matchHomeTeamName
            textAwayTeam.text = matchItem.matchAwayTeamName
            imageHomeTeam.loadImage(matchItem.teamHomeBadge)
            imageAwayTeam.loadImage(matchItem.teamAwayBadge)
        }
    }

    override fun onClickItem(matchItem: MatchItem) {
        itemData = matchItem
        itemView.setOnClickListener {
            itemData?.let {
                onClickItem(it)
            }
        }
    }

    private fun getVisibility(isShow: Boolean) = if (isShow) View.VISIBLE else View.INVISIBLE
}
