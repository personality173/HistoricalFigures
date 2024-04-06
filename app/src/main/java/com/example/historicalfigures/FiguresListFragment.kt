package com.example.historicalfigures

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import com.example.historicalfigures.databinding.FragmentFiguresListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A fragment representing a list of Items.
 */
class FiguresListFragment : Fragment() {
    companion object {
        fun newInstance() = FiguresListFragment()
    }
    private var _binding: FragmentFiguresListBinding? = null
    private val binding get() = _binding!!
    private lateinit var searchView: SearchView

    private val adapter by lazy { MyFigureRecyclerViewAdapter() }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFiguresListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        searchView = binding.search
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { fetchFigureByName(it) }
                return false
            }
        })
    }
    private fun fetchFigureByName(query: String) {
        ApiClient.instance.getHistoricalFigure(query).enqueue(object : Callback<List<Figure>> {
            override fun onResponse(call: Call<List<Figure>>, response: Response<List<Figure>>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    data?.let {
                        adapter.submitList(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<Figure>>, t: Throwable) {
            }
        })
    }
    private fun setupUI() {
        with(binding) {
            catList.adapter = this@FiguresListFragment.adapter
        }
    }


}