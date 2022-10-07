package com.syafei.unittesttraining

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class MainViewModelTest {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var cuboidModel: CuboidModel

    private val dummyLengt = 12.0
    private val dummyWidth = 7.0
    private val dummyHeight = 6.0

    private val dummyVolume = 504.0

    private val dummyCircumference = 100.0
    private val dummySurfaceArea = 6216.0


    @Before
    fun before() {
        cuboidModel = mock(CuboidModel::class.java)
        mainViewModel = MainViewModel(cuboidModel)
    }

    @Test
    fun testVolume() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyWidth, dummyLengt, dummyHeight)
        val volume = mainViewModel.getVolume()
        //get result expected vs actual
        assertEquals(dummyVolume, volume, 0.0001)
    }

    @Test
    fun getCircumReference() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyWidth, dummyLengt, dummyHeight)
        val getCircum = mainViewModel.getCircumReference()
        assertEquals(dummyCircumference, getCircum, 0.0001)
    }

    @Test
    fun getSurfaceArea() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyWidth, dummyLengt, dummyHeight)
        val getSurface = mainViewModel.getSurfaceArea()
        assertEquals(dummySurfaceArea, getSurface, 0.0001)
    }

    @Test
    fun testMockgetVolume() {
        `when`(mainViewModel.getVolume()).thenReturn(dummyVolume)
        val vlume = mainViewModel.getVolume()
        verify(cuboidModel).getVolume()
        assertEquals(dummyVolume, vlume, 0.0001)
    }

    @Test
    fun testMockSurfaceArea() {
        `when`(mainViewModel.getSurfaceArea()).thenReturn(dummySurfaceArea)
        val surface = mainViewModel.getSurfaceArea()
        verify(cuboidModel).getSurfaceArea()
        assertEquals(dummySurfaceArea, surface, 0.0001)
    }

    @Test
    fun testMockCircumReference() {
        `when`(mainViewModel.getCircumReference()).thenReturn(dummyCircumference)
        val circum = mainViewModel.getCircumReference()
        verify(cuboidModel).getCircumreference()
        assertEquals(dummyCircumference, circum, 0.0001)
    }
}