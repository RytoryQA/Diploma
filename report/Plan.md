# План тестирования мобильного приложения "Мобильный хоспис"
 ## Описание приложения
Приложение  осуществляет функции по обработке претензий хосписа, содержит новостной блок и тематические цитаты.
## Описание структуры и компонентов приложения
1. Страница авторизации
    - Поле ввода "Login"
    - Поле ввода "Password"
    - Кнопка "Sign in"
2. Элементы управления и компоненты
    - Authorization
    - Main
    - News
    - Creating News
    - Editing News
    - Filter News
    - Control panel
    - About 
3. Страница главного меню
    - Список сообщений
    - Новостной блок
    - Панель с элементами управления списком: изменить последовательность, настроить, редактировать, свернуть
4. Страница новостей
    - Список новостей
    - Новостной блок
    - Панель с элементами управления списком: изменить последовательность, настроить, редактировать, свернуть
5. Страница о нас
    - Строка с гипертекстом о политике конфиденцильности
    - Строка с гипертекстом о правилах пользования
6. Страница с тематическими цитатами
  
## Виды тестирования
* Функциональное
* Нефункциональное
    - Доступности
    - Удобства использования
    - Безопасности
    - Производительности
    - Совместимости
    - Стрессовое
## Стратегия тестирования
1. Составление чек-листа для проверки приложения
1. Описание тест-кейсов для проверки приложения
1. Ручное тестирование реализованного функционала
1. Описание дефектов приложения
1. Определение тестов, подлежащих автоматизации
1. Автоматизация определенных тестов
1. Составление отчета о тестироваии
## Сценарии автоматизации
Можно увидеть в файле [Cases](https://github.com/RytoryQA/Diploma/blob/main/Cases.xlsx) ID: 1-4
## Перечень используемых инструментов
1. Android Studio – наиболее популярная среда разработки для работы с платформой Android
2. Java - типизированный объектно-ориентированный язык программирования общего назначения
1. Espresso - тестовый фреймворк с открытым исходным кодом, интегрированный в Android Studio
1. Allure - фреймворк  для построения отчетов автотестов
## Устройства для тестированя
Phone: Pixel 3a API 29
## Перечень и описание возможных рисков при автоматизации
1. Отсутствие детальной информации о работе приложения.
3. Наличие бага, затрудняющего проверку приложения.
4. Изменение структуры сервиса.
5. Технические неполадки при использовании девайсов.
6. Нарушение в установке и запуске эмулятора в Android Studio.
## Критерии начала тестирования
1. Приложение запускается
2. Эмулятор на Android API 29 настроен и запущен
3. Необходимая документация для тестирования создана и доступна:
    - Plan.md - файл содержит план по тестированию приложения
    - Check - файл в формате .xlsx содержит чек-лист необходимых проверок приложения
    - Cases - файл в формате .xlsx содержит тест-кейсы, охватывающие ключевые функции приложения
    - README.md - файл содержит описание порядка запуска авто-тестов
4. Написаны авто-тесты для основного функционала приложения
5. Инструмент для отчетности Allure настроен и готов к работе
## Критерии окончания тестрования
1. Проект собирается и работает на Android API 29
2. В проекте есть UI-тесты
4. Тесты запускаются
5. Найденные баги оформлены в Issues
6. Подготовлены отчеты в Allure с результатами тестирования
## Интервальная оценка с учётом рисков
Подготовка плана тестирования, чек-листа и тест-кейсов: 10-16 ч.  
Автоматизация тестов: 20-24 ч.  
Подготовка отчета: 1-2 ч.  

