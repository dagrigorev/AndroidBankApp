package com.dagrigorev.bankapp.ui.credits

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dagrigorev.bankapp.R
import com.dagrigorev.bankapp.data.account.AccountListElement
import com.dagrigorev.bankapp.data.account.AccountType
import com.dagrigorev.bankapp.data.credit.CreditListElement
import com.dagrigorev.bankapp.data.credit.CreditType
import com.dagrigorev.bankapp.databinding.FragmentCreditsBinding
import com.dagrigorev.bankapp.ui.accounts.AccountsListAdapter
import java.time.Instant
import java.util.*

class CreditsFragment : Fragment() {

    private var _binding: FragmentCreditsBinding? = null
    private lateinit var credits: ArrayList<CreditListElement>

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(CreditsViewModel::class.java)

        _binding = FragmentCreditsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textCredits
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        initCreditsViews()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var listAdapter: CreditsListAdapter = CreditsListAdapter(credits, requireContext())
        var recyclerView: RecyclerView = view.findViewById(R.id.credits_list)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = listAdapter
    }

    private fun initCreditsViews() {
        credits = ArrayList<CreditListElement>(3)
        credits.add(0, CreditListElement(
            "Regular",
            AccountType.CardVisa,
            60816923,
            28950.0,
            Date.from(Instant.now()),
            CreditType.ConsumerLoan)
        )
        credits.add(1, CreditListElement(
            "Credit card",
            AccountType.CardVisa,
            60816923,
            28950.0,
            Date.from(Instant.now()),
            CreditType.ConsumerLoan)
        )
        credits.add(2, CreditListElement(
            "Consumer loan",
            AccountType.CardVisa,
            60816923,
            28950.0,
            Date.from(Instant.now()),
            CreditType.ConsumerLoan)
        )
    }
}