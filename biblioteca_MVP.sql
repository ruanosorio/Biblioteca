-- phpMyAdmin SQL Dump
-- version 4.0.4.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 04, 2015 at 08:15 PM
-- Server version: 5.6.13
-- PHP Version: 5.4.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `biblioteca`
--
CREATE DATABASE IF NOT EXISTS `biblioteca` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `biblioteca`;

-- --------------------------------------------------------

--
-- Table structure for table `categoria`
--

CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=43 ;

--
-- Dumping data for table `categoria`
--

INSERT INTO `categoria` (`id`, `nome`) VALUES
(1, 'Administração'),
(2, 'Arquitetura'),
(3, 'Artes e Fotografia'),
(4, 'Autoajuda'),
(5, 'Biografias'),
(6, 'Ciências Biológicas'),
(7, 'Ciências Exatas'),
(8, 'Ciências Sociais'),
(9, 'Comportamento'),
(10, 'Comunicação'),
(11, 'Concursos Públicos'),
(12, 'Dicionários'),
(13, 'Didáticos'),
(14, 'Direito'),
(15, 'Economia'),
(16, 'Educação'),
(17, 'Engenharia'),
(18, 'Ensino de Línguas'),
(19, 'Esoterismo'),
(20, 'Esportes e Lazer'),
(21, 'Filosofia'),
(22, 'Gastronomia'),
(23, 'Geografia'),
(24, 'HQs'),
(25, 'História'),
(26, 'Humor e Entretenimento'),
(27, 'Infantil'),
(28, 'Informática e Tecnologia'),
(29, 'LGBT'),
(30, 'Literatura Internacional'),
(31, 'Literatura Nacional'),
(32, 'Medicina'),
(33, 'Metodologia de Pesquisa'),
(34, 'Pets'),
(35, 'Psicologia'),
(36, 'Religião'),
(37, 'Saúde, Fitness e Beleza'),
(38, 'Sustentabilidade'),
(39, 'Teen'),
(40, 'Viagem'),
(41, 'Videogames'),
(42, 'teste');

-- --------------------------------------------------------

--
-- Table structure for table `editora`
--

CREATE TABLE IF NOT EXISTS `editora` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `emprestimo`
--

CREATE TABLE IF NOT EXISTS `emprestimo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataEmprestimo` timestamp NULL DEFAULT NULL,
  `dataDevolucao` timestamp NULL DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_livro` int(11) DEFAULT NULL,
  `ind_devolvido` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `emprestimo`
--

INSERT INTO `emprestimo` (`id`, `dataEmprestimo`, `dataDevolucao`, `id_usuario`, `id_livro`, `ind_devolvido`) VALUES
(1, '2015-10-21 23:33:14', '2015-12-04 18:15:33', 9, 3, 'S'),
(2, '2015-10-21 23:38:28', '2015-10-28 23:38:28', 10, 4, 'N'),
(3, '2015-10-15 03:00:00', '2015-10-22 02:00:00', 2, 1, 'N'),
(4, '2015-10-23 02:00:00', '2015-12-04 18:33:47', 10, 3, 'S'),
(5, '2015-10-20 02:00:00', '2015-10-21 02:00:00', 5, 2, 'S'),
(6, '2015-10-23 02:00:00', '2015-10-30 02:00:00', 10, 1, 'N'),
(7, '2015-12-04 16:28:35', '2015-12-11 16:28:35', 1, 7, 'N');

-- --------------------------------------------------------

--
-- Table structure for table `estoque`
--

CREATE TABLE IF NOT EXISTS `estoque` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade` int(11) DEFAULT NULL,
  `id_livro` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `livro`
--

