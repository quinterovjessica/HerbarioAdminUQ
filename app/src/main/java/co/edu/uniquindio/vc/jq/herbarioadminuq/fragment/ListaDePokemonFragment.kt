package co.edu.uniquindio.vc.jq.herbarioadminuq.fragment


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.*

import co.edu.uniquindio.vc.jq.herbarioadminuq.R
import co.edu.uniquindio.vc.jq.herbarioadminuq.util.AdaptadorDePokemones
import co.edu.uniquindio.vc.jq.herbarioadminuq.util.selecionarIdioma
import co.edu.uniquindio.vc.jq.herbarioadminuq.vo.Pokemon
import kotlinx.android.synthetic.main.fragment_lista_de_pokemon.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ListaDePokemonFragment : Fragment(), AdaptadorDePokemones.OnClickAdaptadorDePokemon {

    var pokemones: ArrayList<Pokemon> = ArrayList()
    var adaptador: AdaptadorDePokemones? = null

    // var listener: OnPokemonSeleccionadoListener? = null
    private lateinit var listener:OnPokemonSeleccionadoListener

    interface OnPokemonSeleccionadoListener {
        fun onPokemonSeleccionado(pos: Int)
    }

    /*
    / realiza la inicializacion del listener para realizar la
    comunicacion con la
    /@param context contexto de la actividad
     */
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is Activity){

            try {
                listener= context as OnPokemonSeleccionadoListener
            }catch (e:ClassCastException){
                throw ClassCastException("${activity.toString()} debe implementar la interfaz OnPokemonSeleccionadoListener")
                // Log.v("ListaDePokemonFragment", "Error: ${e.message}")

            }


        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_de_pokemon, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adaptador = AdaptadorDePokemones(this, pokemones)

        listaPokemones.adapter = adaptador
        listaPokemones.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)

        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_agregar -> {
                mostrarAgregarPokemon();
            }
            R.id.menu_eliminar -> {
                pokemones.removeAt(0)
                adaptador!!.notifyItemRemoved(0)
            }
            R.id.menu_modificar -> {
                val aux: Pokemon = pokemones.get(1)
                pokemones.set(1, pokemones.get(2))
                pokemones.set(2, aux)
                adaptador!!.notifyItemMoved(1, 2)
            }

            R.id.cambiar_idioma->
            {
                selecionarIdioma(context!!)
                val intent = activity!!.intent
                intent.flags = (Intent.FLAG_ACTIVITY_CLEAR_TOP or
                        Intent.FLAG_ACTIVITY_NEW_TASK)
                activity!!.finish()
                activity!!.startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClickPosition(pos: Int) {
        listener!!.onPokemonSeleccionado(pos)
    }

    /**
     * muestra un diallogo  que permite poner en pantalla kla opocion
     */
    fun mostrarAgregarPokemon(){
        val agregarPokemon = AgregarPokemonFragment()
        agregarPokemon.setStyle(DialogFragment.STYLE_NORMAL,
            R.style.DialogoTitulo
        )
        agregarPokemon.show(fragmentManager,"AgregarPokemon")
    }
}


