package co.edu.uniquindio.vc.jq.herbarioadminuq.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.edu.uniquindio.vc.jq.herbarioadminuq.R

class GestionarRecolectoresFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from( container?.context).inflate(R.layout.fragment_gestionar_recolectores, container, false)
    }



}