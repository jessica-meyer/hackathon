# Contributing

## Setting Up

Clone the repo:
```
git clone https://github.com/jessica-meyer/hackathon.git
cd hackathon
```

## Creating Branches

Always create a new branch for your work:
```
git checkout -b feature/<your-feature-name>
```

Examples:
- feature/chat-ui
- bugfix/login-crash
- refactor/api-calls

### Push your branch:
```
git push origin feature/<your-feature-name>
```

### Syncing with Main

Before starting work or opening a PR:
```
git checkout main
git pull origin main
```

### To update your branch:
```
git checkout feature/<your-feature>
git merge main
```

## Submitting Pull Requests (PRs)

1. Push your branch
2. Open a PR on GitHub:
   - Base: main
   - Compare: feature/<your-feature>
3. Include a short description
4. Tag at least 1 teammate for review

## Code Reviews

All code must be reviewed before merging to main. Keep your commits clean and descriptive.

### Tips

- Use clear commit messages eg:
```
git commit -m "Add camera permission check"
```
- Make small, focused PRs
- Document your code if necessary
