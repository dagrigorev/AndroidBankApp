package com.dagrigorev.bankapp.ui.accounts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.dagrigorev.bankapp.R
import com.dagrigorev.bankapp.data.account.AccountListElement
import com.dagrigorev.bankapp.data.account.AccountType


class AccountsListAdapter(itemList: List<AccountListElement>, context: Context) :
    RecyclerView.Adapter<AccountsListAdapter.ViewHolder>() {
    private var mData: List<AccountListElement>
    private val mInflater: LayoutInflater
    private val context: Context
    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = mInflater.inflate(R.layout.list_element, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.accountView.animation = AnimationUtils.loadAnimation(context, R.anim.fade_transition)
        holder.bindData(mData[position])
    }

    fun setItems(items: List<AccountListElement>) {
        mData = items
    }

    inner class ViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var accountTypeView: ImageView
        var accountNameView: TextView
        var accountNumberView: TextView
        var accountBalanceView: TextView
        var accountStatusView: TextView
        var accountView: CardView

        fun bindData(item: AccountListElement) {
            accountTypeView.setImageResource(getAccountTypeImage(item.getAccountType()))
            accountNameView.text = item.getAccountName()
            accountNumberView.text = item.getAccountNumber().toString()
            accountBalanceView.text = "${item.getAccountBalance()} ${item.getCurrency()}"
            accountStatusView.text = getAccountStatusText(item.getAccountStatus())
        }

        init {
            accountTypeView = itemView.findViewById(R.id.iconImageView)
            accountNameView = itemView.findViewById(R.id.accountNameTextView)
            accountNumberView = itemView.findViewById(R.id.accountNumberTextView)
            accountBalanceView = itemView.findViewById(R.id.accountBalanceTextView)
            accountStatusView = itemView.findViewById(R.id.accountStatusTextView)
            accountView = itemView.findViewById(R.id.cv)
        }

        private fun getAccountTypeImage(accountType: AccountType): Int {
            return R.drawable.ic_logo_visa;
        }

        private fun getAccountStatusText(status: Boolean): String {
            return if (status) context.getString(R.string.account_status_active) else context.getString(R.string.account_status_inactive)
        }
    }

    init {
        mInflater = LayoutInflater.from(context)
        this.context = context
        mData = itemList
    }
}