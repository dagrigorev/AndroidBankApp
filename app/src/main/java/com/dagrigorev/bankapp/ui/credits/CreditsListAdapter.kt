package com.dagrigorev.bankapp.ui.credits

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
import com.dagrigorev.bankapp.data.credit.CreditListElement

class CreditsListAdapter(itemList: List<CreditListElement>, context: Context) :
    RecyclerView.Adapter<CreditsListAdapter.ViewHolder>() {
    private var mData: List<CreditListElement>
    private val mInflater: LayoutInflater
    private val context: Context

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = mInflater.inflate(R.layout.credit_list_element, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.accountView.animation = AnimationUtils.loadAnimation(context, R.anim.fade_transition)
        holder.bindData(mData[position])
    }

    fun setItems(items: List<CreditListElement>) {
        mData = items
    }

    inner class ViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var cardPaymentImageView: ImageView
        var creditNameTextView: TextView
        var accountNumberView: TextView
        var accountBalanceView: TextView
        var accountStatusView: TextView
        var accountView: CardView

        fun bindData(item: CreditListElement) {
            cardPaymentImageView.setImageResource(getAccountTypeImage(item.getAccountType()))
            creditNameTextView.text = item.getAccountName()
            accountNumberView.text = item.getAccountNumber().toString()
            accountBalanceView.text = "${item.getAccountBalance()} ${item.getCurrency()}"
            accountStatusView.text = getAccountStatusText(item.getAccountStatus())
        }

        init {
            cardPaymentImageView = itemView.findViewById(R.id.cardPaymentImageView)
            creditNameTextView = itemView.findViewById(R.id.creditNameTextView)
            accountNumberView = itemView.findViewById(R.id.creditNumberTextView)
            accountBalanceView = itemView.findViewById(R.id.creditBalanceTextView)
            accountStatusView = itemView.findViewById(R.id.creditStatusTextView)
            accountView = itemView.findViewById(R.id.cardViewCredit)
        }

        private fun getAccountTypeImage(accountType: AccountType): Int {
            return R.drawable.ic_logo_visa;
        }

        private fun getAccountStatusText(status: Boolean): String {
            return if (status) context.getString(R.string.account_status_active) else context.getString(
                R.string.account_status_inactive)
        }
    }

    init {
        mInflater = LayoutInflater.from(context)
        this.context = context
        mData = itemList
    }
}