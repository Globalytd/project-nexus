# Contributing to Project Nexus

## Getting Started

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/your-feature-name`
3. Make your changes following the conventions below
4. Submit a pull request

## Conventions

- Follow the Route / Screen / Content pattern for all new screens
- Use NexusTheme tokens instead of hard-coded colours and sizes
- Add at least one `@Preview` for every new screen
- Write a ViewModel unit test for every new ViewModel
- Keep business logic out of Composables
- Do not pass `NavController` or `ViewModel` into screen composables

## Pull Request Requirements

See `.github/PULL_REQUEST_TEMPLATE.md` for the required checklist.
