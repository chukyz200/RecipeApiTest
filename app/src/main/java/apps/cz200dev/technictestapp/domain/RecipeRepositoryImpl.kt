package apps.cz200dev.technictestapp.domain

import apps.cz200dev.technictestapp.data.model.RecipeItem
import apps.cz200dev.technictestapp.data.remote.RecipeDataSource
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(private val dataSource: RecipeDataSource) :
    RecipeRepository {
    override suspend fun getRecipeList(): List<RecipeItem> = dataSource.getRecipeList()
}