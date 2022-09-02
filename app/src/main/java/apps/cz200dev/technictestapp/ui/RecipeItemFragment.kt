package apps.cz200dev.technictestapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import apps.cz200dev.technictestapp.R
import apps.cz200dev.technictestapp.data.model.RecipeItem
import apps.cz200dev.technictestapp.databinding.FragmentRecipeItemBinding
import apps.cz200dev.technictestapp.utils.loadImage
import dagger.hilt.android.AndroidEntryPoint
import kotlin.time.Duration


@AndroidEntryPoint
class RecipeItemFragment : Fragment(R.layout.fragment_recipe_item) {

    private lateinit var binding: FragmentRecipeItemBinding
    private val args: RecipeItemFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Bind the layout
        binding = FragmentRecipeItemBinding.bind(view)
        toolbar(args.recipe.name)
        loadContent(args.recipe)

    }

    //Add the toolbar and click event to the layout
    private fun toolbar(tittle: String) {
        binding.toolbar.title = tittle
        binding.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    //Load content into the views
    private fun loadContent(recipe: RecipeItem) {
        binding.ivImage.loadImage(recipe.image)
        binding.tvHeadline.text = recipe.headline
        binding.tvDescription.text = recipe.description
        binding.tvTime.text =
            getString(R.string.estimated_time, Duration.parseIsoStringOrNull(recipe.time))
        val difficulty = if (recipe.difficulty == 0) "easy" else "hard"
        binding.tvDifficulty.text = getString(R.string.hard, difficulty)
        binding.tvCalories.text = getString(R.string.calories, recipe.calories)
        binding.tvCarbohydrates.text = getString(R.string.carbohydrates, recipe.carbos)
        binding.tvFats.text = getString(R.string.fats, recipe.carbos)

    }
}