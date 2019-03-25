package com.waether.app.Features.home

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.waether.app.Features.randomizer.DEFUALT_VALUE
import com.waether.app.Features.randomizer.RandamizeViewModel
import org.junit.Assert
import org.junit.Rule
import org.junit.Test




class RandamizeViewModelTest {
    // initial value of numberlivedata is DEFAULT_VALUE

    @JvmField
    @Rule
    val instantExecutorRule = InstantTaskExecutorRule()


    @Test
    fun `init Then Update Number Live data To Zero`(){
        //Arrange

        //Act
        val ViewModel = RandamizeViewModel()

        //Assert
        val result =ViewModel.randomValue.value
        Assert.assertTrue(result== DEFUALT_VALUE)

    }
    // when I invoke incrementnumber () ,numberlivedata is incremented by one
    @Test
    fun `increment Number When Number Live data Value Is Zero Then Update Number Live data To one`(){
        //Arrange
        val ViewModel = RandamizeViewModel()
        ViewModel.randomValue.value= DEFUALT_VALUE

        //Act
        ViewModel.increamentNumber()

        //Assert
        val result =ViewModel.randomValue.value
        Assert.assertTrue(result==1)

    }
}