package org.themoviedb.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before

@ExperimentalCoroutinesApi
abstract class BaseViewModelTest {

    private val dispatcher = TestCoroutineDispatcher()

    @Before
    open fun setupViewModel() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    open fun tearDown() {
        Dispatchers.resetMain()
    }
}