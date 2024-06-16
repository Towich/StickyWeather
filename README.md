# **StickyWeather**
*StickyWeather* - мобильное приложения для просмотра текущей погоды в определенном городе.
</br>Приложение состоит из двух экранов:
- Экран "Список городов"
- Экран "Температура города"

## Функционал
- Просмотр списка городов:
	- Группировка городов в алфавитном порядке
  - Отображение городов в виде "sticky label"
- Просмотр текущей температуры в выбранном городе
- Отображение загрузки данных
- Оповещение об ошибке получения данных

## Дизайн
<img src="https://github.com/Towich/StickyWeather/assets/100920758/990addbd-ea1e-4c35-8280-ae0a641e2720" width="250"> 
<img src="https://github.com/Towich/StickyWeather/assets/100920758/ff6f392d-287e-4345-ba25-67544dee5a04" width="250">
<img src="https://github.com/Towich/StickyWeather/assets/100920758/3ac18297-ba25-4db3-a3a6-6d277132c2fe" width="250">

## Используемые технологии
1. **Язык:** Kotlin
2. **Работа с сетью:** Ktor Client
3. **Многопоточность:** Kotlin Coroutines/Flow
4. **UI:** Jetpack Compose, Material Design 3 Components
5. **Сериализаторы:** Kotlinx Serialization, Gson
6. **Навигация:** Jetpack Navigation
7. **DI:** Hilt
8. **Архитектура:** MVVM, Clean Architecture

## Установка и настройка
Чтобы запустить приложение на своем устройстве, выполните следующие шаги:
1. Склонируйте репозиторий в вашу локальную папку
2. Откройте проект в Android Studio
3. Запустите приложение на эмуляторе или на устройстве
