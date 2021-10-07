# Run Docker DB
```docker run --name challenge -e "POSTGRES_PASSWORD=admin123" -e "POSTGRES_DB=challenge" -p 5432:5432 -d postgres```