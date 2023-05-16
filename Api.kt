import java.net.HttpURLConnection
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main() {
    val apiUrl = "https://rickandmortyapi.com/api/character/2"
    val httpClient = HttpClient.newBuilder().build()

    val request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build()

    val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())

    if (response.statusCode() == HttpURLConnection.HTTP_OK) {
        println(response.body())
    } else {
        println("Error")
    }
}