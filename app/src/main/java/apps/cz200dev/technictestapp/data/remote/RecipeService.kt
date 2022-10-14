package apps.cz200dev.technictestapp.data.remote

import apps.cz200dev.technictestapp.data.model.RecipeItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RecipeService @Inject constructor(private val api: RecipeClient) {

    suspend fun getRecipeList(): List<RecipeItem> {
        return withContext(Dispatchers.IO) {
            val response = api.getRecipeList()
            response.body() ?: emptyList()
        }
    }
}