CREATE TABLE IF NOT EXISTS `livro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) DEFAULT NULL,
  `autor` varchar(250) DEFAULT NULL,
  `isbn` varchar(50) DEFAULT NULL,
  `ano` int(11) DEFAULT NULL,
  `id_editora` int(11) DEFAULT NULL,
  `id_categoria` int(11) DEFAULT NULL,
  `descricao` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `livro`
--

INSERT INTO `livro` (`id`, `titulo`, `autor`, `isbn`, `ano`, `id_editora`, `id_categoria`, `descricao`) VALUES
(1, 'INTELIGENCIA EMOCIONAL', 'DANIEL GOLEMAN', '34424544444444', 2014, NULL, 1, 'Daniel Goleman serve-nos de guia numa jornada através da visão científica das emoções de alguns dos mais confusos momentos das nossas próprias vidas e o mundo que nos rodeia.'),
(2, 'Use a cabeça JAVA 2013', 'Seu Java', '121451545', 2013, 0, 0, 'Como aprender a linguagem de programação JAVA'),
(3, 'Use a cabeça JAVA 2010', 'Seu Java', '20154520', 2306, NULL, 1, 'Como aprender a linguagem de programação JAVA.\nComo aprender a linguagem de programação JAVA .\nComo aprender a linguagem de programação JAVA .\nComo aprender a linguagem de programação JAVA '),
(4, 'Aprenda PHP 5', 'TESTE ', '4561654415', 2012, NULL, 28, 'Aprenda PHP 5'),
(5, 'Qualqwer', 'Seu ', '121451545', 2015, 0, 0, ' JAVA'),
(6, 'teste livro categoria', 'Ruan', '15237436653', 0, NULL, 1, 'Testando a combo categoria O fim da jornada é compreender o que significa trazer inteligência à emoção O fim da jornada é compreender o que significa trazer inteligência à emoção'),
(7, 'Oracle Developer', 'Oracle JR', '20150103', 2014, 0, 28, 'Oracle mysql, sql, crm...'),
(8, 'Livro ', 'eu', '1223985hjhdugh', 2015, 0, 5, 'fddfgdgdg');

-- --------------------------------------------------------

--
-- Table structure for table `telefone`
--

CREATE TABLE IF NOT EXISTS `telefone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` bigint(20) DEFAULT NULL,
  `ddd` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` bigint(50) DEFAULT NULL,
  `nome` varchar(250) DEFAULT NULL,
  `telefone` varchar(50) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `sexo` varchar(18) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `usuario` varchar(100) DEFAULT NULL,
  `senha` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id`, `matricula`, `nome`, `telefone`, `cpf`, `sexo`, `email`, `usuario`, `senha`) VALUES
(1, 6313, 'Ruan', '561564565', '', '', '', '', ''),
(2, 1, 'Teste1', '00012452', '', '', '', '', ''),
(3, 2, 'Teste 2', '5854552', '', '', '', '', ''),
(4, 3, 'Teste 3', '0012245', '', '', '', '', ''),
(5, 5, 'Teste 5 ', '55555555', '', '', '', '', ''),
(6, 6, 'Teste 6', '666666', '', '', '', '', ''),
(7, 7887, 'Teste 7', '777454', '', '', '', '', ''),
(8, 2015, 'Teste', '9875464', '', '', '', '', ''),
(9, 1999, 'Teste 9', '999999', '', '', '', '', ''),
(10, 2015, 'Teste', '9875464', '', '', '', '', ''),
(11, 20152, 'Lossurdo', '56444', '', '', '', '', ''),
(12, 18727, 'teste usuário', '842378937', '', '', '', '', ''),
(13, 201545, 'testecadastro', '1234456', '111.111.111-11', '0', '', '', ''),
(14, 12122, 'user', '12223', '111.111.111-11', '1', 'u', '111111111', '5555555'),
(15, 174604, 'MVP', '99999999999', '   .   .   -  ', NULL, '', '', ''),
(16, 2323, 'testex', '43264625552', '   .   .   -  ', NULL, '', '', ''),
(17, 123456, 'testetestetetetetettsttsts', '20927466', '111.111.111-11', NULL, 'testetesttetet@jdh.com', 'teste@ht.com', '1234');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
