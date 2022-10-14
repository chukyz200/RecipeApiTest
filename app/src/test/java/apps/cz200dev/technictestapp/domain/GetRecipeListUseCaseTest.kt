package apps.cz200dev.technictestapp.domain

import apps.cz200dev.technictestapp.data.RecipeRepository
import apps.cz200dev.technictestapp.data.model.RecipeItem
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class GetRecipeListUseCaseTest {

    @RelaxedMockK
    private lateinit var recipeRepository: RecipeRepository

    lateinit var useCase: GetRecipeListUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        useCase = GetRecipeListUseCase(recipeRepository)
    }

    @Test
    fun `when the api doesn't return anything returns empty list`() = runBlocking {
        //Given

        coEvery { recipeRepository.getRecipeListFromApi() } returns emptyList()

        //When
        val response = useCase()
        //Then

        assertThat(response).isEmpty()
    }

    @Test
    fun `when the api return is valid returns the true`() = runBlocking {

        val list = listOf(
            RecipeItem(
                "100",
                "200",
                "ar",
                "NO descriprion",
                0,
                "no",
                "hedline",
                "1",
                "image",
                "name",
                "proteins", "thumb", "time"
            )
        )
        coEvery { recipeRepository.getRecipeListFromApi() } returns list

        //When
        val response = useCase()
        //Then

        assertThat(response).isEqualTo(list)
    }

}