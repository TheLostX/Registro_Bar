package com.lost.kotlinejercicioregistrobar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lost.kotlinejercicioregistrobar.databinding.FragmentSecondBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private lateinit var db: RoomDatabase.Builder<ConsumoDataBase>

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        db = Room.databaseBuilder(requireContext(), ConsumoDataBase::class.java, "my_database").allowMainThreadQueries()


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.numberPicker.minValue = 1
        binding.numberPicker.maxValue = 20

        binding.numberPicker.setOnValueChangedListener(object: NumberPicker.OnValueChangeListener{

            override fun onValueChange(p0: NumberPicker?, oldVal: Int, newVal: Int) {
                total(newVal)
            }
        })

        binding.btnAgregar.setOnClickListener {

            agregar(binding.numberPicker.value)
        }
    }

    fun agregar(value:Int){
        val id = 0
        val name = binding.etNombreItem.text.toString()
        val price = binding.etPrecio.text.toString().toInt()

        db.build().itemsDao().insertAll(Items(id, name, value * price, value))
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun total(newValue:Int){

        var total:Int

        if(binding.etPrecio.text.toString().isBlank()){

            total = 0
        }
        else{
            total = binding.etPrecio.text.toString().toInt()
        }

        binding.tvTotalActual.text = "$${total * newValue }"
    }
}