package ge.vazhapp.myapplication.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ge.vazhapp.myapplication.common.Constants.BASE_URL
import ge.vazhapp.myapplication.data.remote.ColorsApiService
import ge.vazhapp.myapplication.data.repository.ColorsRepoImpl
import ge.vazhapp.myapplication.domain.repository.ColorsRepo
import ge.vazhapp.myapplication.domain.usecase.GetAllColorsUseCase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor()
                .apply { setLevel(HttpLoggingInterceptor.Level.BODY) }
        )
        .build()

    @Provides
    @Singleton
    fun provideJsonSerializer(): Moshi {
        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    // Service & Repo
    @Provides
    @Singleton
    fun provideColorsApiService(retrofit: Retrofit): ColorsApiService =
        retrofit.create(ColorsApiService::class.java)

    @Provides
    @Singleton
    fun provideColorsRepo(colorsApiService: ColorsApiService): ColorsRepo =
        ColorsRepoImpl(colorsApiService)

    // Use Cases
    @Provides
    @Singleton
    fun providerGetAllColorsUseCase(repository: ColorsRepo): GetAllColorsUseCase =
        GetAllColorsUseCase(repository)
}