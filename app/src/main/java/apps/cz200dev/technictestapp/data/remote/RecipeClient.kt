package apps.cz200dev.technictestapp.data.remote

import apps.cz200dev.technictestapp.data.model.RecipeItem
import retrofit2.Response
import retrofit2.http.GET

interface RecipeClient {

    @GET("recipes.json")
    suspend fun getRecipeList(): Response<List<RecipeItem>>
}