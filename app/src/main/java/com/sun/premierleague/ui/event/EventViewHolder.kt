package com.sun.premierleague.ui.event

import android.view.View
import androidx.core.view.isVisible
import com.sun.premierleague.base.BaseViewHolder
import com.sun.premierleague.data.model.DetailEvent
import com.sun.premierleague.data.model.Event
import com.sun.premierleague.utils.LineupConst
import kotlinx.android.synthetic.main.item_recyclerview_event.view.*

class EventViewHolder(private val itemView: View) : BaseViewHolder<DetailEvent>(itemView) {
    override fun onBind(item: DetailEvent) {
        itemView.run {
            textTimeLine.text = item.time
            if (item.isHome) {
                viewHomeHorizontal.isVisible = true
                when {
                    item.score.isNotEmpty() -> {
                        textHomeGoal.run {
                            isVisible = true
                            text = item.namePlayer
                        }
                    }
                    item.substitution.isNotEmpty() -> {
                        textHomeIn.run {
                            isVisible = true
                            text = item.substitution.split("|")[0]
                        }
                        textHomeOut.run {
                            isVisible = true
                            text = item.substitution.split("|")[1]
                        }
                    }
                    item.card.isNotEmpty() -> {
                        if (item.card == LineupConst.YELLOW_CARD) {
                            textHomeYellowCard.run {
                                isVisible = true
                                text = item.card
                            }
                        } else {
                            textHomeRedCard.run {
                                isVisible = true
                                text = item.card
                            }
                        }
                    }
                }
            } else {
                viewAwayHorizontal.isVisible = true
                when {
                    item.score.isNotEmpty() -> {
                        textAwayGoal.run {
                            isVisible = true
                            text = item.namePlayer
                        }
                    }
                    item.substitution.isNotEmpty() -> {
                        textAwayIn.run {
                            isVisible = true
                            text = item.substitution.split("|")[0]
                        }
                        textAwayOut.run {
                            isVisible = true
                            text = item.substitution.split("|")[1]
                        }
                    }
                    item.card.isNotEmpty() -> {
                        if (item.card == LineupConst.YELLOW_CARD) {
                            textAwayYellowCard.run {
                                isVisible = true
                                text = item.card
                            }
                        } else {
                            textAwayRedCard.run {
                                isVisible = true
                                text = item.card
                            }
                        }
                    }
                }
            }
        }
    }
}
