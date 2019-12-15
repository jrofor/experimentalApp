package com.example.roman.experimentalapp.ui.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.roman.experimentalapp.data.Resource;
import com.example.roman.experimentalapp.data.local.dao.MovieDao;
import com.example.roman.experimentalapp.data.local.entity.MovieEntity;
import com.example.roman.experimentalapp.data.remote.api.MovieApiService;
import com.example.roman.experimentalapp.data.repository.MovieRepository;

import java.util.List;

import javax.inject.Inject;

public class MovieListViewModel extends ViewModel {

    private MovieRepository movieRepository;

    private MutableLiveData<Resource<List<MovieEntity>>> moviesLiveData = new MutableLiveData<>();

    @Inject
    public MovieListViewModel(MovieDao movieDao, MovieApiService movieApiService) {
        movieRepository = new MovieRepository(movieDao, movieApiService);
    }

    public void loadMoreMovies() {
        movieRepository.loadMoviesByType()
                .subscribe(resource -> getMoviesLiveData().postValue(resource));
    }

    public MutableLiveData<Resource<List<MovieEntity>>> getMoviesLiveData() {
        return moviesLiveData;
    }

}
