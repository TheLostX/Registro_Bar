package com.lost.kotlinejercicioregistrobar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lost.kotlinejercicioregistrobar.databinding.FragmentFirstBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    private lateinit var all: List<Items>

    private lateinit var db: RoomDatabase.Builder<ConsumoDataBase>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        db = Room.databaseBuilder(requireContext(), ConsumoDataBase::class.java, "my_database")
            .allowMainThreadQueries()


        initAll()
        var adapter: CheckItemAdapter = CheckItemAdapter(all)
        var layoutManager: LinearLayoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = layoutManager

        binding.btnVer.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

    }

    private fun initAll() {
        all = db.build().itemsDao().getAllItems()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}