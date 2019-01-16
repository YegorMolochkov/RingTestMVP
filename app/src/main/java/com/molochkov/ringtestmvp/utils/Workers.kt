package com.molochkov.ringtestmvp.utils

import io.reactivex.Scheduler

data class Workers(val subscribe: Scheduler, val observe: Scheduler)