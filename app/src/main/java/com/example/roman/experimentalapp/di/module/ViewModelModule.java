package com.example.roman.experimentalapp.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.roman.experimentalapp.di.ViewModelKey;
import com.example.roman.experimentalapp.factory.ViewModelFactory;
import com.example.roman.experimentalapp.ui.viewmodel.MovieListViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel.class)
    protected abstract ViewModel movieListViewModel(MovieListViewModel moviesListViewModel);
}
