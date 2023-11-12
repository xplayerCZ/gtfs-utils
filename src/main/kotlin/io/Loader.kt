package io

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.csv.Csv
import kotlinx.serialization.decodeFromString
import model.GTFSCollection
import java.io.File

object Loader {
    @OptIn(ExperimentalSerializationApi::class)
    private val csv = Csv { hasHeaderRecord = true }

    fun loadGTFSFiles(folder: File): GTFSCollection {
        val accumulator = GTFSCollection.Builder()
        val files = folder.listFiles()

        require(folder.exists()) { "Folder ${folder.name} doesn't exist" }
        require(folder.isDirectory) { "File ${folder.name} is not a folder" }
        require(files != null) { "Folder ${folder.name} is empty" }

        files.forEach { file ->
            when (file.name) {
                "agency.txt" -> accumulator.addAgencies(parseFile(file))
                "calendar.txt" -> accumulator.addCalendars(parseFile(file))
                "calendar_dates.txt" -> accumulator.addCalendarDates(parseFile(file))
                "routes.txt" -> accumulator.addRoutes(parseFile(file))
                "stop_times.txt" -> accumulator.addStopTimes(parseFile(file))
                "stops.txt" -> accumulator.addStops(parseFile(file))
                "trips.txt" -> accumulator.addTrips(parseFile(file))
                else -> println("Unknown file: ${file.name}")
            }
        }

        return accumulator.build()
    }

    @OptIn(ExperimentalSerializationApi::class)
    private inline fun <reified T> parseFile(file: File): T {
        require(file.isFile) { "Folder ${file.name} is not a file" }
        return csv.decodeFromString<T>(file.readText())
    }
}