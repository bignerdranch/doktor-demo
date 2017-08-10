import org.jetbrains.ktor.application.Application
import org.jetbrains.ktor.application.install
import org.jetbrains.ktor.features.CallLogging
import org.jetbrains.ktor.features.DefaultHeaders
import org.jetbrains.ktor.gson.GsonSupport
import org.jetbrains.ktor.response.respond
import org.jetbrains.ktor.routing.Routing
import org.jetbrains.ktor.routing.get

data class Who(val name: String, val planet: String)

fun Application.main() {
    install(DefaultHeaders)
    install(CallLogging)
    install(GsonSupport)
    install(Routing) {
        get("/") {
            val doktor = Who("Doktor", "Gallifrey")
            call.respond(doktor)
        }
    }
}
