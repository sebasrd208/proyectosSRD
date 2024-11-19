-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-11-2024 a las 23:47:50
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
-- Base de datos: `bd_ds`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `nombre_cliente` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `mail_cliente` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `tel_cliente` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `dir_cliente` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `ultima_modificacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Esta tabla es para registrar a los clientes del sistema.';

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombre_cliente`, `mail_cliente`, `tel_cliente`, `dir_cliente`, `ultima_modificacion`) VALUES
(1, 'Erick Ramiro', 'erikramiri230@gmail.com', '5539250195', 'Privada 12 de Octubre', 'erick_282'),
(2, 'Aurelia Diaz', 'lalaramiro@gmail.com', '5548355900', 'Privada 12 de Octubre', 'sebasrd_208'),
(3, 'Luis Alejandro Albuerme', 'albuermeluis@gmail.com', '2312321895', 'Calle Aragon #5', 'cristogar_908'),
(4, 'Rie Takahashi', 'takahashi_rie180@gmail.com', '3635263288', 'Calle Kioto #12', 'nagisa_909');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipos`
--

CREATE TABLE `equipos` (
  `id_equipo` int(50) NOT NULL,
  `id_cliente` int(50) NOT NULL,
  `tipo_equipo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `marca` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `modelo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `num_serie` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `dia_ingreso` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `mes_ingreso` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `annio_ingreso` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `observaciones` longtext COLLATE utf8_unicode_ci NOT NULL,
  `estatus` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ultima_modificacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `comentarios_tecnicos` longtext COLLATE utf8_unicode_ci NOT NULL,
  `revision_tecnica_de` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Esta tabla es para registrar los equipos de los clientes';

--
-- Volcado de datos para la tabla `equipos`
--

INSERT INTO `equipos` (`id_equipo`, `id_cliente`, `tipo_equipo`, `marca`, `modelo`, `num_serie`, `dia_ingreso`, `mes_ingreso`, `annio_ingreso`, `observaciones`, `estatus`, `ultima_modificacion`, `comentarios_tecnicos`, `revision_tecnica_de`) VALUES
(1, 2, 'Laptop', 'Toshiba', '038SRD7676', '939848982989', '17', '10', '2024', 'Falla el panel tactil del mouse', 'En revisión', 'sebasrd_208', '', 'Sebastian Diaz'),
(2, 1, 'Smartphone', 'ZTE', 'A7030', '326283869', '16', '10', '2024', 'Pantalla rota', 'Reparado', 'sebasrd_208', 'SalIo excelente la reparación', 'Sebastian Diaz'),
(3, 3, 'Smartphone', 'Motorola', 'G20', '9258385979949', '17', '10', '2024', 'Falla en la entrada de entrada de carga\nPantalla', 'Reparado', 'cristogar_908', 'Sin observaciones', 'Cristofer Garcia'),
(4, 3, 'Impresora', 'Brother', 'L120', '2478343597', '17', '10', '2024', 'No funciona el deposito de tinta', 'No reparado', 'sebasrd_208', '', 'Sebastian Diaz'),
(7, 4, 'Laptop', 'Allenware', 'X3944', '8948395787547', '17', '10', '2024', 'Pantalla rota y falla la camara', 'Reparado', 'cristogar_908', 'En efecto es música', 'Cristofer Garcia'),
(9, 2, 'Smartphone', 'Acer', 'M500', '2437248593758', '17', '10', '2024', 'Le falla el touch', 'En revisión', 'sebasrd_208', '', 'Sebastian Diaz'),
(10, 1, 'Smartphone', 'Samsung', 'Galaxy Ace', '2908940953895', '17', '10', '2024', 'Pantalla rota', 'Nuevo ingreso', 'sebasrd_208', '', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nombre_usuario` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `telefono` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `tipo_nivel` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `estatus` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `registrado_por` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Esta tabla es para registrar a los usuarios del sistema.';

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombre_usuario`, `email`, `telefono`, `username`, `password`, `tipo_nivel`, `estatus`, `registrado_por`) VALUES
(1, 'Sebastian Diaz', 'sebasramirodiaz@gmail.com', '2331288809', 'sebasrd_208', 'SDK24991', 'Administrador', 'Activo', 'sebasrd_208'),
(2, 'Erick Ramiro', 'erikramiri109@gmail.com', '5539250195', 'erick_282', 'ERD28001', 'Administrador', 'Activo', 'sebasrd_208'),
(3, 'Nagisa Shiota', 'shiotanagisa329@gmail.com', '6575897388', 'nagisa_909', 'NGS28991', 'Tecnico', 'Activo', 'sebasrd_208'),
(5, 'Cristofer Garcia', 'cristogar109@gmail.com', '6575656997', 'cristogar_908', 'SRDK24991', 'Capturista', 'Activo', 'sebasrd_208'),
(7, 'Alejandro Albuerme', 'alejandro_albuerne140@gmail.com', '3473984747', 'alejandro_890', 'ALE82821', 'Capturista', 'Activo', 'sebasrd_208');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `equipos`
--
ALTER TABLE `equipos`
  ADD PRIMARY KEY (`id_equipo`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `equipos`
--
ALTER TABLE `equipos`
  MODIFY `id_equipo` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
