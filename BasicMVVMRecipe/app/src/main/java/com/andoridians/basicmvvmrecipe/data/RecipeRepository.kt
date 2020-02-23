package com.andoridians.basicmvvmrecipe.data

class RecipeRepository private constructor(private val recipeDao: SampleRecipeDao) {

    fun addRecipe(recipe : Recipe) {
        recipeDao.addRecipe(recipe)
    }

    fun getRecipe() = recipeDao.getRecipes()

    companion object {
        @Volatile private var instance: RecipeRepository? = null

        fun getInstance(recipeDao: SampleRecipeDao) = instance ?: synchronized(this) {
            instance ?: RecipeRepository(recipeDao).also { instance = it }
        }
    }


}