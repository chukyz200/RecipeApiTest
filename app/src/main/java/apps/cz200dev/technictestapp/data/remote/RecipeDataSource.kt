package apps.cz200dev.technictestapp.data.remote

import apps.cz200dev.technictestapp.data.WebService
import apps.cz200dev.technictestapp.data.model.RecipeItem
import javax.inject.Inject

class RecipeDataSource @Inject constructor(private val webService: WebService) {

    suspend fun getRecipeList(): List<RecipeItem> = webService.getRecipeList()

}