package com.sun.premierleague.ui.match

import com.sun.premierleague.R
import com.sun.premierleague.base.BaseFragment
import com.sun.premierleague.data.model.MatchItem
import com.sun.premierleague.utils.RepositoryUtil
import com.sun.premierleague.utils.showToast
import kotlinx.android.synthetic.main.fragment_match.*

class MatchFragment : BaseFragment(), MatchContract.View {

    private var presenter: MatchPresenter? = null
    private val adapter = MatchAdapter()

    override val layoutResource: Int
        get() = R.layout.fragment_match

    override fun initData() {
        initAdapter()
        initPresenter()
        presenter?.start()
    }

    private fun initAdapter() {
        recyclerMatches.adapter = adapter
    }

    private fun initPresenter() {
        val context = context ?: return
        val repository = RepositoryUtil.getRepository(context)
        presenter = MatchPresenter(this, repository)
    }

    override fun showMatch(matches: List<MatchItem>) {
        adapter.replaceData(matches)
        recyclerMatches.scrollToPosition(0)
    }

    override fun showError(error: String) {
        context?.showToast(error, 1)
    }
}
