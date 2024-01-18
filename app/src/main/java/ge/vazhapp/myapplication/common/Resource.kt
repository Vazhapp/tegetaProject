package ge.vazhapp.myapplication.common

sealed class Resource<T>(val data: T? = null, val message: String? = null) {

    class Success<T>(data: T?): Resource<T>(data)

    // TODO Missing loading

    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)
}