package apps.cz200dev.technictestapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.navigation.NavController
import androidx.navigation.Navigation
import apps.cz200dev.technictestapp.R
import apps.cz200dev.technictestapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Add the navigation at the controller
        navController =  Navigation.findNavController(this, R.id.nav_host_fragment)

    }
}