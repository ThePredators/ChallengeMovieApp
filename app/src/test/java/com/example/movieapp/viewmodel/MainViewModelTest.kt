package com.example.movieapp.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.example.movieapp.MainCoroutineRule
import com.example.movieapp.core.data.MovieBdd
import com.example.movieapp.core.repository.MovieRepository
import com.example.movieapp.runBlockingTest
import com.example.movieapp.ui.main.MainViewModel
import org.junit.*
import org.junit.rules.RuleChain
import javax.inject.Inject
import kotlin.jvm.Throws
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.reactivex.internal.util.NotificationLite.getValue


@HiltAndroidTest
class MainViewModelTest {

    private lateinit var appDatabase: MovieBdd
    private lateinit var viewModel: MainViewModel
    private val hiltRule = HiltAndroidRule(this)
    private val coroutineRule = MainCoroutineRule()

    @get:Rule
    val rule = RuleChain
        .outerRule(hiltRule)
        .around(coroutineRule)

    @Inject
    lateinit var repository: MovieRepository

    @Before
    fun setUp() {
        hiltRule.inject()
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        appDatabase = Room.inMemoryDatabaseBuilder(context, MovieBdd::class.java).build()
        viewModel = MainViewModel(repository)
    }

    @After
    fun tearDown() {
        appDatabase.close()
    }

    @Suppress("BlockingMethodInNonBlockingContext")
    @Test
    @Throws(InterruptedException::class)
    fun testDefaultValues() = coroutineRule.runBlockingTest {
        Assert.assertFalse(getValue(viewModel.movies))
    }
}