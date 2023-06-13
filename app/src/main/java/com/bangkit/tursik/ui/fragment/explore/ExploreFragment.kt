package com.bangkit.tursik.ui.fragment.explore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.bangkit.tursik.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ExploreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExploreFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_explore, container, false)

        val ib_wAlam: ImageButton = view.findViewById(R.id.ib_wAlam)
        val ib_wReligi: ImageButton = view.findViewById(R.id.ib_wReligi)
        val ib_wPendidikan: ImageButton = view.findViewById(R.id.ib_wPendidikan)
        val ib_wSejarah: ImageButton = view.findViewById(R.id.ib_wSejarah)

        ib_wAlam.setOnClickListener {
            val fragment = WisataAlamFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.buttom_nav, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        ib_wReligi.setOnClickListener {
            val fragment = WisataReligiFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.buttom_nav, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        ib_wPendidikan.setOnClickListener {
            val fragment = WisataPendidikanFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.buttom_nav, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        ib_wSejarah.setOnClickListener {
            val fragment = WisataSejarahFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.buttom_nav, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        return view
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ExploreFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}