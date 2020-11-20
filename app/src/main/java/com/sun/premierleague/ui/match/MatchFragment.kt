package com.sun.premierleague.ui.match

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.sun.premierleague.R
import com.sun.premierleague.base.BaseFragment
import com.sun.premierleague.data.model.MatchItem
import com.sun.premierleague.utils.RepositoryFactory
import com.sun.premierleague.utils.TimeUtils
import com.sun.premierleague.utils.showToast
import kotlinx.android.synthetic.main.fragment_match.*

class MatchFragment : BaseFragment(), MatchContract.View {

    private var presenter: MatchPresenter? = null
    private val adapter = MatchAdapter()

    override val layoutResource: Int
        get() = R.layout.fragment_match

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_action_bar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

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
        val repository = RepositoryFactory.getRepository(context)
        presenter = MatchPresenter(this, repository)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        context?.let {
            TimeUtils.getDatePickerDialog(it) { time ->
                presenter?.getMatchInformation(
                    time
                )
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showMatch(matches: List<MatchItem>) {
        adapter.replaceData(matches)
        recyclerMatches.scrollToPosition(0)
    }

    override fun showError(error: String) {
        context?.showToast(error, 1)
    }
}
