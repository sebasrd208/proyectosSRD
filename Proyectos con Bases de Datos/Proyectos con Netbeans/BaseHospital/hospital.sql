-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-10-2024 a las 16:28:23
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hospital`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `ID_Alumnos` int(11) NOT NULL,
  `usuario` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contrasena` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`ID_Alumnos`, `usuario`, `contrasena`) VALUES
(1, 'Sebastian', 'ERK28051'),
(2, 'Erick', 'ERK28051');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios_seq`
--

CREATE TABLE `usuarios_seq` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) UNSIGNED NOT NULL,
  `cycle_option` tinyint(1) UNSIGNED NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB;

--
-- Volcado de datos para la tabla `usuarios_seq`
--

INSERT INTO `usuarios_seq` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
(11, 1, 999, 11, 1, 1000, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vacaciones`
--

CREATE TABLE `vacaciones` (
  `EXPEDIENTE` int(11) NOT NULL DEFAULT 0,
  `NOMBRE` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `FUNCION` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `VP1` int(11) NOT NULL,
  `VP2` int(11) NOT NULL,
  `VBR` int(11) NOT NULL,
  `PE` int(11) NOT NULL,
  `LM` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `vacaciones`
--

INSERT INTO `vacaciones` (`EXPEDIENTE`, `NOMBRE`, `FUNCION`, `VP1`, `VP2`, `VBR`, `PE`, `LM`) VALUES
(190, 'ACOSTA REYES MARIA AURORA', 'ORTOPEDISTA', 3, 0, 2, 0, 0),
(123, 'ANDRES SOSA MARIA AURELIA DEL CARMEN', 'APOYO ADMINISTRATIVO', 0, 0, 1, 0, 0),
(29079, 'ARELLANO HERRERA GILBERTO', 'SUBDIRECTOR MEDICO Y EPIDEMIOLOGO', 0, 0, 0, 0, 0),
(105, 'ARENAS JIMENEZ MARIA BENITA', 'ENFERMERA GENERAL', 6, 0, 2, 0, 0),
(12086, 'ARRIAGA HERNANDEZ MARIA ANGELICA', 'ENFERMERA GENERAL', 6, 0, 0, 0, 0),
(18105, 'ASCENSION ESPEJEL JORGE EDEHEL', 'MEDICO GENERAL', 0, 0, 0, 0, 0),
(154, 'AVILA RODRIGUEZ GABRIELA', 'ENFERMERA GENERAL', 10, 0, 1, 0, 0),
(40681, 'AXALCO AGUILAR KARLA ARELY', 'ENFERMERA GENERAL', 0, 0, 0, 0, 0),
(13476, 'BAEZ BORZANI LETICIA', 'AUXILIAR DE COCINA', 6, 0, 1, 0, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`ID_Alumnos`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
