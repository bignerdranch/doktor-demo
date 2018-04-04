package bnr

import com.google.gson.Gson
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.GsonConverter
import io.ktor.gson.gson
import io.ktor.http.ContentType.Application.Json
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import java.text.DateFormat

data class Who(val name: String, val planet: String)

fun Application.main() {
    install(DefaultHeaders)
    install(CallLogging)
    install(ContentNegotiation) {
        gson {
            register(Json, GsonConverter())
            setDateFormat(DateFormat.LONG)
            setPrettyPrinting()
        }
    }
    install(Routing) {
        get("/") {
            val doktor = Who("Doktor", "Gallifrey")
            val gson = Gson()
            val json = gson.toJson(doktor)
            call.respondText(json, Json)
        }
    }
}
