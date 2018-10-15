package co.edu.uniquindio.vc.jq.herbarioadminuq.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import co.edu.uniquindio.vc.jq.herbarioadminuq.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {


        // Aqui es donde ejecuta las funciones
        when (item.itemId) {
            R.id.nav_lista_plantas -> {
              loadFirst(frag1 = FirstFragment())
            }
            R.id.nav_ingrese_planta -> {
                loadSecond(frag2 = SecondFragment())

            }
            R.id.nav_listar_planta_ingresada -> {
                loadThird(frag3 = ThirdFragment())
            }
            R.id.nav_datos_cuenta -> {

            }
            R.id.nav_salir -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun loadFirst(frag1: FirstFragment) {
        val fm = supportFragmentManager.beginTransaction()
        fm.replace( R.id.frameLayout, frag1)
        fm.commit()
    }

    private fun loadSecond(frag2: SecondFragment) {
        val fm = supportFragmentManager.beginTransaction()
        fm.replace( R.id.frameLayout, frag2)
        fm.commit()
    }

    private fun loadThird(frag3: ThirdFragment) {
        val fm = supportFragmentManager.beginTransaction()
        fm.replace( R.id.frameLayout, frag3)
        fm.commit()
    }


}

