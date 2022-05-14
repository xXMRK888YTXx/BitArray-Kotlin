package BitArray

class BitArray {
    private val Array = mutableListOf<Boolean>()
    fun Size():Int {return Array.size}
    constructor() {

    }
    fun addBitBack(Bit:Boolean) {
        Array.add(Bit)
    }
    fun addBitFront(Bit: Boolean) {
        Array.add(0,Bit)
    }
    fun addBitAt(Index:Int,Bit: Boolean) {
        Array.add(Index,Bit)
    }
    fun RemoveBack() {
        if(Size() != 0) {
            Array.removeLast()
        }
    }
    fun RemoveFront() {
        if(Size() != 0) {
            Array.removeFirst()
        }
    }
    fun RemoveAt(Index: Int) {
        Array.removeAt(Index)
    }

    constructor(Size:Int,Fill:Boolean = false) : this() {
        for(i in 0..Size-1) {
            addBitBack(Fill)
        }
    }
    constructor(other:BitArray) : this() {this.Array += other.Array}

    override fun toString(): String {
        return Array.toString()
    }
    fun toInt() : MutableList<Int> {
        var Bits:MutableList<Int> = mutableListOf()
        for(i in Array) {
            if (i) Bits += 1 else Bits += 0
        }
        return Bits
    }

    operator fun not():MutableList<Boolean> {
         var temp:MutableList<Boolean> = mutableListOf()
        temp += this.Array
        for(i in 0..temp.lastIndex) {
            temp[i] = !temp[i]
        }
        return temp
    }
}