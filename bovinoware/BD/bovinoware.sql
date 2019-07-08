-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 29-Jun-2019 às 05:03
-- Versão do servidor: 10.1.35-MariaDB
-- versão do PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bovinoware`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `bovino`
--

CREATE TABLE `bovino` (
  `id` int(11) NOT NULL,
  `idRaca` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `brinco` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `dataNascimento` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `dataCompra` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `pesoCompra` int(11) NOT NULL,
  `valorCompra` double NOT NULL,
  `vendido` tinyint(1) NOT NULL,
  `dataVenda` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `pesoVenda` int(11) DEFAULT NULL,
  `valorVenda` double DEFAULT NULL,
  `registrado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Extraindo dados da tabela `bovino`
--

INSERT INTO `bovino` (`id`, `idRaca`, `idUser`, `brinco`, `dataNascimento`, `dataCompra`, `pesoCompra`, `valorCompra`, `vendido`, `dataVenda`, `pesoVenda`, `valorVenda`, `registrado`) VALUES
(27, 2, 1, '19', '10/01/2019', '27/06/2019', 300, 400, 1, '11/12/2019', 3536, 654, 1),
(30, 12, 1, '23', '22/22/2222', '22/22/2222', 456, 355, 1, '33/33/3333', 765, 657, 1),
(31, 9, 1, '32', '33/33/3333', '22/22/2222', 367, 455, 0, NULL, NULL, NULL, 1),
(32, 8, 1, '21', '33/33/3333', '22/22/2222', 452, 542, 0, NULL, NULL, NULL, 1),
(33, 9, 1, '323', '33/33/3333', '22/22/2222', 367, 455, 0, NULL, NULL, NULL, 1),
(34, 12, 1, '766', '22/22/2222', '22/22/2222', 456, 342, 0, NULL, NULL, NULL, 1),
(35, 2, 12, '123', '15/05/2019', '26/06/2019', 150, 850, 1, '08/07/2019', 160, 1000, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `compra`
--

CREATE TABLE `compra` (
  `id` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idBovino` int(11) NOT NULL,
  `nome` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `endereco` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `telefone` varchar(20) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Extraindo dados da tabela `compra`
--

INSERT INTO `compra` (`id`, `idUsuario`, `idBovino`, `nome`, `endereco`, `telefone`) VALUES
(45, 1, 27, 'Frank Mood', 'Rosangelis', '(18) 3288-1234'),
(48, 1, 30, 'Vitor Santos', 'Rosangelis', '(22)22222-2222'),
(49, 1, 31, 'Vitor Santos', 'Rosangelis', '(22)22222-2222'),
(50, 1, 32, 'Vitor Santos', 'Rosangelis', '(22)22222-2222'),
(51, 1, 33, 'Vitor Santos', 'Rosangelis', '(22)22222-2222'),
(52, 1, 34, 'Vitor Santos', 'Rosangelis', '(22)22222-2222'),
(53, 12, 35, 'José', 'Rua', '(67)99999-9999');

-- --------------------------------------------------------

--
-- Estrutura da tabela `raca`
--

CREATE TABLE `raca` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Extraindo dados da tabela `raca`
--

INSERT INTO `raca` (`id`, `nome`) VALUES
(1, 'Angus'),
(2, 'Nelore'),
(3, 'Brahman'),
(5, 'Caracu'),
(6, 'Charolês'),
(7, 'Gir'),
(8, 'Guzerá'),
(9, 'Indubrasil'),
(10, 'Sindi'),
(11, 'Tabapuã'),
(12, 'Holandês'),
(13, 'Senepol');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `login` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `senha` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `login`, `senha`) VALUES
(1, 'Eduardo', 'ryer', '1234'),
(2, 'test', 'test', '1234'),
(3, 'fdfd', 'fdfs', ''),
(4, '', '', ''),
(5, '', '', ''),
(6, 'test2', 'test2', '1234'),
(7, 'test1', 'test1', 'test1'),
(8, 'hgh', 'xa', 'ddd'),
(9, 'teste', 'teste5', '1234'),
(10, 'teste', 'teste6', '1234'),
(11, 'tesrte', 'test7', '1234'),
(12, 'admin', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE `venda` (
  `idVenda` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idBovino` int(11) NOT NULL,
  `nome` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `endereco` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `telefone` varchar(20) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Extraindo dados da tabela `venda`
--

INSERT INTO `venda` (`idVenda`, `idUsuario`, `idBovino`, `nome`, `endereco`, `telefone`) VALUES
(5, 1, 7, 'xanax', 'xanax', 'xanax'),
(6, 1, 7, 'ssad', 'asdas', 'dass'),
(8, 1, 13, '11/11/11', '11/11/11', '11/11/11'),
(9, 1, 14, '11/11/11', '11/11/11', '11/11/11'),
(10, 1, 8, 'Vitor', 'Rosana', '11111111'),
(11, 1, 1, 'fdsfdsf', 'fsdfdsds', 'fsdfdfdsf'),
(13, 1, 27, 'André C.', 'Nova Pontal', '11111'),
(14, 1, 30, 'Frank', 'Nova Pontal', '(44)44444-4444'),
(15, 12, 35, 'Eduardo', 'Avenida', '(67)98123-4567');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bovino`
--
ALTER TABLE `bovino`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- Indexes for table `raca`
--
ALTER TABLE `raca`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`idVenda`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bovino`
--
ALTER TABLE `bovino`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `compra`
--
ALTER TABLE `compra`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT for table `raca`
--
ALTER TABLE `raca`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `venda`
--
ALTER TABLE `venda`
  MODIFY `idVenda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
