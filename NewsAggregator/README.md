# 📰 News Reader App

A modern Kotlin Android application built with Jetpack Compose to display news from The Guardian's RSS feed. Supports local caching, search, and in-app reading via WebView.

## Tech Stack

- **Kotlin** with Coroutines
- **Jetpack Compose** for UI
- **Hilt** for Dependency Injection
- **Room** for local data storage
- **Retrofit** for network layer
- **Coil** for image loading
- **Navigation Compose** for screen transitions

## Architecture

The app follows Clean Architecture:

- **domain**: use cases like `GetArticlesListUseCase`, `SaveArticlesUseCase`, etc.
- **data**: Retrofit API, Room
- **presentation**: ViewModels and Compose-based UI

## Features

- Fetch news from The Guardian RSS
- Local cache fallback when offline
- Search by article title (with instant filtering)
- View full articles inside a WebView screen

## Author

https://github.com/andreising
https://t.me/andreising