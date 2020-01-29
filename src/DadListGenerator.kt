import java.time.format.DateTimeFormatter
import java.time.LocalDateTime
import java.util.Random
import java.util.TimeZone

class Constants {
    companion object {
        val CENTRAL_EUROPEAN_TIME_ZONE_ID = "CET"
        val DATE_TIME_FORMATTER_PATTERN = "dd.MM.yyyy HH:mm:ss"
        val WORKING_DAYS = listOf(
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday"
        )
    }
}

val AVAILABLE_DUDES by lazy {
    listOf(
        "Dude 1",
        "Dude 2",
        "Dude 3",
        "Dude 4",
        "Dude 5",
        "Dude 6",
        "Dude 7"
    )
}

private fun getCurrentDateTime() = LocalDateTime
    .now(TimeZone.getTimeZone(Constants.CENTRAL_EUROPEAN_TIME_ZONE_ID).toZoneId())
    .format(DateTimeFormatter.ofPattern(Constants.DATE_TIME_FORMATTER_PATTERN))

fun main() {

    AVAILABLE_DUDES
        .shuffled(Random())
        .take(Constants.WORKING_DAYS.size)
        .forEachIndexed { dayNumber, dude ->
            println("${Constants.WORKING_DAYS[dayNumber]}: $dude")
        }

    println("\nGenerated on ${getCurrentDateTime()}")
}