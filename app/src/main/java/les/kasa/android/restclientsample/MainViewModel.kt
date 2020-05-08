package les.kasa.android.restclientsample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import les.kasa.android.restclientsample.model.LogData
import les.kasa.android.restclientsample.repository.LogRepository

/**
 * MainActivity用のViewModelクラス
 */
class MainViewModel(private val _repository: LogRepository, app: Application) :
    AndroidViewModel(app) {
    private var _restResultText = MutableLiveData<String>()

    val restResultText: LiveData<String> = _restResultText

    init {
        _restResultText.value = "TAP BUTTONS TO CALL API."
    }

    // GET from /logs
    fun getAll() = viewModelScope.launch(Dispatchers.IO) {
        val result = _repository.getAll()
        _restResultText.postValue(result)
    }

    // GET from/logs/{date}
    fun get(date: String) = viewModelScope.launch(Dispatchers.IO) {
        val result = _repository.get(date)
        _restResultText.postValue(result)
    }

    // POST to /logs
    fun post(log: LogData) = viewModelScope.launch(Dispatchers.IO) {
        val result = _repository.insert(log)
        _restResultText.postValue(result)
    }

    // PUT to /logs
    fun put(log: LogData) = viewModelScope.launch(Dispatchers.IO) {
        val result = _repository.update(log)
        _restResultText.postValue(result)
    }

    // DELETE to /logs/{date}
    fun delete(date: String) = viewModelScope.launch(Dispatchers.IO) {
        val result = _repository.delete(date)
        _restResultText.postValue(result)
    }
}