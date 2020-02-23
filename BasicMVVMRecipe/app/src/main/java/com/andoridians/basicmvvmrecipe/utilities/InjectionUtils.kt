package com.andoridians.basicmvvmrecipe.utilities

import com.andoridians.basicmvvmrecipe.data.RecipeRepository
import com.andoridians.basicmvvmrecipe.data.SampleDatabase
import com.andoridians.basicmvvmrecipe.ui.RecipeViewModelFactory

object InjectionUtils {

    fun provideRecipeViewModelFactory(): RecipeViewModelFactory {
        val recipeRepository = RecipeRepository.getInstance(SampleDatabase.getInstance().recipeDao)
        return RecipeViewModelFactory(recipeRepository)
    }

}