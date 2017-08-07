-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 07-Ago-2017 às 00:50
-- Versão do servidor: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bra_ght`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE `categoria` (
  `codigo` int(100) NOT NULL,
  `creacion` date NOT NULL,
  `modificacion` date DEFAULT NULL,
  `nombre` varchar(200) NOT NULL,
  `tipo` char(1) NOT NULL,
  `valorHora` double NOT NULL,
  `codConfig` int(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`codigo`, `creacion`, `modificacion`, `nombre`, `tipo`, `valorHora`, `codConfig`) VALUES
(1, '2017-07-07', NULL, 'ADMINISTRADOR', 'A', 0, 1),
(2, '2017-07-07', NULL, 'GESTOR', 'U', 0, 4),
(3, '2017-07-07', NULL, 'FUNCIONARIO', 'F', 0, 3),
(4, '2017-07-07', NULL, 'USUARIO', 'U', 0, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `configuracion`
--

CREATE TABLE `configuracion` (
  `codigo` int(100) NOT NULL,
  `creacion` date NOT NULL,
  `modificacion` date DEFAULT NULL,
  `crc` char(1) DEFAULT NULL,
  `edt` char(1) DEFAULT NULL,
  `del` char(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `configuracion`
--

INSERT INTO `configuracion` (`codigo`, `creacion`, `modificacion`, `crc`, `edt`, `del`) VALUES
(1, '2017-07-07', NULL, 'S', 'S', 'S'),
(2, '2017-07-07', NULL, 'N', 'N', 'N'),
(3, '2017-07-07', NULL, 'S', 'S', 'N'),
(4, '2017-07-07', NULL, 'N', 'S', 'S');

-- --------------------------------------------------------

--
-- Estrutura da tabela `controlmensual`
--

CREATE TABLE `controlmensual` (
  `codigo` int(100) NOT NULL,
  `creacion` date NOT NULL,
  `monto` decimal(10,2) NOT NULL,
  `estado` char(1) DEFAULT NULL,
  `codUsuario` int(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `horarios`
--

CREATE TABLE `horarios` (
  `codigo` int(100) NOT NULL,
  `fecha` date NOT NULL,
  `entrada` time NOT NULL,
  `saida` time NOT NULL,
  `descanso` time NOT NULL,
  `total` time NOT NULL,
  `codUsuario` int(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `codigo` int(100) NOT NULL,
  `creacion` date NOT NULL,
  `modificacion` date DEFAULT NULL,
  `nombre` varchar(200) NOT NULL,
  `login` varchar(100) NOT NULL,
  `passw` varchar(64) NOT NULL,
  `valorHora` double NOT NULL,
  `codCategoria` int(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`codigo`, `creacion`, `modificacion`, `nombre`, `login`, `passw`, `valorHora`, `codCategoria`) VALUES
(4, '2017-07-23', '2017-08-04', 'Mujica', 'marihuana', '1234', 0, 1),
(5, '2017-07-23', '2017-08-07', 'Luiz Inacio Lula da Silva', 'lula', '1313', 0, 4),
(7, '2017-08-03', NULL, 'Administrador', 'adm', 'root', 0, 1),
(9, '2017-08-06', NULL, 'PEDRO SILVEIRA', 'pedro', 'ditech', 0, 3),
(10, '2017-08-07', NULL, 'Manolo Pay', 'papa', 'chips', 0, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `codConfig` (`codConfig`);

--
-- Indexes for table `configuracion`
--
ALTER TABLE `configuracion`
  ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `controlmensual`
--
ALTER TABLE `controlmensual`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `codUsuario` (`codUsuario`);

--
-- Indexes for table `horarios`
--
ALTER TABLE `horarios`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `codUsuario` (`codUsuario`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `codCategoria` (`codCategoria`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categoria`
--
ALTER TABLE `categoria`
  MODIFY `codigo` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `configuracion`
--
ALTER TABLE `configuracion`
  MODIFY `codigo` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `controlmensual`
--
ALTER TABLE `controlmensual`
  MODIFY `codigo` int(100) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `horarios`
--
ALTER TABLE `horarios`
  MODIFY `codigo` int(100) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `codigo` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
