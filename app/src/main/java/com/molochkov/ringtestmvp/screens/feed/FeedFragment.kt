package com.molochkov.ringtestmvp.screens.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.molochkov.ringtestmvp.R
import com.molochkov.ringtestmvp.core.base.BaseFragment
import com.molochkov.ringtestmvp.data.feed.FeedEntry
import com.molochkov.ringtestmvp.screens.feed.di.DaggerFeedComponent
import com.molochkov.ringtestmvp.screens.feed.di.FeedModule
import com.molochkov.ringtestmvp.screens.feed.ui.FeedAdapter
import com.molochkov.ringtestmvp.utils.photo.PhotoLoader
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class FeedFragment : BaseFragment(), FeedView {

    companion object {

        private const val SCROLL_DIRECTION = -1
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
        presenter.onAttachView(this)
        setUpList()
        presenter.getFeed()
    }

    override fun onDestroyView() {
        presenter.onDetachView()
        super.onDestroyView()
    }

    override fun onFeedLoaded(feed: List<FeedEntry>) {
        adapter.addItems(feed)
    }

    override fun onLoadError() {
        //TODO
    }

    private fun setUpList() {
        adapter = FeedAdapter(photoLoader) { view, url ->
            presenter.showImage(view, url)
        }
        listRv.layoutManager = LinearLayoutManager(activity)
        listRv.adapter = adapter
        listRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(SCROLL_DIRECTION)) {
                    //TODO
                }
            }
        })
    }
}