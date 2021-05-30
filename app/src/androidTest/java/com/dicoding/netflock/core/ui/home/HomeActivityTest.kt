package com.dicoding.netflock.core.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.dicoding.netflock.HomeActivity
import com.dicoding.netflock.R
import com.dicoding.netflock.core.utils.DataDummy
import com.dicoding.netflock.core.utils.EspressoIdlingResources
import org.junit.After
import org.junit.Before
import org.junit.Test


class HomeActivityTest {

    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyShow = DataDummy.generateDummyTvShow()

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.textTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.textDate)).check(matches(isDisplayed()))
        onView(withId(R.id.textDesc)).check(matches(isDisplayed()))
    }

    @Test
    fun loadShows() {
        onView(withId(R.id.navShows)).perform(click())
        onView(withId(R.id.rv_tvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvShow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyShow.size))
    }

    @Test
    fun loadDetailShow() {
        onView(withId(R.id.navShows)).perform(click())
        onView(withId(R.id.rv_tvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.textTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.textDate)).check(matches(isDisplayed()))
        onView(withId(R.id.textDesc)).check(matches(isDisplayed()))
    }

    @Test
    fun loadFavorite() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btnLike)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.menuFavorite)).perform(click())
        onView(withText("Movies")).perform(click())
        onView(withId(R.id.rv_fav_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.textTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.textDate)).check(matches(isDisplayed()))
        onView(withId(R.id.textDesc)).check(matches(isDisplayed()))
        onView(withId(R.id.btnLike)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }
}