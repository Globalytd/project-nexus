package org.globalytd.projectnexus.feature.home.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.globalytd.projectnexus.core.designsystem.component.NexusBottomNavigationBar
import org.globalytd.projectnexus.core.designsystem.component.NexusScreenScaffold
import org.globalytd.projectnexus.core.navigation.NexusDestinations
import org.globalytd.projectnexus.core.navigation.TopLevelDestination
import org.globalytd.projectnexus.feature.blueprints.presentation.BlueprintListRoute
import org.globalytd.projectnexus.feature.community.presentation.AchievementsRoute
import org.globalytd.projectnexus.feature.community.presentation.CommunityFeedRoute
import org.globalytd.projectnexus.feature.community.presentation.LeaderboardRoute
import org.globalytd.projectnexus.feature.home.presentation.HomeRoute
import org.globalytd.projectnexus.feature.invest.presentation.AllocationRoute
import org.globalytd.projectnexus.feature.invest.presentation.InvestRoute
import org.globalytd.projectnexus.feature.invest.presentation.RebalancingRoute
import org.globalytd.projectnexus.feature.learning.presentation.LearningHomeRoute
import org.globalytd.projectnexus.feature.notifications.presentation.NotificationsRoute
import org.globalytd.projectnexus.feature.portfolio.presentation.PortfolioRoute
import org.globalytd.projectnexus.feature.security.presentation.GuardianRecoveryRoute
import org.globalytd.projectnexus.feature.security.presentation.SecurityRoute
import org.globalytd.projectnexus.feature.settings.presentation.ProfileRoute
import org.globalytd.projectnexus.feature.settings.presentation.SettingsRoute
import org.globalytd.projectnexus.feature.tax.presentation.TaxCenterRoute

fun NavGraphBuilder.mainGraph(navController: NavHostController) {
    composable(NexusDestinations.MAIN) {
        MainScreen()
    }
}

@Composable
fun MainScreen() {
    val innerNavController = rememberNavController()
    val navBackStackEntry by innerNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val currentTopLevel = TopLevelDestination.entries.find { destination ->
        currentDestination?.hierarchy?.any { it.route == destination.route } == true
    }

    NexusScreenScaffold {
        Scaffold(
            bottomBar = {
                NexusBottomNavigationBar(
                    destinations = TopLevelDestination.entries,
                    currentDestination = currentTopLevel,
                    onDestinationSelected = { destination ->
                        innerNavController.navigate(destination.route) {
                            popUpTo(innerNavController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = innerNavController,
                startDestination = TopLevelDestination.HOME.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(TopLevelDestination.HOME.route) {
                    HomeRoute(
                        onNavigateToPortfolio = { innerNavController.navigate(TopLevelDestination.PORTFOLIO.route) },
                        onNavigateToInvest = { innerNavController.navigate(TopLevelDestination.INVEST.route) }
                    )
                }
                composable(TopLevelDestination.PORTFOLIO.route) {
                    PortfolioRoute(
                        onNavigateToAllocation = { innerNavController.navigate(NexusDestinations.ALLOCATION) },
                        onNavigateToRebalancing = { innerNavController.navigate(NexusDestinations.REBALANCING) }
                    )
                }
                composable(TopLevelDestination.INVEST.route) {
                    InvestRoute(
                        onNavigateToAllocation = { innerNavController.navigate(NexusDestinations.ALLOCATION) },
                        onNavigateToRebalancing = { innerNavController.navigate(NexusDestinations.REBALANCING) }
                    )
                }
                composable(TopLevelDestination.LEARN.route) {
                    LearningHomeRoute()
                }
                composable(TopLevelDestination.COMMUNITY.route) {
                    CommunityFeedRoute(
                        onNavigateToLeaderboard = { innerNavController.navigate(NexusDestinations.LEADERBOARD) },
                        onNavigateToAchievements = { innerNavController.navigate(NexusDestinations.ACHIEVEMENTS) }
                    )
                }
                composable(NexusDestinations.ALLOCATION) {
                    AllocationRoute(onBackClick = { innerNavController.popBackStack() })
                }
                composable(NexusDestinations.REBALANCING) {
                    RebalancingRoute(onBackClick = { innerNavController.popBackStack() })
                }
                composable(NexusDestinations.BLUEPRINT_LIST) {
                    BlueprintListRoute()
                }
                composable(NexusDestinations.TAX_CENTER) {
                    TaxCenterRoute()
                }
                composable(NexusDestinations.NOTIFICATIONS) {
                    NotificationsRoute()
                }
                composable(NexusDestinations.SECURITY) {
                    SecurityRoute(
                        onNavigateToGuardianRecovery = {
                            innerNavController.navigate(NexusDestinations.GUARDIAN_RECOVERY)
                        }
                    )
                }
                composable(NexusDestinations.GUARDIAN_RECOVERY) {
                    GuardianRecoveryRoute(onBackClick = { innerNavController.popBackStack() })
                }
                composable(NexusDestinations.PROFILE) {
                    ProfileRoute(onBackClick = { innerNavController.popBackStack() })
                }
                composable(NexusDestinations.SETTINGS) {
                    SettingsRoute(onBackClick = { innerNavController.popBackStack() })
                }
                composable(NexusDestinations.LEADERBOARD) {
                    LeaderboardRoute(onBackClick = { innerNavController.popBackStack() })
                }
                composable(NexusDestinations.ACHIEVEMENTS) {
                    AchievementsRoute(onBackClick = { innerNavController.popBackStack() })
                }
            }
        }
    }
}
