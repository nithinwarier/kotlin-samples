package com.andoridians.basicmvvmrecipe.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.andoridians.basicmvvmrecipe.R
import com.andoridians.basicmvvmrecipe.data.Recipe
import com.andoridians.basicmvvmrecipe.utilities.InjectionUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        val factory = InjectionUtils.provideRecipeViewModelFactory();
        val viewModel = ViewModelProvider(this, factory).get(RecipeViewModel::class.java)

        viewModel.getRecipe().observe(this, Observer {
            val stringBuilder = StringBuilder()
            it.forEach { recipe ->
                stringBuilder.append("${recipe.title}\n\n")
            }
            recipeDetailsTV.text = stringBuilder.toString()
        })

        addButton.setOnClickListener {
            val recipe = Recipe(recipeNameET.text.toString())
            viewModel.addRecipes(recipe)
            recipeNameET.setText("")
        }
    }
}
