package com.example.nypopulararticle.data.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/*
Created by 
Islam Ibrahim
islam.mahmoud116@gmail.com
*/
@Module(includes = [ArticleDataModule.BindsModule::class])
@InstallIn(SingletonComponent::class)
object AppModule {

}