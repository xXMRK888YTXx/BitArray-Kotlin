package BitArray

class BitArray {
    private var Array = mutableListOf<Boolean>()
    private var Size:UInt = 0u
    fun Size():UInt {return Size}
    constructor() {

    }
    fun addBit(Bit:Boolean) {
        Array.add(Bit)
        Size++
    }

    constructor(Size:Int,Fill:Boolean = false) : this() {
        for(i in 0..Size-1) {
            addBit(Fill)
        }
    }

    override fun toString(): String {
        return Array.toString()
    }
}