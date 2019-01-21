package com.molochkov.ringtestmvp.screens.feed.ui

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.molochkov.ringtestmvp.R
import com.molochkov.ringtestmvp.core.base.BaseFragment
import com.molochkov.ringtestmvp.screens.feed.data.FeedEntry
import com.molochkov.ringtestmvp.screens.feed.di.DaggerFeedComponent
import com.molochkov.ringtestmvp.screens.feed.di.FeedModule
import com.molochkov.ringtestmvp.screens.feed.domain.FeedPresenter
import com.molochkov.ringtestmvp.utils.photo.PhotoLoader
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class FeedFragment : BaseFragment(), FeedView {

    companion object {

        private const val SCROLL_DIRECTION = 1
        private const val LIST_STATE_KEY = "LIST_STATE_KEY"
        fun newInstance() = FeedFragment()
    }

    private val component by lazy {
        DaggerFeedComponent.builder()
            .feedModule(FeedModule())
            .mainActivityComponent(mainActivity.activityComponent)
            .build()
    }
    @Inject
    lateinit var presenter: FeedPresenter
    @Inject
    lateinit var photoLoader: PhotoLoader
    private lateinit var adapter: FeedAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private var listState: Parcelable? = null
    private var alreadyLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpList()
        presenter.onAttachView(this)
        presenter.doOnStart()
        if (savedInstanceState == null && !alreadyLoaded) {
            alreadyLoaded = true
            presenter.loadMore()
        }
    }

    override fun onDestroyView() {
        presenter.onDetachView()
        super.onDestroyView()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(LIST_STATE_KEY, layoutManager.onSaveInstanceState())
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        savedInstanceState?.let {
            listState = it.getParcelable(LIST_STATE_KEY)
        }
    }

    override fun onFeedLoaded(feed: List<FeedEntry>) {
        adapter.addItems(feed)
        listState?.let { layoutManager.onRestoreInstanceState(it) }
    }

    override fun onLoadError() {
        //TODO
    }

    override fun showLoading() {
        super.showLoading()
        listState = layoutManager.onSaveInstanceState()
    }

    private fun setUpList() {
        adapter = FeedAdapter(photoLoader) { url ->
            listState = layoutManager.onSaveInstanceState()
            presenter.showImage(url)
        }
        layoutManager = LinearLayoutManager(activity)
        listRv.layoutManager = layoutManager
        listRv.adapter = adapter
        listRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(SCROLL_DIRECTION)) {
                    presenter.loadMore()
                }
            }
        })
    }
}