package model

import model.gtfs.Agency
import model.gtfs.Calendar
import model.gtfs.CalendarDate
import model.gtfs.Route
import model.gtfs.Stop
import model.gtfs.StopTime
import model.gtfs.Trip

data class GTFSCollection(
    val agencies: List<Agency>,
    val stops: List<Stop>,
    val routes: List<Route>,
    val trips: List<Trip>,
    val stopTimes: List<StopTime>,
    val calendar: List<Calendar>,
    val calendarDates: List<CalendarDate>,
) {
    class Builder {
        private val agencies: MutableList<Agency> = mutableListOf()
        private val stops: MutableList<Stop> = mutableListOf()
        private val routes: MutableList<Route> = mutableListOf()
        private val trips: MutableList<Trip> = mutableListOf()
        private val stopTimes: MutableList<StopTime> = mutableListOf()
        private val calendar: MutableList<Calendar> = mutableListOf()
        private val calendarDates: MutableList<CalendarDate> = mutableListOf()

        fun addAgency(item: Agency) = apply { agencies.add(item) }
        fun addAgencies(items: List<Agency>) = apply { agencies.addAll(items) }
        fun addStop(item: Stop) = apply { stops.add(item) }
        fun addStops(items: List<Stop>) = apply { stops.addAll(items) }
        fun addRoute(item: Route) = apply { routes.add(item) }
        fun addRoutes(items: List<Route>) = apply { routes.addAll(items) }
        fun addTrip(item: Trip) = apply { trips.add(item) }
        fun addTrips(items: List<Trip>) = apply { trips.addAll(items) }
        fun addStopTime(item: StopTime) = apply { stopTimes.add(item) }
        fun addStopTimes(items: List<StopTime>) = apply { stopTimes.addAll(items) }
        fun addCalendar(item: Calendar) = apply { calendar.add(item) }
        fun addCalendars(items: List<Calendar>) = apply { calendar.addAll(items) }
        fun addCalendarDate(item: CalendarDate) = apply { calendarDates.add(item) }
        fun addCalendarDates(items: List<CalendarDate>) = apply { calendarDates.addAll(items) }

        fun build(): GTFSCollection {
            require(agencies.isNotEmpty()) { "Agencies must not be empty" }
            require(stops.isNotEmpty()) { "Stops must not be empty" }
            require(routes.isNotEmpty()) { "Routes must not be empty" }
            require(trips.isNotEmpty()) { "Trips must not be empty" }
            require(stopTimes.isNotEmpty()) { "StopTimes must not be empty" }
            require(calendar.isNotEmpty() || calendarDates.isNotEmpty()) { "Calendar or CalendarDates must not be empty" }

            require(agencies.distinctBy { it.id }.size == agencies.size) { "Agencies must be unique" }
            require(stops.distinctBy { it.id }.size == stops.size) { "Stops must be unique" }
            require(routes.distinctBy { it.id }.size == routes.size) { "Routes must be unique" }
            require(trips.distinctBy { it.id }.size == trips.size) { "Trips must be unique" }

            return GTFSCollection(
                agencies = agencies,
                stops = stops,
                routes = routes,
                trips = trips,
                stopTimes = stopTimes,
                calendar = calendar,
                calendarDates = calendarDates,
            )
        }
    }
}