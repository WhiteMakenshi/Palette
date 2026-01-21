# Palette - Kotlin Multiplatform

This is a Kotlin Multiplatform project that showcases how to build a color palette generator for Android and iOS using Compose Multiplatform.

The application allows users to generate color palettes from an image and interact with the generated colors.

## Project Structure

*   `./composeApp`: This is the shared module containing the application logic and UI, written in Compose Multiplatform.
    *   `src/commonMain`: Contains the common code for all platforms (Android and iOS), including UI components and business logic.
    *   `src/androidMain`: Contains Android-specific code.
    *   `src/iosMain`: Contains iOS-specific code.
*   `./iosApp`: The iOS application project.

## How to Build and Run

### Android

To build and run the development version of the Android app, you can use the run configuration in Android Studio or execute the following command in your terminal:

```shell
./gradlew :composeApp:assembleDebug
```

On Windows:

```shell
.\gradlew.bat :composeApp:assembleDebug
```

### iOS

To build and run the iOS app, you can use the run configuration in Android Studio/Fleet or open the `iosApp` directory in Xcode and run it from there.

---

This project is based on the official Kotlin Multiplatform templates. To learn more, visit the [Kotlin Multiplatform documentation](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html).
