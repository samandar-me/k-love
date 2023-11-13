package network

import de.jensklingenberg.ktorfit.http.*
import model.LoveResponse


interface NetworkService {
    @Headers("Content-Type: application/json")
    @GET("random")
    suspend fun getRandomLove(): LoveResponse
}
