package les.kasa.android.restclientsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import les.kasa.android.restclientsample.databinding.ActivityMainBinding
import les.kasa.android.restclientsample.model.LogData

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        super.setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        getButton.setOnClickListener { viewModel.get("20200222"); }
        getAllButton.setOnClickListener { viewModel.getAll(); }
        postButton.setOnClickListener { viewModel.post(LogData("2020/02/22", 12, false)); }
        putButton.setOnClickListener { viewModel.put(LogData("2020/02/22", 11, true)); }
        deleteButton.setOnClickListener { viewModel.delete("20200223") }
    }
}
