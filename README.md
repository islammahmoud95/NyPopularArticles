# NyTimesArticleApp


## About
NY Times Most Popular Articles API and show a list of articles, that
shows details when items on the list are tapped .

***To Install and test latest v1.0 app follow below link***\
(https://github.com/islammahmoud95/NyPopularArticles.git)

## Pre-requisites
Most Popular API from [nytimes developer](https://developer.nytimes.com/apis) have been used.

For example: https://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/1.json?api-key=yourkey

Where your_key has to be generated following [get-started](https://developer.nytimes.com/get-started) page from nytimes.

Once you have yourkey, please add a new entry in **gradle.properties** inside your project directory. Since local.properties is added in [.gitignore](https://github.com/roymithun/NyTimesArticleApp/blob/master/.gitignore). it is never added to VCS. This way your appKey can be kept somehow secured.
- **api.key = your_key**

## Built With 🛠
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [JetPack Compose](https://developer.android.com/jetpack/compose?gclid=CjwKCAjwvpCkBhB4EiwAujULMrbD-3XP1RIuGOIBrWF8be1gGksAJ0z_B36Im37TdmjRpiKPNzSzVRoCHe0QAvD_BwE&gclsrc=aw.ds) -For layout and screen design.
- [Google Material Design 3](https://m3.material.io/components) - Views And Component Views.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous programming.
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects that notify views when the underlying database changes.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. 
- [Dependency Injection](https://developer.android.com/training/dependency-injection) -
  - [Hilt-Dagger](https://dagger.dev/hilt/) - Standard library to incorporate Dagger dependency injection into an Android application.
  - [Hilt-ViewModel](https://developer.android.com/training/dependency-injection/hilt-jetpack) - DI for injecting `ViewModel`.
- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
- [Coil-kt](https://coil-kt.github.io/coil/) - An image loading library for Android backed by Kotlin Coroutines.

# Package Structure
    
    com.inhouse.nytimesarticleapp    # Root Package
    .
    ├── data                      # For data handling.
    │   ├── di                    # For dependency injection
    |   │   ├── AppModule         # Di For Application App class 
    |   |   ├── ArticleDataModule #Di For API Class
    │   ├── remote                # Remote Data Handlers     
    |   │   ├── api               # Retrofit API for remote end point.
    |   │   ├── Mapper            # Map data remote class from data layer to domain layer
    |   │   ├── model             # Have data classes for data layer
    │   └── repository            # Single source of data.
    |
    |
    ├── presentation              # Activity/View layer
    │   ├── mainactivity          # Base View
    │   ├── feature               # Ui for app and view Layer 
    |   │   ├── article           # have screen for articles list and viewModel for it
    |   |   ├── articleDetails    # have screen for articles list and viewModel for it
    │   ├── navigation            # App Navigatior and distionation , navigate between view Screens 
    |   │   ├── AppNavigation     # Contain all navigation layout 
    |   |   ├── ArticleDistination # have screen for articles Distination
    |   |   ├── ArticleDetailsDistination    # have screen for articles Details Distination
    |
    └── utils                     # Utility Classes 

## Architecture
This app uses [***MVVM (Model View View-Model)***](https://developer.android.com/jetpack/docs/guide#recommended-app-arch) architecture.

