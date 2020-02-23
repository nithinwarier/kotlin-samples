package com.andoridians.basicmvvmrecipe.data

class SampleDatabase private constructor(){

    var recipeDao = SampleRecipeDao()
    private set

    companion object {
        @Volatile private var instance: SampleDatabase? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: SampleDatabase().also { instance = it }
        }
    }

}