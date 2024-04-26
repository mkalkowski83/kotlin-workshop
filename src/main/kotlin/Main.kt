import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

suspend fun log(msg: String) {
    val name = coroutineContext[CoroutineName]?.name
    println("[$name] $msg")
}

fun CoroutineScope.slog(msg: String) {
    val name = coroutineContext[CoroutineName]?.name
    println("[$name] $msg")
}

suspend fun main() = withContext(CoroutineName("Outer")) {
    log("Starting") // [___] Starting
    launch(CoroutineName("Inner")) {
        slog("A") // [___] A
        launch {
            log("B") // [___] B
        }
    }
    launch {
        slog("C") // [___] C
    }
    GlobalScope.launch {
        log("D") // [___] D
    }
    slog("Ending") // [___] Ending
}
