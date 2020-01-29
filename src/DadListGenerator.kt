import java.time.format.DateTimeFormatter
import java.time.LocalDateTime
import java.util.Random
import java.util.TimeZone

val AVAILABLE_DUDES = listOf(
    "Dude 1",
    "Dude 2",
    "Dude 3",
    "Dude 4",
    "Dude 5",
    "Dude 6",
    "Dude 7"
)

val WORKING_DAYS = listOf(
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday"
)

private fun getCurrentDateTime() = LocalDateTime
    .now(TimeZone.getTimeZone("CET").toZoneId())
    .format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))

fun main() {

    AVAILABLE_DUDES
        .shuffled(Random())
        .take(WORKING_DAYS.size)
        .forEachIndexed { dayNumber, dude ->
            println("${WORKING_DAYS[dayNumber]}: $dude")
        }

    println("\nGenerated on ${getCurrentDateTime()}")
}