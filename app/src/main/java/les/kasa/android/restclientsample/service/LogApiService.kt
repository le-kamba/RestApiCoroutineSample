package les.kasa.android.restclientsample.service

import les.kasa.android.restclientsample.model.LogData
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface LogApiService {

    @Headers("Accept:application/json, Content-Type:application/json")
    @GET("/logs")
    fun getAll(): Call<ResponseBody>

    @Headers("Content-Type: application/json")
    @GET("/logs/{date}")
    fun get(@Path("date") date: String): Call<ResponseBody>

    @Headers("Accept:application/json, Content-Type: application/json")
    @POST("/logs")
    fun post(@Body log: LogData): Call<ResponseBody>

    @Headers("Accept:application/json, Content-Type: application/json")
    @PUT("/logs")
    fun put(@Body log: LogData): Call<ResponseBody>

    @Headers("Accept:application/json, Content-Type: application/json")
    @DELETE("/logs/{date}")
    fun delete(@Path("date") date: String): Call<ResponseBody>
}
