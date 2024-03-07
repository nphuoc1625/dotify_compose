package com.example.dotify_kotlin

import com.example.dotify_kotlin.data.playlist.repository.PlaylistRepository
import com.example.dotify_kotlin.network.RetrofitInstance

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private lateinit var retrofitInstance: RetrofitInstance
    private lateinit var repository: PlaylistRepository


    @Before
    fun setUp() {
        repository = PlaylistRepository(koin<PlaylistRepository>())
    }
}