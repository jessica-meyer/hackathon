# Contributing

## Setting Up

Clone the repo:
```bash
git clone https://github.com/jessica-meyer/hackathon.git
cd hackathon
```

## Creating Branches

Always create a new branch for your work:
```bash
git checkout -b feature/your-feature-name
```

Examples:
- feature/chat-ui
- bugfix/login-crash
- refactor/api-calls

### Push your branch:
```bash
git add . # Add all changes to the staging area
git commit -S -m "feat: add awesome stuff" # Commit with a descriptive message
git push -u origin feature/your-feature-name # Push the changes to the remote repository
```

### Syncing with Main

Before starting work or opening a PR:
```bash
git checkout main
git pull origin main
```

### Keep your branch up-to-date
```bash
git fetch origin # Fetch the latest changes from the remote repository
git merge origin/main # Merge the latest main branch changes into your feature branch
git push # Push the changes to the remote repository
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
```bash
git commit -m "Add camera permission check"
```
- Make small, focused PRs
- Document your code if necessary
