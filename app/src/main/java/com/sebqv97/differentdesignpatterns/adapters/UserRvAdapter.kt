package com.sebqv97.differentdesignpatterns.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sebqv97.differentdesignpatterns.R
import com.sebqv97.differentdesignpatterns.data.models.Users
import com.sebqv97.differentdesignpatterns.data.models.getCityAndZipCode
import com.sebqv97.differentdesignpatterns.data.models.getCompanyName
import com.sebqv97.differentdesignpatterns.databinding.UserLayoutBinding

class UserRvAdapter(private val mList:Users): RecyclerView.Adapter<UserRvAdapter.MyViewHolder>(){
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val binding = UserLayoutBinding.bind(itemView)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder = MyViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.user_layout,parent,false))


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val element = mList[position]

        holder.binding.apply {
            textViewFullName.text = element.name
            textViewPhone.text = element.phone
        }
    }


    override fun getItemCount() = mList.size


}