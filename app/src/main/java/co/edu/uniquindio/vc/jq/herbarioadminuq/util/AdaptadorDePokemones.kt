package co.edu.uniquindio.vc.jq.herbarioadminuq.util

import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import co.edu.uniquindio.vc.jq.herbarioadminuq.R
import co.edu.uniquindio.vc.jq.herbarioadminuq.vo.Pokemon


import kotlinx.android.synthetic.main.resumen_pokemon.view.*


class AdaptadorDePokemones(fragment: Fragment, var pokemones: ArrayList<Pokemon>) : RecyclerView.Adapter<AdaptadorDePokemones.PokemonViewHolder>() {

    private lateinit var listener:OnClickAdaptadorDePokemon

    init{
        try {
            listener= fragment as OnClickAdaptadorDePokemon
        }catch (e:ClassCastException){
            Log.v("AdaptadorDePoken", "Error, implemente la interfaz...")
        }

    }
    //inner permite que una clase esta dentro de otra logicamente
   inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {


        val nombre: TextView = itemView.txtNombre
        val tipo: TextView = itemView.txtTipo


        init {
            itemView.setOnClickListener(this)
        }

        fun bindPokemon(pokemon: Pokemon) {
            nombre.text = pokemon.nombre
            tipo.text = pokemon.tipo
        }

        override fun onClick(p0: View?) {
            Log.d("Pokemon", "Elemento $adapterPosition clickeado ${nombre.text}")
            listener.onClickPosition(adapterPosition)

        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PokemonViewHolder {
        val v = LayoutInflater.from(p0.context)
                .inflate(R.layout.resumen_pokemon, p0, false)
        return PokemonViewHolder(v)
    }

    override fun getItemCount(): Int {
        return pokemones.size
    }

    /*
    actualiza datos
     */
    override fun onBindViewHolder(p0: PokemonViewHolder, p1: Int) {
        p0.bindPokemon(pokemones.get(p1))
    }

    interface OnClickAdaptadorDePokemon {
        fun onClickPosition(pos: Int)
    }
}

