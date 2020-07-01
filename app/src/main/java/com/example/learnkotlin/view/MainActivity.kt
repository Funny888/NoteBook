package com.example.learnkotlin.view
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.learnkotlin.R
import com.example.learnkotlin.databinding.ActivityMainBinding
import com.example.learnkotlin.model.database.PersonTable
import com.example.learnkotlin.viewModel.CommonViewModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
   private lateinit var mNavController: NavController
   private lateinit var mModelView: CommonViewModule

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var dataBinding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        dataBinding.lifecycleOwner = this
        mModelView = ViewModelProviders.of(this).get(CommonViewModule::class.java)
        mNavController = Navigation.findNavController(this, R.id.nav_frag)
        pushModel(mModelView)

    }

    companion object {
        private var view: CommonViewModule? = null
        private fun pushModel(model: CommonViewModule) {
            view = model
        }
        fun getModel() = view
    }
}
