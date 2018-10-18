package co.edu.uniquindio.vc.jq.herbarioadminuq.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.DialogFragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import co.edu.uniquindio.vc.jq.herbarioadminuq.R
import co.edu.uniquindio.vc.jq.herbarioadminuq.fragment.*
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
                // listar plantas sirve para Mostrar una lista de las plantas que han sido registradas y aprobadas previamente.

                loadListarPlantas(fragListarPlantas = ListaPlantasFragment())
            }
             // listar plantas pendientes sirve para Listar las plantas reportadas por el usuario: En esta opción el usuario ve todas las plantas que ha reportado y su estado actual (“aprobada”,
            //“rechazada”, “en estudio”).

            R.id.nav_listar_plantas_pendientes -> {

                loadListarPlantasPendientes(fragListarPlantasPendientes = ListarPlantasPendientesFragment())

            }

            // gestionar recolectores permite aceptar o rechazar a un solicitante

            R.id.nav_gestionar_recolectores -> {

                loadGestionarRecolectores(fragGestionarRecolectores = GestionarRecolectoresFragment())
            }
            R.id.nav_datos_cuenta -> {

                loadDatosCuenta(fragDatosCuenta = DatosCuentaFragment())

            }
            R.id.nav_salir -> {
                mostrarAgregarPokemon();

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }




    // funcion para llamar
    private fun loadListarPlantas(fragListarPlantas: ListaPlantasFragment) {
        val fm = supportFragmentManager.beginTransaction()
        fm.replace( R.id.frameLayout, fragListarPlantas)
        fm.commit()
    }


    private fun loadListarPlantasPendientes(fragListarPlantasPendientes: ListarPlantasPendientesFragment) {
        val fm = supportFragmentManager.beginTransaction()
        fm.replace( R.id.frameLayout, fragListarPlantasPendientes)
        fm.commit()
    }


    private fun loadGestionarRecolectores(fragGestionarRecolectores: GestionarRecolectoresFragment) {
        val fm = supportFragmentManager.beginTransaction()
        fm.replace( R.id.frameLayout, fragGestionarRecolectores)
        fm.commit()
    }


    private fun loadDatosCuenta(fragDatosCuenta: DatosCuentaFragment) {
        val fm = supportFragmentManager.beginTransaction()
        fm.replace( R.id.frameLayout, fragDatosCuenta)
        fm.commit()
    }



    private fun loadThird(frag3: ListarPlantasPendientesFragment) {
        val fm = supportFragmentManager.beginTransaction()
        fm.replace( R.id.frameLayout, frag3)
        fm.commit()
    }

    fun mostrarAgregarPokemon(){
        val agregarPokemon = AgregarPokemonFragment()
        agregarPokemon.setStyle(
            DialogFragment.STYLE_NORMAL,
            R.style.DialogoTitulo
        )

    }


}

