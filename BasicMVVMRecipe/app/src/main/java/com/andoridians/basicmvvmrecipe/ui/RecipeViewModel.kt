package com.andoridians.basicmvvmrecipe.ui

import androidx.lifecycle.ViewModel
import com.andoridians.basicmvvmrecipe.data.Recipe
import com.andoridians.basicmvvmrecipe.data.RecipeRepository

class RecipeViewModel(private val recipeRepository : RecipeRepository) : ViewModel() {

    fun addRecipes(recipe : Recipe) = recipeRepository.addRecipe(recipe)
    fun getRecipe() = recipeRepository.getRecipe()
}