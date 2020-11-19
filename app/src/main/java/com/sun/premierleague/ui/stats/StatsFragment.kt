package com.sun.premierleague.ui.stats

import com.sun.premierleague.R
import com.sun.premierleague.base.BaseFragment
import com.sun.premierleague.data.model.StatItem
import com.sun.premierleague.ui.detail.DetailMatchActivity
import com.sun.premierleague.utils.RepositoryFactory
import com.sun.premierleague.utils.showToast
import kotlinx.android.synthetic.main.fragment_stats.*

class StatsFragment : BaseFragment(), StatsContact.View {

    private var presenter: StatsContact.Presenter? = null
    private var adapter = StatsAdapter()

    override val layoutResource: Int
        get() = R.layout.fragment_stats

    override fun initData() {
        initAdapter()
        initPresenter()
        presenter?.start()
    }

    private fun initAdapter() {
        recyclerStats.setHasFixedSize(true)
        recyclerStats.adapter = adapter.apply {
            onItemClick = { item ->
                context?.let {
                    startActivity(DetailMatchActivity.getIntent(it, item.teamId))
                }
            }
        }
    }

    private fun initPresenter() {
        val context = context ?: return
        val repository = RepositoryFactory.getRepository(context)
        presenter = StatsPresenter(this, repository)
    }

    override fun showStats(data: List<StatItem>) {
        adapter.replaceData(data)
    }

    override fun showError(error: String) {
        context?.showToast(error)
    }
}
