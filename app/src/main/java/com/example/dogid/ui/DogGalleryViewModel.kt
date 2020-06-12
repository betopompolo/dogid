package com.example.dogid.ui

import android.app.Application
import androidx.lifecycle.*
import com.example.dogid.data.*

class DogGalleryViewModel(application: Application) : AndroidViewModel(application), LifecycleObserver {
    private val dogRepository =  DogRepository()
    private val userRepository = UserRepository()
    var onImageClickListener: ImageClickListener? = null

    val dogs: LiveData<List<Dog>>
        get() = _dogs
    private val _dogs = MutableLiveData<List<Dog>>()

    val fetchDogsError: LiveData<Error>
        get() = _fetchDogsError
    private val _fetchDogsError = MutableLiveData<Error>()

    val selectedDogBreed: LiveData<DogBreed>
        get() = _selectedDogBreed
    private val _selectedDogBreed = MutableLiveData<DogBreed>()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onActivityStart() {
        setSelectedDogBreed(DogBreed.Husky)
    }

    fun setSelectedDogBreed(dogBreed: DogBreed) {
        _selectedDogBreed.postValue(dogBreed)
        if (_dogs.value?.isEmpty() == false) {
            _dogs.postValue(emptyList())
        }

        userRepository.getLoggedUser(getApplication())?.let { loggedUser ->
            dogRepository.listByBreed(dogBreed, object : RepositoryCallback<List<Dog>> {
                override fun onSuccess(data: List<Dog>) {
                    _dogs.postValue(data)
                }

                override fun onError(error: Error?) {
                    _fetchDogsError.postValue(error)
                }
            }, loggedUser.token)
        }

    }
}