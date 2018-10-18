package co.edu.uniquindio.vc.jq.herbarioadminuq.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.edu.uniquindio.vc.jq.herbarioadminuq.R
import co.edu.uniquindio.vc.jq.herbarioadminuq.fragment.DetalleDePokemonFragment
import co.edu.uniquindio.vc.jq.herbarioadminuq.vo.Pokemon


class DetalleDePokemonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_de_pokemon)

        val pokemon: Pokemon = intent.getParcelableExtra<Pokemon>("pok")
        val fragmentoDetalle = supportFragmentManager.findFragmentById(R.id.fragmentoDetallePokemon) as DetalleDePokemonFragment
        fragmentoDetalle.darDetalle(pokemon)
    }
}
