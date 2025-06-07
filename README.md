# 📦 Java CI/CD with Gradle & GitHub Actions

Пример Java-проекта с Gradle, в котором настроен CI через GitHub Actions.

## 🧰 Стек

- Java 17+
- Gradle (с wrapper)
- GitHub Actions (для CI)


## ⚙️ CI-конфигурация (GitHub Actions)

Всё работает из коробки

## 🚀 Запуск в CI

```bash
Ручной запуск:

Перейдите в Actions tab
Выберите нужный workflow
Нажмите Run workflow
Выберите группу тестов и нажмите Run workflow
```

## ✅ Что делает CI

- Запускается на push и pull request в ветку `main`
- Скачивает зависимости
- Собирает проект
- Прогоняет тесты
- Показывает статус прямо в GitHub
