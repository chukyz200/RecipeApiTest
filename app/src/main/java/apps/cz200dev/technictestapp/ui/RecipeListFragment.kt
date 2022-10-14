package apps.cz200dev.technictestapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import apps.cz200dev.technictestapp.R
import apps.cz200dev.technictestapp.core.Resource
import apps.cz200dev.technictestapp.data.model.RecipeItem
import apps.cz200dev.technictestapp.databinding.FragmentRecipeListBinding
import apps.cz200dev.technictestapp.presentation.RecipeListViewModel
import apps.cz200dev.technictestapp.ui.adapters.RecipeAdapter
import apps.cz200dev.technictestapp.utils.invisible
import apps.cz200dev.technictestapp.utils.visible
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class RecipeListFragment : Fragment(R.layout.fragment_recipe_list) {

    private lateinit var binding: FragmentRecipeListBinding

    private val viewModel by viewModels<RecipeListViewModel>()

    private var mAdapter = RecipeAdapter(this::onClickRecipe)


    override
    fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Bind the layout
        binding = FragmentRecipeListBinding.bind(view)
        initRecycler()
    }

    private fun searchViewListener(list: List<RecipeItem> = emptyList()) {
        binding.svItems.addTextChangedListener {
            mAdapter.apply {
                submitList(list.filter { item ->
                    item.name.uppercase().contains(it.toString().uppercase())
                })
            }
        }
    }


    //Observe the state of request
    private fun observeService() {
        viewModel.recipe.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    binding.progressbar.visible()
                }
                is Resource.Success -> {
                    binding.progressbar.invisible()
                    mAdapter.apply {
                        submitList(it.data)
                    }
                    searchViewListener(it.data)
                }
                is Resource.Failure -> {
                    binding.progressbar.invisible()
                    Toast.makeText(
                        requireContext(),
                        "An error has ocurred, try again!",
                        Toast.LENGTH_LONG
                    ).show()
                }

            }
        }
    }

    //Navigate to other screen
    private fun onClickRecipe(item: RecipeItem) {
        if (findNavController().currentDestination?.id == R.id.recipeListFragment) {
            findNavController().navigate(
                RecipeListFragmentDirections.actionRecipeListFragmentToRecipeItemFragment(
                    item
                )
            )
        }
    }


    //Load the recyclerview
    private fun initRecycler() {
        binding.rvRecipe.apply {
            adapter = mAdapter
        }
        observeService()
    }

}