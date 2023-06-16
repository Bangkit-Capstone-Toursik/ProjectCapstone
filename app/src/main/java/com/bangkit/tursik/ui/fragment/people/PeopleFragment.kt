package com.bangkit.tursik.ui.fragment.people

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import com.bangkit.tursik.R

class PeopleFragment : Fragment(), View.OnClickListener {


    private lateinit var cardPrivasi: CardView
    private lateinit var cardTentangKami: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_people, container, false)


        cardPrivasi = view.findViewById(R.id.card_privasi)
        cardTentangKami = view.findViewById(R.id.card_tentangkami)


        cardPrivasi.setOnClickListener(this)
        cardTentangKami.setOnClickListener(this)

        return view
    }

    override fun onClick(view: View) {
        when (view.id) {

            R.id.card_privasi -> {
                val tujuanFragment = AccountFragment.newInstance("","")
                navigateToFragment(tujuanFragment)
            }
            R.id.card_tentangkami -> {
                val tujuanFragment = PrivasiFragment.newInstance("","")
                navigateToFragment(tujuanFragment)
            }
        }
    }

    private fun navigateToFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.buttom_nav, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}