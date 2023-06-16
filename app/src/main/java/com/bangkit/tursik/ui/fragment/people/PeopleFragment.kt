package com.bangkit.tursik.ui.fragment.people

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import com.bangkit.tursik.R
import com.bangkit.tursik.ui.login.LoginActivity
import com.bangkit.tursik.ui.splash.SessionManager
import dagger.hilt.android.AndroidEntryPoint
import com.google.android.material.snackbar.Snackbar

@AndroidEntryPoint
class PeopleFragment : Fragment(), View.OnClickListener {


    private lateinit var cardPrivasi: CardView
    private lateinit var cardTentangKami: CardView
    private lateinit var cardLogout: CardView
    private lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_people, container, false)

        sessionManager = SessionManager(requireContext())

        cardPrivasi = view.findViewById(R.id.card_privasi)
        cardTentangKami = view.findViewById(R.id.card_tentangkami)
        cardLogout = view.findViewById(R.id.card_keluar)

        cardPrivasi.setOnClickListener(this)
        cardTentangKami.setOnClickListener(this)
        cardLogout.setOnClickListener(this)

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
            R.id.card_keluar ->{
                performLogout()
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
    private fun performLogout() {
        val context = requireContext()

        val popupView = LayoutInflater.from(context).inflate(R.layout.popup_logout, null)
        val popupWindow = PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true)

        // Atur tampilan dan tindakan pada popupView
        val buttonLogout = popupView.findViewById<Button>(R.id.button_logout)
        val buttonCancel = popupView.findViewById<Button>(R.id.button_cancel)

        buttonLogout.setOnClickListener {
            logoutAndNavigateToLogin()
            popupWindow.dismiss()
        }

        buttonCancel.setOnClickListener {
            popupWindow.dismiss()
        }

        popupWindow.showAtLocation(requireView(), Gravity.CENTER, 0, 0)
    }
    private fun logoutAndNavigateToLogin() {

        sessionManager.logout()

        val intent = Intent(requireContext(), LoginActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }
}