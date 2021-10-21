val onlineSecondsAgo = 9000
fun main() {

    getOnlineTimeAgo()
}

fun getOnlineTimeAgo() {

    val sharingTime = when (onlineSecondsAgo) {
        in 0..60 -> "Был(а) в сети только что"
        in 61..3600 -> "Был(а) в сети ${secondsInMinuts(onlineSecondsAgo)} ${textMinuts(secondsInMinuts(onlineSecondsAgo))} назад"
        in 3601..86400 -> "Был(а) в сети ${secondsInHour(onlineSecondsAgo)} ${textHour(secondsInHour(onlineSecondsAgo))} назад"
        in 86401..172800 -> "Был(а) в сети сегодня"
        in 172801..259200 -> "Был(а) в сети вчера"
        else -> "Был(а) в сети давно"
    }
    println(sharingTime)
}

fun secondsInMinuts(seconds: Int): Int {
    val secondsTransformInMinuts = seconds / 60
    return secondsTransformInMinuts
}

fun secondsInHour(seconds: Int): Int {
    val secondsTransformInHour = ((seconds / 60) / 60)
    return secondsTransformInHour
}

fun textMinuts(minuts: Int): String {
    val outputLastInteger = secondsInMinuts(onlineSecondsAgo) % 10
    val output2Digit = secondsInMinuts(onlineSecondsAgo) % 100
    return if (outputLastInteger == 1 && output2Digit != 11) {
        "минуту"
    } else if (output2Digit < 5 || output2Digit > 20) {
        "минуты"
    } else {
        "минут"
    }
}

fun textHour(hour: Int): String {
    val outputLastInteger = secondsInHour(onlineSecondsAgo) % 10
    val output2Digit = secondsInHour(onlineSecondsAgo) % 100
    return if (outputLastInteger == 1 && output2Digit != 11) {
        "час"
    } else if (output2Digit < 5 || output2Digit > 20) {
        "часа"
    } else {
        "часов"
    }
}