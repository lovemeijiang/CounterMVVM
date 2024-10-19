package com.kyou.countermvvm

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel

class CounterViewModel(): ViewModel(){
    private val _repository: CounterRepository = CounterRepository()
    private val _count =  mutableStateOf(_repository.getCounter().count)

    // Expose the count as an immutable state
    val count: MutableState<Int> = _count

    fun increment(){
//        _count.value++ // 为什么要用.value而不是直接的_count？因为_count它是一个object，一个对象，而不是具体的数值。它是MutableState对象，通过.value来获值
        _repository.incrementCounter()
        _count.value = _repository.getCounter().count
    }

    fun decrement(){
//        _count.value--
        _repository.decrementCounter()
        _count.value = _repository.getCounter().count
    }
}