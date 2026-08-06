# Adding a Screen

Follow these steps every time you add a new screen.

## 1 – Add a route constant

In `core/navigation/NexusNavDestinations.kt`, add a constant:

```kotlin
const val MY_FEATURE = "my_feature"
```

## 2 – Create the screen file

```
feature/myfeature/presentation/MyFeatureScreen.kt
```

Use three layers:

```kotlin
@Composable
fun MyFeatureRoute(onBackClick: () -> Unit, viewModel: MyFeatureViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    MyFeatureScreen(uiState = uiState, onAction = viewModel::onAction, onBackClick = onBackClick)
}

@Composable
fun MyFeatureScreen(uiState: MyFeatureUiState, onAction: (MyFeatureUiAction) -> Unit, onBackClick: () -> Unit) {
    // ...
}
```

## 3 – Create the ViewModel

```kotlin
@HiltViewModel
class MyFeatureViewModel @Inject constructor(private val repo: MyRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(MyFeatureUiState())
    val uiState: StateFlow<MyFeatureUiState> = _uiState.asStateFlow()
    fun onAction(action: MyFeatureUiAction) { /* ... */ }
}
```

## 4 – Add to navigation

In the relevant navigation file, add a `composable(NexusDestinations.MY_FEATURE)` entry.

## 5 – Add Compose Previews

Add at least one `@Preview` for the screen.

## 6 – Test

Write a ViewModel unit test and (optionally) a Compose UI test.
