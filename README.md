# Manga App
MangaApp is an application you can list manga, see manga detail, add manga to favorites and search any manga. 

## API
I used [Jikan API](https://jikan.moe) for retrieving data.

## Architecture
This app is developed with MVVM + Clean Architecture.

## Libraries Used
- [Kotlin](https://kotlinlang.org/) - Google officially supports Kotlin on Android as a “first-class” language and it has [a lot of benefits](https://developer.android.com/kotlin)
- [MVVM Architecture](https://developer.android.com/jetpack/guide) - Modern, maintainable, and Google suggested app architecture
- [Hilt](https://dagger.dev/hilt/gradle-setup) for Dependency Injection
- [Retrofit](https://square.github.io/retrofit/)
- [OkHttp](https://square.github.io/okhttp/)
- [Moshi](https://github.com/square/moshi)
- [Coil](https://github.com/coil-kt/coil)
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) for managing background threads with simplified code and reducing needs for callbacks
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) and [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [Navigation](https://developer.android.com/guide/navigation)

## Features
- View Manga
- See Manga Detail
- Save your favorite Manga
- Easily search any Manga

## Preview

 <table>
  <tr>
    <td> <b> Manga List </b> </td>
    <td> <b> Manga Detail </b> </td>
    <td> <b> Favorites </b> </td>
    <td> <b> Search Manga </b> </td>
  </tr>
  <tr>
     <td valign="top"><img src=https://user-images.githubusercontent.com/56589369/172317741-7cfc982e-f934-45a7-a689-ec36b8ae5ed5.jpg height="480" width="216"<br>
      <td valign="top"><img src=https://user-images.githubusercontent.com/56589369/172317757-c6bd580e-294f-45e5-8cdb-000e13468100.jpg height="480" width="216"<br>
       <td valign="top"><img src=https://user-images.githubusercontent.com/56589369/172317778-f955986d-678b-4d73-8282-586d5f3695da.jpg height="480" width="216"<br>
     <td valign="top"><img src=https://user-images.githubusercontent.com/56589369/172317784-5f723393-81c8-48f8-91f9-f8eccdcc2bf2.jpg height="480" width="216"></td>
  </tr>
 </table>
