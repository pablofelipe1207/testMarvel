package com.pfmiranda.testMarvel.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.pfmiranda.testMarvel.R
import com.pfmiranda.testMarvel.activity.adapter.CharacterAdapter
import com.pfmiranda.testMarvel.databinding.ActivityMainBinding
import com.pfmiranda.testMarvel.models.Characters
import com.pfmiranda.testMarvel.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel : MainViewModel by viewModel()

    private val observer = Observer<Characters?> {
        it?.let {
            binding.rvCharacters.adapter = CharacterAdapter(it.data.results)
            binding.rvCharacters.layoutManager = LinearLayoutManager(this)
        } ?: run{
            Toast.makeText(this@MainActivity, getText(R.string.action_error), Toast.LENGTH_SHORT).show()
        }
        binding.progressBar.visibility = View.GONE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.progressBar.visibility = View.VISIBLE
        mainViewModel.characters.observe(this,observer)
    }
}