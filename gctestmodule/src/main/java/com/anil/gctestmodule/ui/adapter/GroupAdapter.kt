package com.anil.gctestmodule.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anil.gctestmodule.R
import kotlinx.android.synthetic.main.item_group.view.*
import kotlin.properties.Delegates

class GroupAdapter : RecyclerView.Adapter<GroupAdapter.GroupViewGolder>() {

    var dwGroups by Delegates.observable(emptyList<Map<String, Any>>()) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            GroupViewGolder(LayoutInflater.from(parent.context).inflate(R.layout.item_group, parent, false))


    override fun getItemCount() = dwGroups.size
    override fun onBindViewHolder(holder: GroupViewGolder, position: Int) {
        val dataSet = dwGroups[position]
        holder.itemView.textViewGroupName.text = dataSet["name"] as String
    }

    class GroupViewGolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

}