package com.stdio.mvvmsample.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.stdio.mvvmsample.models.VolumesResponse;
import com.stdio.mvvmsample.repository.BookRepository;

public class BookSearchViewModel extends AndroidViewModel {
    private BookRepository bookRepository;
    private LiveData<VolumesResponse> volumesResponseLiveData;

    public BookSearchViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        bookRepository = new BookRepository();
        volumesResponseLiveData = bookRepository.getVolumesResponseLiveData();
    }

    public void searchVolumes(String keyword, String author) {
        //Dotenv dotenv = Dotenv.configure().directory("/assets").filename("env").load();
        bookRepository.searchVolumes(keyword, author);
    }

    public LiveData<VolumesResponse> getVolumesResponseLiveData() {
        return volumesResponseLiveData;
    }
}