[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
![Android](https://img.shields.io/badge/Android-0095D5?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?&style=for-the-badge&logo=kotlin&logoColor=white)
[![circle-ci](https://circleci.com/gh/faniabdullah/become-android-dev-expert.svg?style=svg)](https://circleci.com/gh/faniabdullah/become-android-dev-expert/)



<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/faniabdullah/become-android-dev-expert">
    <img src="https://i.imgur.com/azwt9Ab.png" width='400dp' alt="Logo" >
  </a>

  <h3 align="center">Movie Catalog App </h3>

  <p align="center">
   application that can view a list of currently playing movies, search for movies or tv shows, and can also add movies to favorites.
   This repository for learn About Mobile Development at <a href="https://grow.google/intl/id_id/bangkit/"><strong>Bangkit Academy led by Google, Tokopedia, Gojek, &   Traveloka »</strong></a>
    <br />
    <a href="https://github.com/faniabdullah/become-android-dev-expert"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/faniabdullah/become-android-dev-expert">View Demo</a>
    ·
    <a href="https://github.com/faniabdullah/become-android-dev-expert/issues">Report Bug</a>
    ·
    <a href="https://github.com/faniabdullah/become-android-dev-expert/issues">Request Feature</a>
  </p>
</p>

<!-- ABOUT THE PROJECT -->
## About The Project
This repository for learn About Mobile Development at <a href="https://grow.google/intl/id_id/bangkit/"><strong>Bangkit Academy led by Google, Tokopedia, Gojek, & Traveloka »</strong></a> . detail course is <strong>"Become Android Developer Expert"</strong> at <a href="https://www.dicoding.com/"><strong>Dicoding</strong></a><br><br>
       **NOTE :**  This repository have some branch , consist of practice, submission 1 & submission 2
  > 1. Master - consists of a combination of branches practice & submission 1 and 2
  > 2. Submission 1 - contains tasks from submission 1 ( **Get 4 Star** )
  > 3. Submission 2 - contains tasks from submission 2 ( **Get 5 Star** )

* #### Dependencies :
  - [Lifecycle & Livedata](https://developer.android.com/jetpack/androidx/releases/lifecycle)
  - [Navigation Component](https://developer.android.com/jetpack/androidx/releases/navigation)
  - [kotlinx-coroutines](https://developer.android.com/kotlin/coroutines)    
  - [Retrofit 2](https://square.github.io/retrofit/)    
  - [Glide](https://github.com/bumptech/glide)
  - [Dagger Hilt](https://dagger.dev/hilt/)
  - [Ok Http 3](https://square.github.io/okhttp/) 
  - [Room](https://developer.android.com/jetpack/androidx/releases/room) 
  - [Leak Canary](https://square.github.io/leakcanary/) 
  - [Air Bnb Lottie](https://airbnb.io/lottie/#/) 


## Acknowledgements
  * [Clean Architecture Guide](https://developer.android.com/jetpack/guide)
  * [Reactive Programming Using Coroutines Flow](https://developer.android.com/kotlin/flow)
  * [Modularization](https://www.techyourchance.com/preliminary-over-modularization-of-android-projects)
  * [Dynamic Feture](https://developer.android.com/guide/playcore/feature-delivery/on-demand)
  * [Dynamic Feature with Navigation](https://developer.android.com/guide/navigation/navigation-dynamic)
  * [Continuous Integration Using CircleCi](https://circleci.com/)
  * [Performance ](https://developer.android.com/training/articles/perf-tips)
  * [Obfocuscation Security](https://developer.android.com/studio/build/shrink-code)
  * [encryption using SqlCipher ](https://www.zetetic.net/sqlcipher/sqlcipher-for-android/)
  * [SSL Pinning Security](https://developer.android.com/training/articles/security-config)
  * [Dependency injection With Dagger Hilt](https://developer.android.com/training/dependency-injection)
  * [Lottie Animation AirBnb ](https://airbnb.io/lottie/#/)


 ## Getting Started Application

 - ### Prerequisites
       - ##### Tools Sofware
        1. Android Studio at least version 4.1. [Android Studio](https://developer.android.com/studio)
        2. JRE (Java Runtime Environment) or JDK (Java Development Kit).
  
 - ### Installation
      1. Get a free API Key at [Themoviedb](https://developers.themoviedb.org/3)
      2. Clone this repository and import into Android Studio    
          ```
             https://github.com/faniabdullah/become-android-dev-expert.git
          ``` 
      4. Enter your API in buildConfigField `build.graddle`
         ``` defaultConfig {
             buildConfigField("String", "MOVIE_TOKEN", '"Your Api Key"')
            }
         ```
 
<!-- USAGE EXAMPLES -->
## Usage

<p align="center"> 
    <img src="https://media.giphy.com/media/iCm7woiGuAyB40MKOu/giphy.gif"
        alt="Movie App "    
        style="margin-right: 10px;"    
        width="150" />
    <img src="https://media.giphy.com/media/VA6bmaUK4LRgf1CbWZ/giphy.gif"
        alt="Dark Movie App"    
        style="margin-right: 10px;"    
        width="150" />
    <img src="https://media.giphy.com/media/Cza3WtbssSA4v2ThP3/giphy.gif"
        alt="Add To Favorite"    
        style="margin-right: 10px;"    
        width="150" />
    <img src="https://media.giphy.com/media/viifzylqlRI6YhaHi6/giphy.gif"
        alt="Favorite"    
        style="margin-right: 10px;"    
        width="150" />
   <img src="https://media.giphy.com/media/uSIKDOa9YSOImKUkJ3/giphy.gif"
        alt="Search"    
        style="margin-right: 10px;"    
        width="150" />
</p>


<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.



<!-- CONTACT -->
## Contact

[Fani Abdullah ](https://www.linkedin.com/in/fani-abdullah/) - faniabdullah27@gmail.com


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/faniabdullah/become-android-dev-expert.svg?style=for-the-badge
[contributors-url]: https://github.com/faniabdullah/become-android-dev-expert/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/faniabdullah/become-android-dev-expert.svg?style=for-the-badge
[forks-url]: https://github.com/faniabdullah/become-android-dev-expert/network/members
[stars-shield]: https://img.shields.io/github/stars/faniabdullah/become-android-dev-expert.svg?style=for-the-badge
[stars-url]: https://github.com/faniabdullah/become-android-dev-expert/stargazers
[issues-shield]: https://img.shields.io/github/issues/faniabdullah/become-android-dev-expert.svg?style=for-the-badge
[issues-url]: https://github.com/faniabdullah/become-android-dev-expert/issues
[license-shield]: https://img.shields.io/github/license/faniabdullah/become-android-dev-expert.svg?style=for-the-badge
[license-url]: https://github.com/faniabdullah/become-android-dev-expert/blob/master/LICENSE
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
