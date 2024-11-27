# Java Streams 
Java Streams — это мощный инструмент для работы с коллекциями данных в декларативном стиле. Они позволяют выполнять операции над данными (например, фильтрацию, сортировку, преобразование) с минимальным количеством кода.
________________________________________
## Основные особенности:
1.	Не хранят данные: Стримы обрабатывают данные, но сами их не хранят.
2.	Ленивость: Операции выполняются только при вызове терминальной операции.
3.	Одноразовое использование: После обработки стрим нельзя использовать повторно.
4.	Параллельность: Стримы легко распараллеливаются для повышения производительности.
________________________________________
## Основные виды операций:
### 1.	Промежуточные (Intermediate): Возвращают новый стрим, не выполняя вычисления сразу.
*	filter: Фильтрация элементов.
*	map: Преобразование элементов.
*	sorted: Сортировка.
*	distinct: Удаление дубликатов.

### 2.	Терминальные (Terminal): Завершают стрим, выполняя вычисления.
*	forEach: Итерация по элементам.
*	collect: Сбор данных в коллекцию.
*	count: Подсчёт элементов.
*	reduce: Сведение элементов к одному значению.