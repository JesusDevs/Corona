package com.example.corona.ui

import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.corona.R
import com.example.corona.databinding.FragmentFirstBinding
import com.example.corona.viewmodel.DateViewmodel
import java.util.*


class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val mViewModel : DateViewmodel by activityViewModels()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root


    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val now = Calendar.getInstance()

        //reste dos días porque con uno no tenía respuesta del servidor
        now.add(Calendar.DATE, -2)
        val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(now.time)


        mViewModel.getTotalDate(date)
        mViewModel.getTotalDateRepo.observe(viewLifecycleOwner) {
            it?.let{
                Log.d("tag",it.toString())
                _binding!!.titulo.text = it.data.date
                _binding!!.casosConfirmados.text = "${getString(R.string.casos)} ${it.data.confirmed}"
                _binding!!.cantidadPersonasInfectadas.text ="${getString(R.string.personas_infectadas)} ${it.data.active}"
            }

        }

        binding.buttonFirst.setOnClickListener {
            showDatePickerDialog()

        }
    }

    private fun showDatePickerDialog() {
      val datePicker = DatePicker { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(childFragmentManager, "datePicker")

      }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun onDateSelected(day: Int, month: Int, year: Int) {
        if(day!=0 && month!=0 && year!=0) {
            val calendar = Calendar.getInstance()
            calendar.set(year, month, day)
            val date = calendar.time
            val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val dateString = formatter.format(date)
            Log.d("tag", "dateString: $dateString")
            //llamada a la api picker
            mViewModel.getTotalDate(dateString)
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}