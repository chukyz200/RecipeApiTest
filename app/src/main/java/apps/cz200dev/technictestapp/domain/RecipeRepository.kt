package apps.cz200dev.technictestapp.domain

import apps.cz200dev.technictestapp.data.model.RecipeItem

interface RecipeRepository {

    suspend fun getRecipeList(): List<RecipeItem>

}