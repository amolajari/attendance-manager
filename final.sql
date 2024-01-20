-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 30, 2022 at 06:20 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `attendance`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `roll_no` varchar(10) NOT NULL,
  `student_name` varchar(30) NOT NULL,
  `attendance` varchar(10) NOT NULL,
  `class_code` varchar(10) NOT NULL,
  `subject_id` varchar(30) NOT NULL,
  `time` varchar(30) NOT NULL,
  `date` varchar(30) NOT NULL,
  `teacher_name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`roll_no`, `student_name`, `attendance`, `class_code`, `subject_id`, `time`, `date`, `teacher_name`) VALUES
('8001', 'Rugved Kulkarni', 'Present', 'SYCOB', 'MA_B', '09:10 - 10:10', '01-05-2022', '5001'),
('8002', 'Nipun Kulkarni', 'Present', 'SYCOB', 'MA_B', '09:10 - 10:10', '01-05-2022', '5001'),
('8003', 'Akansha Kulkarni', 'Present', 'SYCOB', 'MA_B', '09:10 - 10:10', '01-05-2022', '5001'),
('8004', 'Varad Kulkarni', 'Absent', 'SYCOB', 'MA_B', '09:10 - 10:10', '01-05-2022', '5001'),
('4001', 'Om Kolte', 'Present', 'SYCOA', 'DB_A', '10:10 - 11:10', '02-05-2022', '5001'),
('4002', 'Ankita Sawant', 'Present', 'SYCOA', 'DB_A', '10:10 - 11:10', '02-05-2022', '5001'),
('4003', 'Sai Chormunge', 'Present', 'SYCOA', 'DB_A', '10:10 - 11:10', '02-05-2022', '5001'),
('4004', 'shweta shinde', 'Absent', 'SYCOA', 'DB_A', '10:10 - 11:10', '02-05-2022', '5001');

-- --------------------------------------------------------

--
-- Table structure for table `attendance_logs`
--

CREATE TABLE `attendance_logs` (
  `class_code` varchar(10) NOT NULL,
  `subject_name` varchar(10) NOT NULL,
  `time` varchar(15) NOT NULL,
  `date` varchar(30) NOT NULL,
  `teacher_name` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `attendance_logs`
--

INSERT INTO `attendance_logs` (`class_code`, `subject_name`, `time`, `date`, `teacher_name`) VALUES
('SYCOB', 'MA_B', '09:10 - 10:10', '01-05-2022', '5001'),
('SYCOA', 'DB_A', '10:10 - 11:10', '02-05-2022', '5001');

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `class_code` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`class_code`) VALUES
('SYCOB'),
('SYCOA'),
('SYCOC'),
('SYCOD'),
('TYCOA'),
('TYCOB'),
('TYCOC'),
('TYCOD');

-- --------------------------------------------------------

--
-- Table structure for table `login_creds`
--

CREATE TABLE `login_creds` (
  `id` int(10) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `type` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login_creds`
--

