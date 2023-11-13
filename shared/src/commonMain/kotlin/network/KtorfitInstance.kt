package network

import de.jensklingenberg.ktorfit.converter.builtin.CallConverterFactory
import de.jensklingenberg.ktorfit.converter.builtin.FlowConverterFactory
import de.jensklingenberg.ktorfit.ktorfit
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object KtorfitInstance {
    private val ktorFit = ktorfit {
        baseUrl("http://10.10.12.40:8080/")
        httpClient(HttpClient {
            install(ContentNegotiation) {
                json(Json { isLenient = true; ignoreUnknownKeys = true })
            }
        })
        converterFactories(
            FlowConverterFactory(),
            CallConverterFactory()
        )
    }
    fun getNetworkService() = ktorFit.create<NetworkService>()
}

