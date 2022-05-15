package BitArray

import kotlin.math.pow


class BitArray {
    private var Array = mutableListOf<Boolean>()
    fun Size():Int {return Array.size}
    fun lastindex():Int {return Size() - 1}
    constructor() {}

    companion object {
        fun ToBinaty(Value: Long):BitArray {
            var temp = Value
            var BitA = BitArray()
            while(temp != 1L&&temp != 1L) {
            BitA.AddBitFront(temp % 2L == 1L)
            temp /= 2
            }
            BitA.AddBitFront(temp == 1L)
            return BitA
        }
        fun FromBinary(BitA:BitArray) : Long {
        var Sum = 0L
        var degree = 0
            for(i in BitA.lastindex() downTo  0) {
                if(BitA[i]) {
                    Sum += 2.0.pow(degree).toLong()
                }
                degree++
            }
            return Sum
        }
    }
    constructor(Size:Int,Fill:Boolean = false) : this() {
        for(i in 0..Size-1) {
            AddBitBack(Fill)
        }
    }
    constructor(other:BitArray) : this() {this.Array += other.Array}
    fun AddBitBack(Bit:Boolean) {
        Array.add(Bit)
    }
    fun AddBitFront(Bit: Boolean) {
        Array.add(0,Bit)
    }
    fun AddBitAt(Index:Int,Bit: Boolean) {
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

    fun Clear() {
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
    operator fun set(Index:Int,Value:Boolean) {
        this.Array[Index] = Value
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
    fun Copy(other: BitArray) {
        this.Clear()
        this.Array += other.Array
    }

    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        if (other !is BitArray) return false
        return other.Array == this.Array
    }
   fun Fill(Value: Boolean) {
       Array.fill(Value)
   }
    fun Resize(Size:Int,Value:Boolean = false) {
        while(Size > this.Size()) {AddBitBack(Value)}
    }
    private fun ResizePrivate(Size: Int) {
        while(Size > this.Size()) {AddBitFront(false)}
    }
    fun And(other: BitArray) :BitArray {
        var ThisOb = BitArray(this)
        var OtherOb = BitArray(other)
        if(ThisOb.Size() < OtherOb.Size()) {ThisOb.ResizePrivate(OtherOb.Size())}
        if(ThisOb.Size() > OtherOb.Size()) {OtherOb.ResizePrivate(ThisOb.Size())}
        for(i in 0..ThisOb.Size()-1) {
            ThisOb[i] =  ThisOb[i].and(OtherOb[i])
        }
        return ThisOb
    }
    fun Or(other: BitArray) :BitArray {
        var ThisOb = BitArray(this)
        var OtherOb = BitArray(other)
        if(ThisOb.Size() < OtherOb.Size()) {ThisOb.ResizePrivate(OtherOb.Size())}
        if(ThisOb.Size() > OtherOb.Size()) {OtherOb.ResizePrivate(ThisOb.Size())}
        for(i in 0..ThisOb.Size()-1) {
            ThisOb[i] =  ThisOb[i].or(OtherOb[i])
        }
        return ThisOb
    }
}