INSERT INTO `login_creds` (`id`, `username`, `password`, `type`) VALUES
(1, 'admin', 'admin', 'admin'),
(2, '5001', 'nnn', 'teacher'),
(3, '5002', 'mmm', 'teacher'),
(4, '5003', 'mmm', 'teacher'),
(5, '5004', 'sss', 'teacher'),
(6, '5005', 'mmm', 'teacher');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `enrollment_no` varchar(8) NOT NULL,
  `student_name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `class_code` varchar(5) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `dob` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`enrollment_no`, `student_name`, `email`, `class_code`, `gender`, `dob`) VALUES
('8001', 'Rugved Kulkarni', 'R@gmail.com', 'SYCOB', 'male', '2022-05-121'),
('8002', 'Nipun Kulkarni', 'N@gmail.com', 'SYCOB', 'male', '2022-05-122'),
('8003', 'Akansha Kulkarni', 'A@gmail.com', 'SYCOB', 'female', '2022-05-123'),
('8004', 'Varad Kulkarni', 'V@gmail.com', 'SYCOB', 'male', '2022-05-124'),
('4001', 'Om Kolte', 'o@gmail.com', 'SYCOA', 'Male', '12-May-2022'),
('4002', 'Ankita Sawant', 'a@gmail.com', 'SYCOA', 'Female', '12-May-2022'),
('4003', 'Sai Chormunge', 'sai@gmail.com', 'SYCOA', 'Female', '12-May-2022'),
('4004', 'shweta shinde', 'shweta@gmail.com', 'SYCOA', 'Female', '12-May-2022'),
('7001', 'STUD1', 's@gmail.com', 'SYCOD', 'male', '2022-05-121'),
('7002', 'STUD2', 's@gmail.com', 'SYCOD', 'female', '2022-05-121'),
('7003', 'STUD3', 's@gmail.com', 'SYCOD', 'male', '2022-05-121'),
('7004', 'STUD4', 's@gmail.com', 'SYCOD', 'male', '2022-05-121'),
('SYCOC380', 'Harshada', 'h@gmail.com', 'SYCOC', 'female', '2022-05-121'),
('SYCOC375', 'Shreyash', 's@gmail.com', 'SYCOC', 'male', '2022-05-121'),
('SYCOC376', 'Aditya', 'a@gmail.com', 'SYCOC', 'male', '2022-05-121'),
('SYCOC377', 'Vidya', 'v@gmail.com', 'SYCOC', 'female', '2022-05-121'),
('SYCOC378', 'Gayatri', 'g@gmail.com', 'SYCOC', 'female', '2022-05-121');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `subject_id` varchar(10) NOT NULL,
  `subject_name` varchar(30) NOT NULL,
  `description` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`subject_id`, `subject_name`, `description`) VALUES
('MA_B', 'Microprocessor Arch', ''),
('MA_A', 'Microprocessor Arch', ''),
('MA_C', 'Microprocessor Arch', ''),
('MA_D', 'Microprocessor Arch', ''),
('SE_A', 'Software Engineering', ''),
('SE_B', 'Software Engineering', ''),
('SE_C', 'Software Engineering', ''),
('SE_D', 'Software Engineering', ''),
('CN_A', 'Computer Networks', ''),
('CN_B', 'Computer Networks', ''),
('CN_C', 'Computer Networks', ''),
('CN_D', 'Computer Networks', ''),
('DB_A', 'DBMS', ''),
('DB_B', 'DBMS', ''),
('DB_C', 'DBMS', ''),
('DB_D', 'DBMS', ''),
('PCI', 'Java', '');

-- --------------------------------------------------------

--
-- Table structure for table `subject_assign`
--

CREATE TABLE `subject_assign` (
  `class_code` varchar(10) NOT NULL,
  `subject_id` varchar(10) NOT NULL,
  `teacher_id` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subject_assign`
--

INSERT INTO `subject_assign` (`class_code`, `subject_id`, `teacher_id`) VALUES
('SYCOB', 'MA_B', '5001'),
('SYCOA', 'DB_A', '5001'),
('SYCOB', 'DB_B', '5002'),
('SYCOB', 'CN_B', '5003'),
('SYCOB', 'SE_B', '5004'),
('SYCOC', 'CN_B', '5004'),
('SYCOB', 'PCI', '5005'),
('SYCOD', 'SE_D', '5005');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `teacher_id` varchar(15) NOT NULL,
  `teacher_name` varchar(15) NOT NULL,
  `address` varchar(30) NOT NULL,
  `phone` int(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `gender` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`teacher_id`, `teacher_name`, `address`, `phone`, `email`, `gender`) VALUES
('5001', 'Namrata G', 'PCMC', 987456, 'sahilsshinde5@gmail.com', 'FEMALE'),
('5002', 'Madhura K', 'PCMC', 987456, 'sahilsshinde5@gmail.com', 'FEMALE'),
('5003', 'Meghana L', 'PUNE', 987456, 'sahilsshinde5@gmail.com', 'FEMALE'),
('5004', 'S Sambare', 'PUNE', 987456, 'sahilsshinde5@gmail.com', 'MALE'),
('5005', 'Manjiri R', 'PUNE', 987456, 'sahilsshinde5@gmail.com', 'FEMALE');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login_creds`
--
ALTER TABLE `login_creds`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login_creds`
--
ALTER TABLE `login_creds`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
