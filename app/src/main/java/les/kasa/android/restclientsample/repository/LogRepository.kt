package les.kasa.android.restclientsample.repository

import androidx.annotation.WorkerThread
import les.kasa.android.restclientsample.model.LogData
import les.kasa.android.restclientsample.service.LogApiService

/**
 * ログデータ取得・保存を管理するリポジトリクラス
 */
class LogRepository(private val logApi: LogApiService) {

    @WorkerThread
    suspend fun insert(log: LogData): String {
        val response = logApi.post(log).execute()
        if (response.isSuccessful) {
            return "SUCCESS!\n" +
                    "\n$response.headers().toString()\n${response.body()?.string()}"
        }
        return "ERROR!\n" +
                "\n$response.headers().toString()\n${response.errorBody()?.string()}"
    }

    @WorkerThread
    suspend fun update(log: LogData): String {
        val response = logApi.put(log).execute()
        if (response.isSuccessful) {
            return "SUCCESS!\n" +
                    "\n$response.headers().toString()\n${response.body()?.string()}"
        }
        return "ERROR!\n" +
                "\n$response.headers().toString()\n${response.errorBody()?.string()}"
    }

    /**
     * [date] "yyyy/MM/dd"
     */
    @WorkerThread
    suspend fun delete(date: String): String {
        val response = logApi.delete(date).execute()
        if (response.isSuccessful) {
            return "SUCCESS!\n" +
                    "\n$response.headers().toString()\n${response.body()?.string()}"
        }
        return "ERROR!\n" +
                "\n$response.headers().toString()\n${response.errorBody()?.string()}"
    }

    @WorkerThread
    suspend fun getAll(): String {
        val response = logApi.getAll().execute()
        if (response.isSuccessful) {
            return "SUCCESS!\n" +
                    "\n$response.headers().toString()\n${response.body()?.string()}"
        }
        return "ERROR!\n" +
                "\n$response.headers().toString()\n${response.errorBody()?.string()}"
    }

    /**
     * [date] "yyyy/MM/dd"
     */
    @WorkerThread
    suspend fun get(date: String): String {
        val response = logApi.get(date).execute()
        if (response.isSuccessful) {
            return "SUCCESS!\n" +
                    "\n$response.headers().toString()\n${response.body()?.string()}"
        }
        return "ERROR!\n" +
                "\n$response.headers().toString()\n${response.errorBody()?.string()}"
    }
}