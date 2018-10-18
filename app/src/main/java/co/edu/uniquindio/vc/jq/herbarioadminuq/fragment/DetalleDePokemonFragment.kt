package co.edu.uniquindio.vc.jq.herbarioadminuq.fragment


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import co.edu.uniquindio.vc.jq.herbarioadminuq.R
import co.edu.uniquindio.vc.jq.herbarioadminuq.vo.Pokemon
import kotlinx.android.synthetic.main.fragment_detalle_de_pokemon.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 *
 */
class DetalleDePokemonFragment : Fragment(), View.OnClickListener {


    var pokemon: Pokemon? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_de_pokemon, container, false)
    }

    fun darDetalle(pokemon: Pokemon) {
        this.pokemon = pokemon
        txtTituloDetalle.text = pokemon.nombre
        btnIrAVideo.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var intent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=7JljNefaRoY"))
        startActivity(intent)
    }

}
