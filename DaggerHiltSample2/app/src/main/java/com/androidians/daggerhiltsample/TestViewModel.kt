package com.androidians.daggerhiltsample

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import javax.inject.Named

class TestViewModel @ViewModelInject constructor(
    @Named("string2") testString: String
): ViewModel() {

    init {
        Log.e("ViewModel", "test string from viewModel $testString")
    }

    fun testString() {
        Log.e("ViewModel", "test string from viewModel")
    }

}