package BitArray

class BitArray {
    private var Array = mutableListOf<Boolean>()
    private var Size:UInt = 0u
    fun Size():UInt {return Size}
    constructor() {

    }
    fun addBitBack(Bit:Boolean) {
        Array.add(Bit)
        Size++
    }
    fun addBitFront(Bit: Boolean) {
        Array.add(0,Bit)
        Size++
    }
    fun addBitAt(Index:Int,Bit: Boolean) {
        Array.add(Index,Bit)
        Size++
    }
    fun RemoveBack() {
        if(Size != 0u) {
            Array.removeLast()
            Size--
        }
    }
    fun RemoveFront() {
        if(Size != 0u) {
            Array.removeFirst()
            Size--
        }
    }
    fun RemoveAt(Index: Int) {
        Array.removeAt(Index)
        Size--
    }

    constructor(Size:Int,Fill:Boolean = false) : this() {
        for(i in 0..Size-1) {
            addBitBack(Fill)
        }
    }

    override fun toString(): String {
        return Array.toString()
    }
}