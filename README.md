# Fipe Project

## Overview

The Fipe project is designed to fetch information about Brazilian vehicles, specifically the Fipe
table values. The primary goal is to utilize the Fipe API to gather accurate and up-to-date
information on various vehicles in Brazil.

## Fipe API

For this project, we are using the [Fipe API](https://deividfortuna.github.io/fipe/) to access
detailed information about Brazilian vehicles and their corresponding Fipe table values.

## Project Purpose

The Fipe project serves as an exploration of different features, architectures, and new trends in
the Android development domain. Through this project, we aim to gain insights into the latest
advancements in Android app development and implement best practices.

## Features

- Fetch vehicle information using the Fipe API.
- Display Fipe table values for different types of vehicles.
- Explore and implement various Android features and architectures.

## Technologies and Tools

- Android Studio
- Kotlin
- Fipe API

## Branch Organization

The branches in this repository follow a specific organization:

- **main**: The main branch represents the initial approach with no specific architectural pattern
  or best practices.
- **dagger2**: Branch focused on integrating Dagger 2 for dependency injection.
- **databinding**: Branch introducing data binding to the project.
- **mvvm**: A branch representing the modification of the main branch, introducing the MVVM
  architectural pattern.
- **room-db**: A branch focused on integrating Room Database.

### Functional Feature Branches

#### dagger2

- Explanation: This branch focuses on integrating Dagger 2 for dependency injection, enhancing the
  project's maintainability and testability.

#### databinding

- Explanation: The `databinding` branch introduces data binding to the project, simplifying UI
  logic and making it more declarative.

#### mvvm

- Explanation: The `mvvm` branch represents the modification of the main branch, introducing the MVVM
  architectural pattern for improved separation of concerns.

#### room-db

- Explanation: The `room-db` branch focuses on integrating Room Database to efficiently handle local
  data storage within the application.

### Implementation Branches

#### impl-1 (Placeholder)

- Explanation: This branch will be used for specific implementation details related to the
  functional branches. It is currently a placeholder and will be populated with implementation
  details as needed.

### Note on Branches

- Branches can be used as a base for creating new branches. For example, the `dagger2` branch can be
  used as a base for both `mvvm` and `room-db`.
- Branches can be merged during development, allowing the incorporation of multiple features and
  architectural patterns.
- The `main` branch will always reflect the initial approach with no specific architectural pattern.

## Getting Started

To get started with the Fipe project, follow these steps:

1. Clone the repository to your local machine.
2. Open the project in Android Studio.
3. Explore the codebase, paying attention to different features and architectural patterns in
   different branches.
4. Run the application on an Android emulator or a physical device.

## Contribution Guidelines

If you would like to contribute to the Fipe project, please follow these guidelines:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and ensure the code passes any existing tests.
4. Submit a pull request with a clear description of your changes.

## License

This project is licensed under the [MIT License](LICENSE).

## Contact

For any questions or feedback, feel free to reach out to the project maintainers:

- João Gouveia
- j.lucas.gouveia@gmail.com
