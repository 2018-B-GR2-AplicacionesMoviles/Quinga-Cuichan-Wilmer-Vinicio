package com.example.viniq.a2018movilesgr2

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_primer.*


class PrimerFragment : Fragment() {


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.i("Fragmentos", "On Attach")
    }


    override fun onStart() {
        super.onStart()
        Log.i("Fragmentos", "On Start")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Fragmentos", "On Resume")

    }

    override fun onPause() {
        super.onPause()
        Log.i("Fragmentos", "On Pause")

    }

    override fun onStop() {
        super.onStop()
        Log.i("Fragmentos", "On Stop")

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (arguments != null) {
            Log.i("fragmentos", arguments!!.getString("nombre"))

        }

        return inflater!!.inflate(
                R.layout.fragment_primer,
                container,
                false
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Fragmentos", "On Destroy")

    }


    override fun onDetach() {
        super.onDetach()
        Log.i("Fragmentos", "On Detach")

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (arguments != null) {
            Log.i("fragmentos", arguments!!.getString("nombre"))

            text_view_primer_fragmentos
                    .text = arguments!!.getString("nombre")

        }
    }

}