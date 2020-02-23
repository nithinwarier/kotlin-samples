package com.andoridians.basicmvvmrecipe.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andoridians.basicmvvmrecipe.data.RecipeRepository

@Suppress("UNCHECKED_CAST")
class RecipeViewModelFactory(private val recipeRepository : RecipeRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RecipeViewModel(recipeRepository) as T
    }

}