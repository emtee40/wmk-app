-- phpMyAdmin SQL Dump
-- version 3.3.10.4
-- http://www.phpmyadmin.net
--
-- Host: mysql.wmk-app.com
-- Generation Time: Apr 30, 2014 at 03:09 PM
-- Server version: 5.1.56
-- PHP Version: 5.3.27

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `wmkapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `device`
--

CREATE TABLE IF NOT EXISTS `device` (
  `DeviceID` varchar(255) NOT NULL,
  `Longitude` varchar(255) NOT NULL DEFAULT '0',
  `Latitude` varchar(255) NOT NULL DEFAULT '0',
  `UserID` int(11) unsigned NOT NULL,
  PRIMARY KEY (`DeviceID`),
  KEY `UserID` (`UserID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `device`
--

INSERT INTO `device` (`DeviceID`, `Longitude`, `Latitude`, `UserID`) VALUES
('358240050090588', '-6.2388649', '53.4732636', 37),
('358091051667878', '-6.2680921', '53.34733606', 36),
('352668044089876', '-6.2414437', '53.3911646', 35),
('358240052105939', '-6.2680921', '53.34733606', 36);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `UserID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Username` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `Password` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `Email` varchar(80) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `Name` varchar(80) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `SurName` varchar(255) NOT NULL,
  `facebook` int(11) NOT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `Username` (`Username`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=41 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`UserID`, `Username`, `Password`, `Email`, `Name`, `SurName`, `facebook`) VALUES
(39, 'fernanda', '1234', 'fernandatorres98@yaoo.com.br', 'torres', 'aguiar', 0),
(38, 'Bruno', '123456', 'Bruno.a.jorge@gmail.com', 'Aguiar', 'Jorge', 0),
(37, 'andrey', 'persevest', 'andreivanov86@gmail.com', 'andrei', 'ivanov', 0),
(36, 'skeeterssj4', '123456', 'skeeterssj4@gmail.com', 'Luiz', 'Batista', 0),
(35, 'ardimehist', 'nciproject', 'ardi@mehist.com', 'Ardi', 'Mehist', 0),
(40, 'SHANE', '123456', 'BRUNOTEST.@GMAIL.COM', 'AGUIAR', 'JORGE', 0);
