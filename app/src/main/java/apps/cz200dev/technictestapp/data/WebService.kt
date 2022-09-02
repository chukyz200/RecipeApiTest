package apps.cz200dev.technictestapp.data

import apps.cz200dev.technictestapp.data.model.RecipeItem
import retrofit2.http.GET

interface WebService {

    @GET("recipes.json")
    suspend fun getRecipeList(): List<RecipeItem>

}