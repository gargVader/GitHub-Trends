# Github Trends
![Kotlin](https://img.shields.io/badge/kotlin-%230095D5.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)

Android app that shows latest updated repos on GitHub for Kotlin Language

# π· Previews
Download [apk](https://drive.google.com/file/d/1U4SNoN6jobaEwXyTJll-THSJO92tSafd/view?usp=share_link). Watch [video](https://drive.google.com/drive/folders/11qSVAmZHwyKaxpnlL5h3iLfNRyMieR15?usp=share_link)
<p align="center">
  <img width="250" src="Screenshots/1.png" />
  <img width="250" src="Screenshots/2.png" />
</p>

# π  Tech Sacks & Open Source Libraries

- Jetpack Compose
- ViewModel
- Hilt
- Compose Navigation
- Room
- DataStore
- Retrofit
- moshi

# File structure

<details>
    <summary>Click me</summary>

  ```
githubtrends
    β   MainActivity.kt
    β   RepoApplication.kt
    β
    ββββdata
    β   ββββlocal
    β   β       RepoDao.kt
    β   β       RepoDatabase.kt
    β   β
    β   ββββmodel
    β   β       Owner.kt
    β   β       Repo.kt
    β   β
    β   ββββremote
    β   β       GithubApi.kt
    β   β       RepoSearchResponse.kt
    β   β
    β   ββββrepository
    β           RepoRepositoryImpl.kt
    β
    ββββdi
    β       AppModule.kt
    β       RepositoryModule.kt
    β
    ββββdomain
    β   ββββrepository
    β           RepoRepository.kt
    β
    ββββpresentation
    β   ββββnavigation
    β   β       NavGraph.kt
    β   β       Screen.kt
    β   β
    β   ββββrepo_details
    β   β       RepoDetailsScreen.kt
    β   β       RepoDetailsState.kt
    β   β       RepoDetailsViewModel.kt
    β   β
    β   ββββrepo_listings
    β           RepoItem.kt
    β           RepoListingsScreen.kt
    β           RepoListingsState.kt
    β           RepoListingsViewModel.kt
    β
    ββββui
    β   ββββtheme
    β           Color.kt
    β           Shape.kt
    β           Theme.kt
    β           Type.kt
    β
    ββββutil
            DataStoreUtil.kt
            Resource.kt
  ```

</details>


