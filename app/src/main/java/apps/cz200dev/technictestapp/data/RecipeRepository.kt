package apps.cz200dev.technictestapp.data

import apps.cz200dev.technictestapp.data.model.RecipeItem
import apps.cz200dev.technictestapp.data.remote.RecipeService
import javax.inject.Inject

class RecipeRepository @Inject constructor(private val api: RecipeService) {

    suspend fun getRecipeListFromApi(): List<RecipeItem> = api.getRecipeList()

}