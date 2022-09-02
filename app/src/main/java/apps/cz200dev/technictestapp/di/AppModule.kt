package apps.cz200dev.technictestapp.di

import apps.cz200dev.technictestapp.data.WebService
import apps.cz200dev.technictestapp.data.model.RecipeItem
import apps.cz200dev.technictestapp.domain.RecipeRepository
import apps.cz200dev.technictestapp.domain.RecipeRepositoryImpl
import apps.cz200dev.technictestapp.utils.AppConstants.BASE_URL
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    //Provide Retrofit
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    //Provide the webService
    @Singleton
    @Provides
    fun provideWebService(retrofit: Retrofit): WebService = retrofit.create(WebService::class.java)

    //Provide the dataclass
    @Singleton
    @Provides
    fun provideRecipeModel(): RecipeItem = RecipeItem()

    //Provide the repository
    @Singleton
    @Provides
    fun provideRecipeRepository(repository: RecipeRepositoryImpl): RecipeRepository = repository

}