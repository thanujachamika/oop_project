-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 03, 2019 at 09:39 AM
-- Server version: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nationalonlinepollingsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminId`, `userName`, `password`) VALUES
(1, 'thanuja', 'abcd1234');

-- --------------------------------------------------------

--
-- Table structure for table `candidate`
--

DROP TABLE IF EXISTS `candidate`;
CREATE TABLE IF NOT EXISTS `candidate` (
  `CandidateID` int(11) NOT NULL AUTO_INCREMENT,
  `CandidatefName` varchar(50) DEFAULT NULL,
  `CandidatelName` varchar(50) DEFAULT NULL,
  `CandidateNIC` varchar(20) DEFAULT NULL,
  `DateofBirth` date DEFAULT NULL,
  `CandidatePartyID` int(11) DEFAULT NULL,
  `ElectionID` int(11) DEFAULT NULL,
  `CandidateAreaCode` int(11) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Race` varchar(10) DEFAULT NULL,
  `AddressNo` varchar(10) DEFAULT NULL,
  `AddressStreet` varchar(50) DEFAULT NULL,
  `AddressCity` varchar(50) DEFAULT NULL,
  `ContactNo` int(11) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`CandidateID`),
  UNIQUE KEY `CandidateNIC` (`CandidateNIC`),
  KEY `fk_Candidate1` (`CandidateAreaCode`),
  KEY `fk_Candidate2` (`CandidatePartyID`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `candidate`
--

INSERT INTO `candidate` (`CandidateID`, `CandidatefName`, `CandidatelName`, `CandidateNIC`, `DateofBirth`, `CandidatePartyID`, `ElectionID`, `CandidateAreaCode`, `Gender`, `Race`, `AddressNo`, `AddressStreet`, `AddressCity`, `ContactNo`, `Email`) VALUES
(8, 'Kamal', 'Perera', '971430302V', '2019-05-25', 1, 1, 5, 'male', 'Sinhalese', 'No 0', 'Rd', 'Colombo', 714401101, 'kamal@gmail.com'),
(7, 'Alwis', 'Senanayake', '971430305', '2019-05-15', 1, 1, 5, 'male', 'Sinhalese', 'No45', 'Col Rd', 'Col', 770110110, 'alwis@gmail.com'),
(9, 'Weere', 'Sena', '971430307V', '2019-05-05', 3, 1, 5, 'male', 'Malay', 'No 0', 'Rd', 'Galle', 788888881, 'weere@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `electiontype`
--

DROP TABLE IF EXISTS `electiontype`;
CREATE TABLE IF NOT EXISTS `electiontype` (
  `ElectionID` int(11) NOT NULL AUTO_INCREMENT,
  `ElectionName` varchar(100) NOT NULL,
  `ElectionDate` date DEFAULT NULL,
  `ElectionCycle` int(11) DEFAULT NULL,
  PRIMARY KEY (`ElectionID`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `electiontype`
--

INSERT INTO `electiontype` (`ElectionID`, `ElectionName`, `ElectionDate`, `ElectionCycle`) VALUES
(1, 'General Election', '2020-08-03', 2020),
(2, 'Presidential Election', '2020-08-03', 2020),
(3, 'Provincial Election', '2020-08-03', 2020),
(4, 'Local Authorities Election', '2020-08-03', 2020),
(5, 'General Election', '2015-01-15', 2015);

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location` (
  `AreaCode` int(11) NOT NULL AUTO_INCREMENT,
  `District` varchar(50) NOT NULL,
  `Province` varchar(50) NOT NULL,
  `PollingArea` varchar(50) NOT NULL,
  PRIMARY KEY (`AreaCode`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`AreaCode`, `District`, `Province`, `PollingArea`) VALUES
(1, 'null', 'null', 'null'),
(3, 'null', 'null', 'null'),
(4, 'Ampara', 'Central', 'Colombo North'),
(5, 'Anuradhapura', 'North Western', 'Colombo North'),
(6, 'Ampara', 'Central', 'Colombo North'),
(7, 'Gampaha', 'Central', 'Colombo North');

-- --------------------------------------------------------

--
-- Table structure for table `politicalparty`
--

DROP TABLE IF EXISTS `politicalparty`;
CREATE TABLE IF NOT EXISTS `politicalparty` (
  `PartyID` int(11) NOT NULL AUTO_INCREMENT,
  `PartyLogo` varchar(20) NOT NULL,
  `Party_Name` varchar(200) NOT NULL,
  `Abbreivation` varchar(10) DEFAULT NULL,
  `LeaderName` varchar(100) DEFAULT NULL,
  `SecName` varchar(100) DEFAULT NULL,
  `OfficialContact` int(11) DEFAULT NULL,
  `OfficialEmail` varchar(50) DEFAULT NULL,
  `AddressNo` varchar(10) DEFAULT NULL,
  `AddressStreet` varchar(50) DEFAULT NULL,
  `AddressCity` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`PartyID`),
  UNIQUE KEY `PartyLogo` (`PartyLogo`),
  UNIQUE KEY `Party_Name` (`Party_Name`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `politicalparty`
--

INSERT INTO `politicalparty` (`PartyID`, `PartyLogo`, `Party_Name`, `Abbreivation`, `LeaderName`, `SecName`, `OfficialContact`, `OfficialEmail`, `AddressNo`, `AddressStreet`, `AddressCity`) VALUES
(1, 'Pohottuwa', 'Podujana Peramuna', 'PP', 'Mahinda Rajapakse', 'G.L.Pieris', 111231231, 'podujanaperamuna@gmail.com', 'no 44', 'Colombo Rd', 'Medamulana'),
(2, 'Elephant', 'United National Party', 'UNP', 'Ranil Wickramasinghe', 'Akila Viraj', 911231231, 'unitednationalparty@gmail.com', 'No 45', 'Sirikotha', 'Colombo 7'),
(3, 'Bell', 'Janatha Vimukthi Peramuna', 'JVP', 'Anura Kumara Dissanayake', 'Tilvin Silva', 112345678, 'jvp@gmail.com', 'No 15', 'abc', 'Battaramulla');

-- --------------------------------------------------------

--
-- Table structure for table `vote`
--

DROP TABLE IF EXISTS `vote`;
CREATE TABLE IF NOT EXISTS `vote` (
  `voteID` int(11) NOT NULL AUTO_INCREMENT,
  `VoterID` int(11) NOT NULL,
  `ElectionID` int(11) NOT NULL,
  `VotedParty` int(11) NOT NULL,
  `VoterAreaCode` int(11) NOT NULL,
  PRIMARY KEY (`VoterID`,`ElectionID`),
  UNIQUE KEY `voteID` (`voteID`),
  KEY `fk_Vote1` (`ElectionID`),
  KEY `fk_Vote2` (`VoterAreaCode`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vote`
--

INSERT INTO `vote` (`voteID`, `VoterID`, `ElectionID`, `VotedParty`, `VoterAreaCode`) VALUES
(1, 14, 1, 1, 7),
(2, 15, 1, 1, 1),
(3, 16, 1, 2, 7),
(4, 15, 5, 3, 7),
(5, 14, 5, 1, 1),
(6, 16, 5, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `voter`
--

DROP TABLE IF EXISTS `voter`;
CREATE TABLE IF NOT EXISTS `voter` (
  `VoterID` int(11) NOT NULL AUTO_INCREMENT,
  `Mname` varchar(100) NOT NULL,
  `Lname` varchar(100) NOT NULL,
  `OtherNames` varchar(100) DEFAULT NULL,
  `Gender` varchar(20) DEFAULT NULL,
  `Race` varchar(20) DEFAULT NULL,
  `DateOfBirth` date NOT NULL,
  `NIC` varchar(20) NOT NULL,
  `AddressNo` varchar(10) DEFAULT NULL,
  `AddressStreet` varchar(50) DEFAULT NULL,
  `AddressCity` varchar(50) DEFAULT NULL,
  `VoterEmail` varchar(100) DEFAULT NULL,
  `VoterContact` int(11) DEFAULT NULL,
  `VoterAreaCode` int(11) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`VoterID`),
  UNIQUE KEY `NIC` (`NIC`),
  KEY `fk_Voter` (`VoterAreaCode`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `voter`
--

INSERT INTO `voter` (`VoterID`, `Mname`, `Lname`, `OtherNames`, `Gender`, `Race`, `DateOfBirth`, `NIC`, `AddressNo`, `AddressStreet`, `AddressCity`, `VoterEmail`, `VoterContact`, `VoterAreaCode`, `password`) VALUES
(14, 'Saman', 'Edirisinghe', 'Lenin', 'male', 'Sinhala', '1963-06-21', '631234567V', '23/1', 'Temple Road', 'Athurugiriya', 'sam@gmail.com', 721231231, 1, '123'),
(15, 'Samanthi', 'Weerasinghe', 'Kaushalya', 'female', 'Sinhala', '1983-05-15', '877894561V', '42 A', 'Flower Lane', 'Malabe', 'kau@gmail.com', 727894561, 2, ''),
(16, 'Kasun', 'Weerarathna', 'Als', 'null', 'null', '1987-01-05', '963200153V', '12', 'Arisl', 'Wella Lane', 'asd@famil.com', 123, 7, '');

-- --------------------------------------------------------

--
-- Table structure for table `vote_candidate`
--

DROP TABLE IF EXISTS `vote_candidate`;
CREATE TABLE IF NOT EXISTS `vote_candidate` (
  `voterID` int(11) NOT NULL,
  `electionId` int(11) NOT NULL,
  `candidateID` int(11) NOT NULL,
  PRIMARY KEY (`voterID`,`electionId`,`candidateID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vote_candidate`
--

INSERT INTO `vote_candidate` (`voterID`, `electionId`, `candidateID`) VALUES
(14, 1, 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
