package com.example.andreymerkurev.chuckjokes.di

import com.example.andreymerkurev.chuckjokes.presentation.web.WebFragment
import com.example.andreymerkurev.chuckjokes.presentation.jokes.JokesFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun appModule(appModule: AppModule): Builder
    }

    fun inject(jokesFragment: JokesFragment)
    fun inject(webFragment: WebFragment)
}