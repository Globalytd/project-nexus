package org.globalytd.projectnexus

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.globalytd.projectnexus.data.repository.FakeAuthRepository
import org.globalytd.projectnexus.feature.authentication.presentation.login.LoginUiAction
import org.globalytd.projectnexus.feature.authentication.presentation.login.LoginViewModel
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LoginViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var viewModel: LoginViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        viewModel = LoginViewModel(FakeAuthRepository())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `email change updates state`() {
        viewModel.onAction(LoginUiAction.EmailChanged("test@example.com"))
        assertEquals("test@example.com", viewModel.uiState.value.email)
    }

    @Test
    fun `password change updates state`() {
        viewModel.onAction(LoginUiAction.PasswordChanged("secret123"))
        assertEquals("secret123", viewModel.uiState.value.password)
    }

    @Test
    fun `password visibility toggle works`() {
        assertFalse(viewModel.uiState.value.isPasswordVisible)
        viewModel.onAction(LoginUiAction.PasswordVisibilityChanged)
        assertTrue(viewModel.uiState.value.isPasswordVisible)
        viewModel.onAction(LoginUiAction.PasswordVisibilityChanged)
        assertFalse(viewModel.uiState.value.isPasswordVisible)
    }

    @Test
    fun `successful login sets loginSuccess to true`() = runTest {
        viewModel.onAction(LoginUiAction.EmailChanged("demo@projectnexus.app"))
        viewModel.onAction(LoginUiAction.PasswordChanged("anypassword"))
        viewModel.onAction(LoginUiAction.LoginClicked)
        advanceUntilIdle()
        assertTrue(viewModel.uiState.value.loginSuccess)
    }

    @Test
    fun `login with blank email sets error message`() = runTest {
        viewModel.onAction(LoginUiAction.EmailChanged(""))
        viewModel.onAction(LoginUiAction.PasswordChanged("password"))
        viewModel.onAction(LoginUiAction.LoginClicked)
        advanceUntilIdle()
        assertTrue(viewModel.uiState.value.errorMessage != null)
        assertFalse(viewModel.uiState.value.loginSuccess)
    }
}
