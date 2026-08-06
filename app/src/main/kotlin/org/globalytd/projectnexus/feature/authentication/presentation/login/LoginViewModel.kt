package org.globalytd.projectnexus.feature.authentication.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.globalytd.projectnexus.domain.repository.AuthRepository

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val loginSuccess: Boolean = false
)

sealed interface LoginUiAction {
    data class EmailChanged(val value: String) : LoginUiAction
    data class PasswordChanged(val value: String) : LoginUiAction
    data object PasswordVisibilityChanged : LoginUiAction
    data object LoginClicked : LoginUiAction
    data object ErrorDismissed : LoginUiAction
    data object LoginSuccessConsumed : LoginUiAction
}

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun onAction(action: LoginUiAction) {
        when (action) {
            is LoginUiAction.EmailChanged -> _uiState.value = _uiState.value.copy(email = action.value)
            is LoginUiAction.PasswordChanged -> _uiState.value = _uiState.value.copy(password = action.value)
            LoginUiAction.PasswordVisibilityChanged -> {
                _uiState.value = _uiState.value.copy(
                    isPasswordVisible = !_uiState.value.isPasswordVisible
                )
            }
            LoginUiAction.LoginClicked -> performLogin()
            LoginUiAction.ErrorDismissed -> _uiState.value = _uiState.value.copy(errorMessage = null)
        }
    }

    private fun performLogin() {
        val state = _uiState.value
        _uiState.value = state.copy(isLoading = true, errorMessage = null)
        viewModelScope.launch {
            val result = authRepository.login(state.email, state.password)
            _uiState.value = if (result.isSuccess) {
                _uiState.value.copy(isLoading = false, loginSuccess = true)
            } else {
                _uiState.value.copy(
                    isLoading = false,
                    errorMessage = result.exceptionOrNull()?.message ?: "Login failed"
                )
            }
        }
    }
}
