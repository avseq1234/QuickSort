package com.quickSortInplace.demo

/**
  * Created by Honda on 2017/12/18.
  */
object quickSortDemo {

  def main(args: Array[String]): Unit = {
    val ary = Array(10 , 40 , 100 ,  11 , 99 , 100, 22 , 55, 8 , 83 , 40)
    println("Before")
    ary.foreach(x => print(x + ","))
    quickSort(ary, 0, ary.length - 1)
    println()
    println("After")
    ary.foreach(x => print(x + ","))

  }

  /**
    * @array: The array needed be sorted
    * @start: Start Index of array to sort
    * @end: End Index of array to sort
    */
  def quickSort(array: Array[Int], start: Int, end: Int): Unit = {
    val aryLength = array.slice(start, end + 1).length
    if (aryLength == 0 || aryLength == 1)
      return
    val pivot = end

    var front = start
    var minIdx = start - 1

    while (front < pivot) {
      if (array(front) > array(pivot)) {
        minIdx += 1
        swap(array, minIdx, front)
      }
      front += 1
    }

    val newPivotIdx = minIdx + 1

    swap(array, newPivotIdx, pivot)
    quickSort(array, start , minIdx)
    quickSort(array, newPivotIdx + 1, array.length - 1)

  }

  def swap(array: Array[Int], indexA: Int, indexB: Int): Unit = {
    val temp = array(indexA)
    array(indexA) = array(indexB)
    array(indexB) = temp
  }
}
