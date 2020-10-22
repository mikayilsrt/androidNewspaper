package com.app.androidnewspaper

import com.app.androidnewspaper.datas.repository.ArticleRepository
import com.app.androidnewspaper.views.home.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {
    single { ArticleRepository() }

    viewModel { MainActivityViewModel(get()) }
}