-- phpMyAdmin SQL Dump
-- version 4.0.4.2
-- http://www.phpmyadmin.net
--
-- Máquina: localhost
-- Data de Criação: 23-Out-2015 às 23:58
-- Versão do servidor: 5.6.13
-- versão do PHP: 5.4.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de Dados: `biblioteca`
--
CREATE DATABASE IF NOT EXISTS `biblioteca` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `biblioteca`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `editora`
--

CREATE TABLE IF NOT EXISTS `editora` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `emprestimo`
--

CREATE TABLE IF NOT EXISTS `emprestimo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataEmprestimo` timestamp NULL DEFAULT NULL,
  `dataDevolucao` timestamp NULL DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_livro` int(11) DEFAULT NULL,
  `ind_devolvido` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Extraindo dados da tabela `emprestimo`
--

INSERT INTO `emprestimo` (`id`, `dataEmprestimo`, `dataDevolucao`, `id_usuario`, `id_livro`, `ind_devolvido`) VALUES
(1, '2015-10-21 23:33:14', '2015-10-21 23:44:44', 9, 3, 'S'),
(2, '2015-10-21 23:38:28', '2015-10-28 23:38:28', 10, 4, 'N'),
(3, '2015-10-15 03:00:00', '2015-10-22 02:00:00', 2, 1, 'N'),
(4, '2015-10-23 02:00:00', '2015-10-30 02:00:00', 10, 3, 'N'),
(5, '2015-10-20 02:00:00', '2015-10-21 02:00:00', 5, 2, 'S'),
(6, '2015-10-23 02:00:00', '2015-10-30 02:00:00', 10, 1, 'N');

-- --------------------------------------------------------

--
-- Estrutura da tabela `estoque`
--

CREATE TABLE IF NOT EXISTS `estoque` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade` int(11) DEFAULT NULL,
  `id_livro` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `livro`
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `livro`
--

INSERT INTO `livro` (`id`, `titulo`, `autor`, `isbn`, `ano`, `id_editora`, `id_categoria`, `descricao`) VALUES
(1, 'INTELIGENCIA EMOCIONAL', 'DANIEL GOLEMAN', '56154545454', 2015, 1, 1, 'Daniel Goleman serve-nos de guia numa jornada através da visão científica das emoções de alguns dos mais confusos momentos das nossas próprias vidas e o mundo que nos rodeia. O fim da jornada é compreender o que significa trazer inteligência à emoção'),
(2, 'Use a cabeça JAVA 2013', 'Seu Java', '121451545', 2013, 0, 0, 'Como aprender a linguagem de programação JAVA'),
(3, 'Use a cabeça JAVA 2010', 'Seu Java', '20154520', 2010, 0, 0, 'Como aprender a linguagem de programação JAVA '),
(4, 'Aprenda PHP 5', 'Mark', '4561654415', 2014, 0, 0, 'Aprenda PHP');

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefone`
--

CREATE TABLE IF NOT EXISTS `telefone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` bigint(20) DEFAULT NULL,
  `ddd` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` int(11) DEFAULT NULL,
  `nome` varchar(250) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `matricula`, `nome`, `telefone`) VALUES
(1, 6313, 'Ruan', '561564565'),
(2, 1, 'Teste1', '00012452'),
(3, 2, 'Teste 2', '5854552'),
(4, 3, 'Teste 3', '0012245'),
(5, 5, 'Teste 5 ', '55555555'),
(6, 6, 'Teste 6', '666666'),
(7, 7887, 'Teste 7', '777454'),
(8, 2015, 'Teste', '9875464'),
(9, 1999, 'Teste 9', '999999'),
(10, 2015, 'Teste', '9875464');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
