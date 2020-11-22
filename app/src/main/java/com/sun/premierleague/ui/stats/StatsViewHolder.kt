package com.sun.premierleague.ui.stats

import android.view.View
import com.sun.premierleague.R
import com.sun.premierleague.base.BaseViewHolder
import com.sun.premierleague.data.model.StatItem
import com.sun.premierleague.utils.loadImage
import kotlinx.android.synthetic.main.item_recyclerview_stats.view.*

class StatsViewHolder(private val itemView: View) : BaseViewHolder<StatItem>(itemView) {
    override fun onBind(item: StatItem) {
        itemView.run {
            textStt.text = item.overallLeaguePosition
            imageTeam.loadImage(item.teamBadge)
            textNameTeam.text = item.teamName
            textTitleNumberMatch.text = item.overallLeaguePayed
            textTitleWin.text = item.overallLeagueW
            textTitleDraw.text = item.overallLeagueD
            textTitleLose.text = item.overallLeagueL
            textTitleGoalDiff.text = context.getString(
                R.string.text_goal_difference,
                item.overallLeagueGf,
                item.overallLeagueGa
            )
            textTitlePoint.text = item.overallLeaguePts
        }
    }
}
