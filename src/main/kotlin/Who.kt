import com.google.gson.Gson
import org.jetbrains.ktor.application.Application
import org.jetbrains.ktor.application.install
import org.jetbrains.ktor.features.DefaultHeaders
import org.jetbrains.ktor.http.ContentType
import org.jetbrains.ktor.logging.CallLogging
import org.jetbrains.ktor.response.respondText
import org.jetbrains.ktor.routing.Routing
import org.jetbrains.ktor.routing.get

data class Who(val name: String, val planet: String)

fun Application.main() {
    install(DefaultHeaders)
    install(CallLogging)
    install(Routing) {
        get("/") {
            val doktor = Who("Doktor", "Gallifrey")
            val gson = Gson()
            val json = gson.toJson(doktor)
            call.respondText(json, ContentType.Application.Json)
        }
    }
}
