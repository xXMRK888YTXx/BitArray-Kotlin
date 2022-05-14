package src

import BitArray.BitArray

fun main() {
    var BArray = BitArray(4)
    BArray.addBitBack(true)
    var new = BitArray(BArray)
    new.addBitFront(true)
}