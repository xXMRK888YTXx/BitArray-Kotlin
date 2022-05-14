package BitArray

import java.util.BitSet

class BitArray {
    private var Array = mutableListOf<Boolean>()
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
    fun clear() {
        Array.clear()
    }
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
    operator fun get(Index: Int):Boolean {
        return Array[Index]
    }
    operator fun not():BitArray {
         var temp = BitArray(this)
        for (i in 0..temp.Size()-1) {
            temp.Array[i] = temp.Array[i].not()
        }

        return temp
    }
    operator fun plus(other: BitArray):BitArray {
        this.Array += other.Array
        return this
    }
}