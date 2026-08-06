package org.globalytd.projectnexus.core.designsystem.component

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.globalytd.projectnexus.core.navigation.TopLevelDestination
import org.globalytd.projectnexus.core.designsystem.theme.NexusTheme

@Composable
fun NexusBottomNavigationBar(
    destinations: List<TopLevelDestination>,
    currentDestination: TopLevelDestination?,
    onDestinationSelected: (TopLevelDestination) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        destinations.forEach { destination ->
            val selected = destination == currentDestination
            NavigationBarItem(
                selected = selected,
                onClick = { onDestinationSelected(destination) },
                icon = {
                    Icon(
                        imageVector = if (selected) destination.selectedIcon else destination.unselectedIcon,
                        contentDescription = destination.contentDescription
                    )
                },
                label = { Text(destination.label) }
            )
        }
    }
}

@Preview
@Composable
private fun NexusBottomNavigationBarPreview() {
    NexusTheme {
        NexusBottomNavigationBar(
            destinations = TopLevelDestination.entries,
            currentDestination = TopLevelDestination.HOME,
            onDestinationSelected = {}
        )
    }
}
