package apps.cz200dev.technictestapp.presentation

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations


@ExperimentalCoroutinesApi
class RecipeListViewModelTest{

    @Mock
    private lateinit var quoteRepository: RecipeRepository

    lateinit var recipeDataSource: RecipeDataSource

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        recipeDataSource = recipeDataSource
    }


}