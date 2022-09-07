package uz.utils

interface ItemTouchHelperAdapter {

    fun onItemMove(fromPosition:Int, toPosition:Int)

    fun onItemDismiss(position:Int)
}