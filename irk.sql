-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Июн 10 2024 г., 09:51
-- Версия сервера: 10.4.32-MariaDB
-- Версия PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `irk`
--

-- --------------------------------------------------------

--
-- Структура таблицы `instrument`
--

CREATE TABLE `instrument` (
  `id` int(11) NOT NULL,
  `instrument_number` int(11) DEFAULT NULL,
  `tech_card_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Дамп данных таблицы `instrument`
--

INSERT INTO `instrument` (`id`, `instrument_number`, `tech_card_id`) VALUES
(1, 123, NULL),
(2, 12, NULL),
(3, 13, 11),
(4, 23, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `instrument_parts`
--

CREATE TABLE `instrument_parts` (
  `instrument_id` int(11) NOT NULL,
  `part_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Дамп данных таблицы `instrument_parts`
--

INSERT INTO `instrument_parts` (`instrument_id`, `part_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 2),
(3, 1),
(3, 3),
(4, 2),
(4, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `irk_worker`
--

CREATE TABLE `irk_worker` (
  `id` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `irk_worker_tech_cards`
--

CREATE TABLE `irk_worker_tech_cards` (
  `irk_worker_id` int(11) NOT NULL,
  `tech_cards_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `part`
--

CREATE TABLE `part` (
  `id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `specification` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Дамп данных таблицы `part`
--

INSERT INTO `part` (`id`, `quantity`, `reference`, `specification`, `type`) VALUES
(1, 3, 'Корпус1', 'A111-111A11-11A', 'Body'),
(2, 3, 'Пластина1', 'B222-222B22-22B', 'Plate'),
(3, 3, 'Цанга1', 'C333-333C33-33C', 'Cang');

-- --------------------------------------------------------

--
-- Структура таблицы `techcard_instruments`
--

CREATE TABLE `techcard_instruments` (
  `instrument_id` int(11) NOT NULL,
  `tech_card_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Дамп данных таблицы `techcard_instruments`
--

INSERT INTO `techcard_instruments` (`instrument_id`, `tech_card_id`) VALUES
(1, 5),
(2, 5),
(3, 5),
(1, 6),
(2, 7),
(3, 8),
(3, 11),
(1, 2),
(2, 2),
(2, 3),
(3, 3),
(3, 4),
(4, 4);

-- --------------------------------------------------------

--
-- Структура таблицы `technitian`
--

CREATE TABLE `technitian` (
  `id` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `technitian_tech_cards`
--

CREATE TABLE `technitian_tech_cards` (
  `tech_cards_id` int(11) NOT NULL,
  `technitian_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `tech_card`
--

CREATE TABLE `tech_card` (
  `id` int(11) NOT NULL,
  `card_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Дамп данных таблицы `tech_card`
--

INSERT INTO `tech_card` (`id`, `card_id`) VALUES
(2, '12'),
(3, '23'),
(4, '34'),
(11, '3');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `instrument`
--
ALTER TABLE `instrument`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5x85p8drgo0x4wn3xvqgpnakj` (`tech_card_id`);

--
-- Индексы таблицы `instrument_parts`
--
ALTER TABLE `instrument_parts`
  ADD KEY `FK1hclb0em4t2vpccbbr5gi750e` (`part_id`),
  ADD KEY `FK51opkemhxktxbywenlc8dw3pi` (`instrument_id`);

--
-- Индексы таблицы `irk_worker`
--
ALTER TABLE `irk_worker`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `irk_worker_tech_cards`
--
ALTER TABLE `irk_worker_tech_cards`
  ADD UNIQUE KEY `UK_eh54nyff25dbv6goin4sqcxpu` (`tech_cards_id`),
  ADD KEY `FK7s07pgjywd5c7w2pl5q7i2baa` (`irk_worker_id`);

--
-- Индексы таблицы `part`
--
ALTER TABLE `part`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `techcard_instruments`
--
ALTER TABLE `techcard_instruments`
  ADD KEY `FKmv5bsa1s592eb3ar32osuhqs9` (`instrument_id`),
  ADD KEY `FKjdws3xlq0amrtdbkk65dclwej` (`tech_card_id`);

--
-- Индексы таблицы `technitian`
--
ALTER TABLE `technitian`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `technitian_tech_cards`
--
ALTER TABLE `technitian_tech_cards`
  ADD UNIQUE KEY `UK_mlfpt3iy59x0aw8w8qj9xit2n` (`tech_cards_id`),
  ADD KEY `FKhbirlflbmdp653r0r3rt5wff7` (`technitian_id`);

--
-- Индексы таблицы `tech_card`
--
ALTER TABLE `tech_card`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `instrument`
--
ALTER TABLE `instrument`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT для таблицы `irk_worker`
--
ALTER TABLE `irk_worker`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `part`
--
ALTER TABLE `part`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `technitian`
--
ALTER TABLE `technitian`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `tech_card`
--
ALTER TABLE `tech_card`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `instrument`
--
ALTER TABLE `instrument`
  ADD CONSTRAINT `FK5x85p8drgo0x4wn3xvqgpnakj` FOREIGN KEY (`tech_card_id`) REFERENCES `tech_card` (`id`);

--
-- Ограничения внешнего ключа таблицы `instrument_parts`
--
ALTER TABLE `instrument_parts`
  ADD CONSTRAINT `FK1hclb0em4t2vpccbbr5gi750e` FOREIGN KEY (`part_id`) REFERENCES `part` (`id`),
  ADD CONSTRAINT `FK51opkemhxktxbywenlc8dw3pi` FOREIGN KEY (`instrument_id`) REFERENCES `instrument` (`id`);

--
-- Ограничения внешнего ключа таблицы `irk_worker_tech_cards`
--
ALTER TABLE `irk_worker_tech_cards`
  ADD CONSTRAINT `FK4q69vyjvjmatq6ko26sbxkvg9` FOREIGN KEY (`tech_cards_id`) REFERENCES `tech_card` (`id`),
  ADD CONSTRAINT `FK7s07pgjywd5c7w2pl5q7i2baa` FOREIGN KEY (`irk_worker_id`) REFERENCES `irk_worker` (`id`);

--
-- Ограничения внешнего ключа таблицы `techcard_instruments`
--
ALTER TABLE `techcard_instruments`
  ADD CONSTRAINT `FKjdws3xlq0amrtdbkk65dclwej` FOREIGN KEY (`tech_card_id`) REFERENCES `tech_card` (`id`),
  ADD CONSTRAINT `FKmv5bsa1s592eb3ar32osuhqs9` FOREIGN KEY (`instrument_id`) REFERENCES `instrument` (`id`);

--
-- Ограничения внешнего ключа таблицы `technitian_tech_cards`
--
ALTER TABLE `technitian_tech_cards`
  ADD CONSTRAINT `FK1fppexr8w664s6oq5r2exgmnf` FOREIGN KEY (`tech_cards_id`) REFERENCES `tech_card` (`id`),
  ADD CONSTRAINT `FKhbirlflbmdp653r0r3rt5wff7` FOREIGN KEY (`technitian_id`) REFERENCES `technitian` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
