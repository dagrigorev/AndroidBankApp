package com.dagrigorev.bankapp.ui.accounts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dagrigorev.bankapp.R
import com.dagrigorev.bankapp.data.account.AccountListElement
import com.dagrigorev.bankapp.data.account.AccountType
import com.dagrigorev.bankapp.databinding.FragmentAccountsBinding
import java.time.Instant
import java.util.ArrayList;
import java.util.Date

class AccountsFragment : Fragment() {

    private var _binding: FragmentAccountsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var accounts: ArrayList<AccountListElement>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(AccountsViewModel::class.java)

        _binding = FragmentAccountsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textAccounts
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        initAccountsViews()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var listAdapter: AccountsListAdapter = AccountsListAdapter(accounts, requireContext())
        var recyclerView: RecyclerView = view.findViewById(R.id.accounts_list)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = listAdapter
    }

    private fun initAccountsViews() {
        accounts = ArrayList<AccountListElement>(4)
        accounts.add(0, AccountListElement(
            "Saving",
            AccountType.CardVisa,
            60816923,
            28950.0,
            Date.from(Instant.now())))
        accounts.add(1, AccountListElement(
            "Saving",
            AccountType.CardVisa,
            60816923,
            28950.0,
            Date.from(Instant.now())))
        accounts.add(2, AccountListElement(
            "Saving",
            AccountType.CardVisa,
            60816923,
            28950.0,
            Date.from(Instant.now())))
        accounts.add(3, AccountListElement(
            "Saving",
            AccountType.CardVisa,
            60816923,
            28950.0,
            Date.from(Instant.now())))
    }
}