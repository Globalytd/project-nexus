# Figma to Compose Workflow

Use this workflow when translating a Figma design into a Compose screen.

## Steps

1. **Identify design tokens** – colours, spacing, typography sizes, corner radii
2. **Map tokens to NexusTheme** – replace Figma values with `MaterialTheme.colorScheme.*`, `LocalNexusSpacing.current.*`, `MaterialTheme.shapes.*`
3. **Identify reusable components** – check `core/designsystem/component/` before building new ones
4. **Build the Compose screen** – follow the Route / Screen / Content pattern
5. **Add a Preview** – annotate with `@Preview(showBackground = true)`
6. **Compare visually** – use Android Studio's Live Preview to compare against the Figma frame
7. **Test interaction** – run on an emulator to verify gestures and transitions
8. **Submit pull request** – include a screenshot in the PR description

## Token Mapping Example

| Figma | Compose |
|---|---|
| `Primary/500` | `MaterialTheme.colorScheme.primary` |
| `Spacing/16` | `LocalNexusSpacing.current.md` |
| `Corner/12` | `MaterialTheme.shapes.medium` |
| `Body/Medium` | `MaterialTheme.typography.bodyMedium` |
