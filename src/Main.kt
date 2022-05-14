package src

import BitArray.BitArray

fun main() {
    var BArray = BitArray(4)
    BArray.addBitBack(true)
    BArray.addBitFront(true)
    BArray.addBitAt(2,true)
    BArray.RemoveBack()
    BArray.RemoveFront()
    BArray.RemoveAt(2)
}