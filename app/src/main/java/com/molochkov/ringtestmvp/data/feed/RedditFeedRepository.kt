package com.molochkov.ringtestmvp.data.feed

import io.reactivex.Single

class RedditFeedRepository : FeedRepository {

    override fun getFeed(): Single<List<FeedEntry>> {
        return Single.just(listOf(first, first, first))
    }

    private val first =
        FeedEntry("Plan S, the radical proposal to mandate open access to science papers, scheduled to take effect on 1 January 2020, has drawn support from many scientists, who welcome a shake-up of a publishing system that can generate large profits while keeping taxpayer-funded research results behind paywalls.",
            "Futurology",
            1546608949380L,
            "https://www.sciencemag.org/sites/default/files/styles/inline__699w__no_aspect/public/ca_0104NID_PlanS_Illustration_online.jpg",
            2)
}