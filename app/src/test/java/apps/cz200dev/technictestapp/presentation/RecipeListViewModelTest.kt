package apps.cz200dev.technictestapp.presentation

import apps.cz200dev.technictestapp.data.RecipeRepository
import apps.cz200dev.technictestapp.domain.GetRecipeListUseCase
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before


@ExperimentalCoroutinesApi

class RecipeListViewModelTest {

    @RelaxedMockK
    private lateinit var recipeRepository: RecipeRepository

    lateinit var getRecipeListUseCase: GetRecipeListUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        getRecipeListUseCase = GetRecipeListUseCase(recipeRepository)
    }



}