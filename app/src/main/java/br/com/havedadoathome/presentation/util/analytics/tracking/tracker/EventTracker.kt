package br.com.havedadoathome.presentation.util.analytics.tracking.tracker

import br.com.havedadoathome.presentation.util.analytics.tracking.event.base.Event

interface EventTracker {

    fun track(event: Event)
}
