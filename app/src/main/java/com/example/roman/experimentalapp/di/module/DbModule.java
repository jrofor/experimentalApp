package com.example.roman.experimentalapp.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.roman.experimentalapp.data.local.AppDatabase;
import com.example.roman.experimentalapp.data.local.dao.MovieDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.annotations.NonNull;

@Module
public class DbModule {

    @Provides
    @Singleton
    AppDatabase provideDatabase(@NonNull Application application) {
        return Room.databaseBuilder(application,AppDatabase.class, "Entertainment.db")
                .allowMainThreadQueries().build();
    }

    @Provides
    @Singleton
    MovieDao provideMovieDao(@NonNull AppDatabase appDatabase) {
        return appDatabase.movieDao();
    }
}
