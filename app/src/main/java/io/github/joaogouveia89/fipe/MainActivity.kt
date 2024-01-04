package io.github.joaogouveia89.fipe

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import io.github.joaogouveia89.fipe.room.DATABASE_NAME
import io.github.joaogouveia89.fipe.room.FipeLocalDb
import io.github.joaogouveia89.fipe.room.entities.Brand
import io.github.joaogouveia89.fipe.room.entities.BrandModel
import io.github.joaogouveia89.fipe.room.entities.Car
import io.github.joaogouveia89.fipe.room.entities.ModelYear

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(
                R.id.brandListFragment
            ),
            fallbackOnNavigateUpListener = ::onSupportNavigateUp
        )
        findViewById<Toolbar>(R.id.toolbar).apply {
            setSupportActionBar(this)
            setupActionBarWithNavController(navController)
            this.setupWithNavController(navController)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}