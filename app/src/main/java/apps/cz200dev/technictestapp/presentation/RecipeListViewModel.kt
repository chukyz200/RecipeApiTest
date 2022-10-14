package apps.cz200dev.technictestapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import apps.cz200dev.technictestapp.core.Resource
import apps.cz200dev.technictestapp.data.model.RecipeItem
import apps.cz200dev.technictestapp.domain.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class RecipeListViewModel @Inject constructor(private val repo: RecipeRepository) :
    ViewModel() {

    private val _recipes: MutableLiveData<Resource<List<RecipeItem>>> = MutableLiveData()
    val recipe: LiveData<Resource<List<RecipeItem>>> = _recipes


    init {
        getRecipes()
    }

    //Get the response of the server
    private fun getRecipes() =
        viewModelScope.launch() {
            kotlin.runCatching {
                Resource.Success(repo.getRecipeList())
            }.onSuccess {
                _recipes.value = it
            }.onFailure { exception ->
                _recipes.value = Resource.Failure(Exception(exception))
            }
        }

}