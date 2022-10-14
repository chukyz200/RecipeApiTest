package apps.cz200dev.technictestapp.domain

import apps.cz200dev.technictestapp.data.RecipeRepository
import apps.cz200dev.technictestapp.data.model.RecipeItem
import javax.inject.Inject

class GetRecipeListUserCase @Inject constructor(private val repository: RecipeRepository) {

    suspend operator fun invoke(): List<RecipeItem> {
        val recipes = repository.getRecipeListFromApi()
        return if (recipes.isNotEmpty()) {
            recipes
        } else {
            emptyList()
        }
    }
}