package les.kasa.android.restclientsample.repository

import androidx.annotation.WorkerThread
import les.kasa.android.restclientsample.model.LogData

/**
 * ログデータ取得・保存を管理するリポジトリクラス
 */
class LogRepository {

    @WorkerThread
    suspend fun insert(log: LogData): String {
        return "insert";
    }

    @WorkerThread
    suspend fun update(log: LogData): String {
        return "update";
    }

    /**
     * [date] "yyyy/MM/dd"
     */
    @WorkerThread
    suspend fun delete(date: String): String {
        return "delete";
    }

    @WorkerThread
    suspend fun getAll(): String {
        return "getAll";
    }

    /**
     * [date] "yyyy/MM/dd"
     */
    @WorkerThread
    suspend fun get(date: String): String {
        return "get $date";
    }
}