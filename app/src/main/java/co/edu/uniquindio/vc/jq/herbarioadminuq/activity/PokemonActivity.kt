package co.edu.uniquindio.vc.jq.herbarioadminuq.activity


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import co.edu.uniquindio.vc.jq.herbarioadminuq.R
import co.edu.uniquindio.vc.jq.herbarioadminuq.fragment.DetalleDePokemonFragment
import co.edu.uniquindio.vc.jq.herbarioadminuq.fragment.ListaDePokemonFragment
import co.edu.uniquindio.vc.jq.herbarioadminuq.util.AdaptadorDePokemones
import co.edu.uniquindio.vc.jq.herbarioadminuq.util.cambiarIdioma
import co.edu.uniquindio.vc.jq.herbarioadminuq.vo.Pokemon

class PokemonActivity : AppCompatActivity(), ListaDePokemonFragment.OnPokemonSeleccionadoListener {


    var pokemones: ArrayList<Pokemon> = ArrayList()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cambiarIdioma(context = this)

        setContentView(R.layout.activity_pokemon)

        pokemones = ArrayList()
        pokemones.add(Pokemon("Picachu", "Elétrico"))
        pokemones.add(Pokemon("Charmander", "Fuego"))
        pokemones.add(Pokemon("Bulbasaur", "Planta"))
        pokemones.add(Pokemon("Squirtle", "Agua"))
        pokemones.add(Pokemon("Caterpie", "Bicho"))
        pokemones.add(Pokemon("Weedle", "Bicho"))
        pokemones.add(Pokemon("Pidgey", "Volador"))
        pokemones.add(Pokemon("Rattata", "Campo"))
        pokemones.add(Pokemon("Vulpix", "Campo"))


        val fragmentLista = supportFragmentManager.findFragmentById(R.id.fragmentoListaPokemon) as ListaDePokemonFragment
        fragmentLista.pokemones = pokemones

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onPokemonSeleccionado(pos: Int) {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentoDetallePokemon)

        if (fragment != null) {
            (fragment as DetalleDePokemonFragment).darDetalle(pokemones[pos])
        } else {

            val intent: Intent = Intent(this, DetalleDePokemonActivity::class.java)
            intent . putExtra ("pok", pokemones[pos])
            startActivity(intent)
        }
    }

}

