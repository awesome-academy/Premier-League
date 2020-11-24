package com.sun.premierleague.ui.team

import android.view.View
import com.sun.premierleague.R
import com.sun.premierleague.base.BaseViewHolder
import com.sun.premierleague.data.model.Player
import kotlinx.android.synthetic.main.item_recyclerview_player.view.*

class TeamViewHolder(private val itemView: View) : BaseViewHolder<Player>(itemView) {

    override fun onBind(player: Player) {
        itemView.run {
            textNamePlayer.text = player.playerName
            textInfoPlayer.text = context.getString(
                R.string.text_info_player,
                player.playerNumber,
                player.playerAge,
                player.playerCountry
            )
            textMatchPlayed.text = player.playerMatchPlayed
            textPlayerGoal.text = player.playerGoals
            textPlayerYellowCard.text = player.playerYellowCards
            textPlayerRedCard.text = player.playerRedCards
        }
    }
}
