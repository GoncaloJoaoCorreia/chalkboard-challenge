# Chalkboard "Birthdays" Challenge

## Install and run
Open the project in Android Studio (version used to develop was Android Studio Arctic Fox | 2020.3.1 Patch 4). App can then be compiled and ran directly.

There are examples of both unit and UI tests, although I wish I had time for more in depth ones.

## Dependencies

### Development
Since I would be using the REST api, I went with Retrofit, a library I'm quite familiar with to handle the API call. To parse the response, I went with Moshi, a JSON parser that is build to work with Kotlin.

Regarding architecture, I went with barebones MVVM, using Jetpack ViewModels and LiveData. To ensure the API calls were handled in a separate thread, I used Kotlin Coroutines for that, integrating them with LiveData.

For dependency injection I went with Koin, since it's pretty easy to setup and get going within the time limit.

### Testing
The main thing here, apart from the usual JUnit and Espresso, was MockWebServer, to allow me to run UI tests against mocked data, instead of relying on the external API to check the client's code.

If I had time for more in depth unit tests, I would have also used Mockk or Mockito, to allow the use of mocked dependencies.

## Other information

I purposefully left some TODOs and FIXMEs in areas where I intended to go back and improve, but ended up not having time to do so within the 3h limit.

You can find more of my work at [Gitlab](https://gitlab.com/goncalojoaoc)
