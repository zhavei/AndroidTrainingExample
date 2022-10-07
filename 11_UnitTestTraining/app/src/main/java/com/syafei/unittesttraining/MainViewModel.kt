package com.syafei.unittesttraining

class MainViewModel(private val cuboidModel: CuboidModel) {

    fun getCircumReference() = cuboidModel.getCircumreference()

    fun getSurfaceArea() = cuboidModel.getSurfaceArea()

    fun getVolume() = cuboidModel.getVolume()

    fun save(w: Double, l: Double, h: Double) {
        cuboidModel.save(w, l, h)
    }
}