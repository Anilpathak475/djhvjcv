package com.anil.gctestmodule.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.anil.gctestmodule.MainViewModel
import com.anil.gctestmodule.R
import com.anil.gctestmodule.ui.adapter.GroupAdapter
import kotlinx.android.synthetic.main.fragment_group.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class GroupFragment : Fragment() {

    private val mainViewModel: MainViewModel by viewModel()
    private val adapter by lazy {
        GroupAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_group, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewGroups.adapter = adapter
        mainViewModel.dwGroupDate.observe(viewLifecycleOwner, Observer { it ->
            Log.d("Group data size", it?.size.toString())
           it?.forEach { _data ->
                _data.entries.forEach { data ->
                    Log.d("Group data details", data.key)
                }
                adapter.dwGroups = it
                val response = mainViewModel.getGroupDetails()
                it.forEach {
                    val itemId = it["id"] as String
                    val responseItem = mainViewModel.getGroupItem(itemId)
                    Log.d("response size", responseItem?.size.toString())

                }
            }
        })

    }
}
