package com.andoridians.basicmvvmrecipe.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SampleRecipeDao {

    private val recipeList = mutableListOf<Recipe>()
    private val recipes = MutableLiveData<List<Recipe>>()

    init {
        recipes.value = recipeList
    }

    fun addRecipe(recipe: Recipe) {
        recipeList.add(recipe)
        recipes.value = recipeList
    }

    fun getRecipes() = recipes as LiveData<List<Recipe>>

}