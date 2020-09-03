-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-09-2020 a las 05:01:54
-- Versión del servidor: 10.4.13-MariaDB
-- Versión de PHP: 7.2.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `fabrica`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `automovil`
--

CREATE TABLE `automovil` (
  `IdAutomovil` int(11) NOT NULL,
  `Modelo` varchar(50) NOT NULL,
  `Precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `automovil`
--

INSERT INTO `automovil` (`IdAutomovil`, `Modelo`, `Precio`) VALUES
(1, 'Sedan', 650000),
(2, 'Coupe', 240000),
(3, 'Familiar', 275000),
(4, 'SUV', 23999);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `opcional`
--

CREATE TABLE `opcional` (
  `IdOpcional` int(11) NOT NULL,
  `Tipo` varchar(100) NOT NULL,
  `Precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `opcional`
--

INSERT INTO `opcional` (`IdOpcional`, `Tipo`, `Precio`) VALUES
(1, 'Techo Corredizo', 12000),
(2, 'Aire Acondicionado', 20000),
(3, 'Sistemas de Frenos ABS ', 14000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `IdVenta` int(11) NOT NULL,
  `IdAutomovil` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`IdVenta`, `IdAutomovil`, `Cantidad`, `Total`) VALUES
(41, 3, 1, 275000),
(45, 3, 2, 40000),
(46, 3, 2, 64000),
(47, 3, 2, 64000),
(48, 3, 2, 614000),
(49, 3, 2, 614000),
(50, 3, 2, 550000),
(51, 3, 2, 550000),
(52, 3, 2, 614000),
(53, 3, 2, 614000),
(54, 3, 2, 614000),
(55, 3, 2, 614000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventadetalle`
--

CREATE TABLE `ventadetalle` (
  `IdVentaDetalle` int(11) NOT NULL,
  `IdVenta` int(11) NOT NULL,
  `IdOpcional` int(11) NOT NULL,
  `Precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ventadetalle`
--

INSERT INTO `ventadetalle` (`IdVentaDetalle`, `IdVenta`, `IdOpcional`, `Precio`) VALUES
(8, 41, 1, 12000),
(10, 45, 1, 12000),
(11, 45, 2, 20000),
(12, 46, 1, 12000),
(13, 46, 2, 20000),
(14, 47, 1, 12000),
(15, 47, 2, 20000),
(16, 48, 1, 12000),
(17, 48, 2, 20000),
(18, 49, 1, 12000),
(19, 49, 2, 20000),
(20, 50, 1, 12000),
(21, 50, 2, 20000),
(22, 51, 1, 12000),
(23, 51, 2, 20000),
(24, 52, 1, 12000),
(25, 52, 2, 20000),
(26, 53, 1, 12000),
(27, 53, 2, 20000),
(28, 54, 1, 12000),
(29, 54, 2, 20000),
(30, 55, 1, 12000),
(31, 55, 2, 20000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `automovil`
--
ALTER TABLE `automovil`
  ADD PRIMARY KEY (`IdAutomovil`);

--
-- Indices de la tabla `opcional`
--
ALTER TABLE `opcional`
  ADD PRIMARY KEY (`IdOpcional`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`IdVenta`);

--
-- Indices de la tabla `ventadetalle`
--
ALTER TABLE `ventadetalle`
  ADD PRIMARY KEY (`IdVentaDetalle`,`IdVenta`),
  ADD KEY `ventadetalle_FK` (`IdOpcional`),
  ADD KEY `ventadetalle_FK_1` (`IdVenta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `automovil`
--
ALTER TABLE `automovil`
  MODIFY `IdAutomovil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `opcional`
--
ALTER TABLE `opcional`
  MODIFY `IdOpcional` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `IdVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT de la tabla `ventadetalle`
--
ALTER TABLE `ventadetalle`
  MODIFY `IdVentaDetalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
