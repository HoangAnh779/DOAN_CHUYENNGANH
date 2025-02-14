-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 13, 2025 at 09:38 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `websitedulich`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `id` bigint NOT NULL,
  `booking_at` datetime(6) DEFAULT NULL,
  `ghi_chu` varchar(255) DEFAULT NULL,
  `ngay_khoi_hanh` datetime(6) DEFAULT NULL,
  `pt_thanh_toan` int DEFAULT NULL,
  `so_luong_nguoi` int DEFAULT NULL,
  `tong_tien` bigint DEFAULT NULL,
  `tour_id` bigint DEFAULT NULL,
  `trang_thai` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`id`, `booking_at`, `ghi_chu`, `ngay_khoi_hanh`, `pt_thanh_toan`, `so_luong_nguoi`, `tong_tien`, `tour_id`, `trang_thai`, `user_id`) VALUES
(1, '2024-11-12 08:21:02.334000', '', '2024-12-01 00:00:00.000000', 0, 1, 3000000, 1, 3, 2),
(2, '2024-11-12 22:37:06.910000', '', '2024-11-26 00:00:00.000000', 0, 1, 3000000, 1, 3, 3),
(3, '2024-11-12 22:42:48.282000', '', '2024-11-26 00:00:00.000000', 0, 1, 3000000, 1, 3, 2),
(4, '2024-11-12 22:47:19.893000', '', '2024-12-29 00:00:00.000000', 0, 1, 5000000, 6, 3, 2),
(5, '2024-11-27 12:33:00.384000', '', '2024-12-17 00:00:00.000000', 1, 1, 5000000, 3, 3, 6),
(6, '2024-11-28 16:42:58.129000', '', '2024-11-23 00:00:00.000000', 0, 1, 5000000, 3, 1, 5),
(7, '2024-11-28 16:58:54.566000', '', '2024-11-23 00:00:00.000000', 0, 1, 5000000, 3, 3, 7),
(8, '2024-11-28 17:03:01.025000', '', '2024-12-17 00:00:00.000000', 0, 1, 5000000, 3, 3, 7),
(9, '2024-11-28 17:03:40.649000', '', '2025-01-25 00:00:00.000000', 0, 1, 3000000, 1, 1, 6),
(10, '2024-11-28 17:06:19.469000', '', '2024-12-30 00:00:00.000000', 0, 1, 5000000, 3, 1, 6),
(11, '2024-11-29 17:58:02.514000', '', '2024-12-01 00:00:00.000000', 0, 1, 3000000, 1, 3, 6),
(12, '2024-11-29 20:49:56.088000', '', '2025-01-16 00:00:00.000000', 0, 1, 105000000, 11, 3, 4),
(13, '2024-11-30 08:06:55.452000', '', '2024-12-14 00:00:00.000000', 0, 2, 13958000, 13, 1, 3),
(14, '2024-11-30 08:27:00.500000', '', '2025-01-01 00:00:00.000000', 0, 3, 24000000, 7, 1, 8),
(16, '2024-12-02 20:13:10.476000', '', '2024-12-23 00:00:00.000000', 1, 1, 4998000, 12, 1, 6),
(17, '2024-12-02 20:27:18.342000', '', '2024-12-02 00:00:00.000000', 2, 1, 6979000, 13, 4, 6),
(18, '2024-12-02 20:49:56.665000', '', '2024-11-23 00:00:00.000000', 2, 1, 5000000, 3, 3, 6),
(19, '2024-12-02 21:04:25.320000', '', '2024-12-15 00:00:00.000000', 2, 1, 15000000, 5, 1, 5),
(20, '2024-12-02 21:15:10.150000', '', '2024-12-19 00:00:00.000000', 2, 1, 8000000, 7, 1, 5),
(21, '2024-12-02 21:26:55.272000', '', '2024-12-23 00:00:00.000000', 2, 1, 4998000, 12, 4, 3),
(22, '2024-12-02 21:29:35.850000', '', '2024-12-02 00:00:00.000000', 0, 1, 6979000, 13, 1, 3),
(23, '2024-12-02 21:40:23.160000', '', '2024-12-17 00:00:00.000000', 2, 1, 5000000, 3, 1, 5),
(24, '2024-12-02 22:03:10.545000', '', '2024-12-29 00:00:00.000000', 2, 1, 3000000, 1, 1, 4),
(25, '2024-12-02 22:10:28.500000', '', '2024-12-01 00:00:00.000000', 2, 1, 3000000, 1, 3, 6),
(26, '2024-12-02 22:22:17.461000', '', '2024-12-02 00:00:00.000000', 2, 1, 6979000, 13, 1, 6),
(27, '2024-12-02 22:25:11.046000', '', '2024-12-19 00:00:00.000000', 2, 1, 8000000, 7, 1, 5),
(28, '2024-12-02 22:38:16.153000', '', '2024-12-02 00:00:00.000000', 2, 1, 6979000, 13, 4, 3),
(29, '2024-12-02 22:50:09.066000', '', '2024-12-26 00:00:00.000000', 2, 1, 5000000, 6, 1, 3),
(30, '2024-12-02 22:51:27.967000', '', '2024-11-23 00:00:00.000000', 2, 1, 5000000, 3, 4, 5),
(31, '2024-12-02 22:52:22.738000', '', '2024-12-26 00:00:00.000000', 2, 1, 5000000, 6, 1, 6),
(32, '2024-12-02 22:53:46.759000', '', '2024-12-06 00:00:00.000000', 2, 1, 19999000, 9, 1, 7),
(33, '2024-12-02 22:58:05.726000', '', '2024-12-01 00:00:00.000000', 2, 1, 3000000, 1, 3, 4),
(34, '2024-12-02 23:34:47.842000', '', '2024-12-23 00:00:00.000000', 2, 1, 4998000, 12, 4, 6),
(35, '2024-12-03 15:49:32.655000', '', '2024-12-01 00:00:00.000000', 2, 1, 3000000, 1, 4, 6),
(36, '2024-12-03 16:39:24.221000', '', '2024-11-23 00:00:00.000000', 0, 1, 5000000, 3, 4, 6),
(37, '2024-12-03 16:44:00.082000', '', '2024-11-23 00:00:00.000000', 2, 1, 5000000, 3, 4, 6),
(38, '2024-12-03 16:44:40.537000', '', '2024-12-26 00:00:00.000000', 0, 1, 5000000, 6, 4, 6),
(39, '2024-12-03 16:45:05.138000', '', '2024-12-19 00:00:00.000000', 0, 1, 8000000, 7, 4, 6),
(40, '2024-12-03 16:47:57.872000', '', '2025-01-02 00:00:00.000000', 0, 1, 105000000, 11, 4, 5),
(41, '2024-12-03 16:48:15.050000', '', '2024-12-06 00:00:00.000000', 2, 1, 150005000, 14, 1, 5),
(42, '2024-12-03 16:49:39.206000', '', '2024-12-01 00:00:00.000000', 2, 1, 3000000, 1, 4, 3),
(43, '2024-12-03 16:49:57.137000', '', '2024-11-23 00:00:00.000000', 0, 1, 5000000, 3, 3, 3),
(44, '2024-12-04 12:49:20.240000', '', '2024-12-21 00:00:00.000000', 2, 10, 29990000, 16, 3, 5),
(45, '2024-12-05 09:20:06.456000', '', '2024-11-23 00:00:00.000000', 2, 1, 5000000, 3, 3, 6),
(46, '2024-12-10 15:56:46.747000', '', '2024-12-23 00:00:00.000000', 0, 1, 139868000, 15, 2, 5),
(47, '2024-12-13 19:31:46.493000', '', '2024-12-19 00:00:00.000000', 2, 5, 75000000, 5, 2, 4),
(48, '2024-12-13 19:33:51.928000', '', '2024-12-19 00:00:00.000000', 2, 3, 24000000, 7, 4, 3),
(49, '2024-12-17 11:30:58.264000', '', '2024-12-01 00:00:00.000000', 2, 1, 3000000, 1, 4, 6),
(50, '2024-12-17 12:14:01.537000', '', '2024-12-01 00:00:00.000000', 2, 1, 3000000, 1, 3, 6),
(51, '2024-12-17 12:23:04.239000', '', '2024-12-01 00:00:00.000000', 2, 1, 3000000, 1, 3, 5),
(52, '2024-12-17 16:40:53.141000', '', '2024-12-23 00:00:00.000000', 0, 1, 15000000, 5, 3, 3),
(53, '2024-12-17 20:29:04.223000', '', '2024-12-30 00:00:00.000000', 2, 1, 4250000, 3, 4, 7),
(54, '2024-12-17 20:29:44.422000', '', '2024-11-23 00:00:00.000000', 0, 1, 4250000, 3, 4, 7),
(55, '2024-12-17 20:35:02.972000', '', '2024-12-01 00:00:00.000000', 0, 1, 2700000, 1, 4, 7),
(56, '2024-12-18 13:02:16.890000', '', '2024-12-01 00:00:00.000000', 2, 1, 2700000, 1, 3, 7),
(57, '2024-12-20 23:54:21.569000', '', '2024-12-28 00:00:00.000000', 0, 10, 29990000, 16, 0, 3),
(58, '2024-12-24 20:05:36.651000', '', '2024-12-14 00:00:00.000000', 2, 10, 29990000, 16, 1, 6),
(59, '2024-12-25 22:59:02.400000', '', '2024-11-23 00:00:00.000000', 2, 1, 4250000, 3, 1, 10),
(60, '2024-12-25 23:32:39.002000', '', '2025-01-01 00:00:00.000000', 2, 10, 42500000, 3, 3, 12),
(61, '2024-12-27 20:28:26.277000', '', '2024-12-01 00:00:00.000000', 2, 1, 2700000, 1, 0, 5),
(62, '2024-12-28 11:37:09.950000', '', '2024-12-01 00:00:00.000000', 2, 1, 2700000, 1, 1, 6);

-- --------------------------------------------------------

--
-- Table structure for table `destination`
--

CREATE TABLE `destination` (
  `id` bigint NOT NULL,
  `country` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `image`
--

CREATE TABLE `image` (
  `id` bigint NOT NULL,
  `tour_id` bigint DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `image`
--

INSERT INTO `image` (`id`, `tour_id`, `url`) VALUES
(1, 1, 'd3e89141-f9fb-42c1-ad05-04fb6892d66fc0743f22c9218897090915f23dc42296.jpg'),
(2, 1, '42f110fe-3fb0-404b-a9ab-2c68d4f4da8eHinh-anh-nui-Ba-Den-2-800x600.jpg'),
(3, 3, '1cd9c86c-4db6-4800-a21d-78f62fd83d46VNo-vungtau11.jpg'),
(4, 3, '33bc3377-cdfe-4df9-bded-698ee6891a2cvung-tau-d-p-nhu-tranh.jpg'),
(6, 6, '534c139b-419b-40e0-af8e-166ea1347fe9resort_phu_quoc_01.jpg'),
(7, 6, '8cdcf12d-ba14-4e79-8a01-70e9ff62729bcam-nang-du-lich-phu-quoc-1.jpg'),
(8, 7, 'c1b30dcf-54b2-49d8-a210-734d34e5d1f9Da-Nang-LandMark-Tower.jpg'),
(9, 5, '5e99dd30-577b-475b-884e-f535a9492973dia-diem-du-lich-bangkok-1.jpg'),
(10, 5, '0fc80b68-92e3-401b-b8fd-ad2c7ea2f61bFeatured-image-Wat-Phra-Kaew-and-The-Grand-Palace-Bangkok-Thailand-1244x700.jpg'),
(11, 9, '7f63cd2d-f2e0-4ccf-b52d-5c735fa70a74n-seoul-tower-memorial-guerre-coree-ceetiz.jpg'),
(12, 9, 'c2db208d-bd4d-42ba-967c-dd370feb8d6bSeoul.jpg'),
(13, 10, '2a3658e3-ecba-4132-b26b-91a1947d51a0Why-Australia.png'),
(14, 10, '24bb76a8-5c10-4a85-bd42-470c59c0b726nha-hat-con-so-opera-sydney-4.jpg'),
(15, 11, 'f4aa7845-108f-4672-aeb5-07714906d5d51582792511.jpg'),
(16, 11, 'a624f7b6-fd64-49dc-8a0a-4ed0f1d28c12tour-du-lich-dong-au-3-nuoc-duc-ao-sec.jpg'),
(17, 12, '38f544da-b96b-4dc8-9878-5829daf0d6fcve-cap-treo-fansipan-4.jpg'),
(18, 12, '63ff5c6a-54f5-4525-b76f-44f87dcaee201_chua-kim-son-bao-thang-fansipan-sapa-kynghidongduong-vn-02-nguon-andrey-sulitskiy.jpg'),
(19, 13, '3e307c24-8c34-49fe-ab7e-a9e230d0abd3vietpromotion.vn-bo-tui-bi-kip-cam-nang-du-lich-da-lat.jpg'),
(20, 13, '8c12422d-c190-4b35-bc22-3f6fc3bc92d3tour-samten-hills-dalat.jpg'),
(21, 14, '1c9ba979-4ae9-47eb-8146-3decf2450ac5tour-du-lich-phap-23-9-2017-3.jpg'),
(22, 14, '5067a899-c114-49e8-b330-8ac4d3f35908d768a65df2938f7081f76ecf516ab2bc.jpeg'),
(23, 15, '205f494a-8082-43f2-803c-1027d86fd4c3du-lich-y-1-1024x767.webp'),
(24, 15, 'e75f1cd1-e1c7-48da-b517-44fdd181e000ly-giai-con-sot-gia-tour-di-chau-au-he-2024-3-1416.jpg'),
(25, 16, '98206a13-d29f-4c94-baae-d56c67e85208anh-dep-du-khach-tham-quan-vinh-ha-long.webp'),
(26, 16, 'b64371bf-b997-4297-b20f-edd2eea3ef2edu-thuyen-ambassador-1-ngay-6507fce2dfcfe.jpg'),
(27, 16, 'ad92a4d3-b762-4266-9806-24b983a6a9aftour-vinh-ha-long-1-ngay-kham-pha-ky-quan-thien-nhien-the-gioi-668de26f61bf4.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `tin_tuc`
--

CREATE TABLE `tin_tuc` (
  `id` bigint NOT NULL,
  `hinh_anh` varchar(255) DEFAULT NULL,
  `ngay_dang` datetime(6) DEFAULT NULL,
  `noi_dung` varchar(255) DEFAULT NULL,
  `tieu_de` varchar(255) DEFAULT NULL,
  `tom_tat` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tin_tuc`
--

INSERT INTO `tin_tuc` (`id`, `hinh_anh`, `ngay_dang`, `noi_dung`, `tieu_de`, `tom_tat`) VALUES
(1, 'ec9342cf-90b7-4206-8e94-55a7076ac3ebGolden-Bridge-Featured.jpg', '2024-11-28 22:29:12.000000', 'Theo báo cáo của Sở Du lịch Đà Nẵng, trong 9 tháng đầu năm, tổng khách lưu trú ước đạt 8,67 triệu lượt, tăng 33% so với cùng kỳ năm 2023, bằng 163% cùng kỳ năm 2019.', 'Doanh thu ngành du lịch Đà Nẵng 9 tháng ước đạt hơn 26 nghìn tỷ đồng', 'Theo báo cáo của Sở Du lịch Đà Nẵng, trong 9 tháng đầu năm, tổng khách lưu trú ước đạt 8,67 triệu lượt, tăng 33% so với cùng kỳ năm 2023, bằng 163% cùng kỳ năm 2019.'),
(2, NULL, '2024-12-25 13:26:16.000000', 'Về Núi Bà Đen (Núi Trinh Nữ Đen): Vị trí và giá vé', 'Núi Bà Đen Tây Ninh: Cẩm nang để có chuyến đi hoàn hảo vào thiên nhiên', 'Là ngọn núi cao nhất ở vùng Đông Nam Việt Nam, núi Bà Đen mang đến sự kết hợp tuyệt vời giữa môi trường nguyên sơ, cảnh quan ngoạn mục và cảm giác yên bình.');

-- --------------------------------------------------------

--
-- Table structure for table `tour`
--

CREATE TABLE `tour` (
  `id` bigint NOT NULL,
  `anh_tour` varchar(255) DEFAULT NULL,
  `diem_den` varchar(255) DEFAULT NULL,
  `diem_khoi_hanh` varchar(255) DEFAULT NULL,
  `gia_tour` bigint DEFAULT NULL,
  `gioi_thieu_tour` varchar(255) DEFAULT NULL,
  `loai_tour` int DEFAULT NULL,
  `ngay_ket_thuc` datetime(6) DEFAULT NULL,
  `ngay_khoi_hanh` datetime(6) DEFAULT NULL,
  `noi_dung_tour` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci,
  `so_ngay` int DEFAULT NULL,
  `ten_tour` varchar(255) DEFAULT NULL,
  `trang_thai` int DEFAULT NULL,
  `giam_gia` int DEFAULT NULL,
  `ma_giam_gia` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tour`
--

INSERT INTO `tour` (`id`, `anh_tour`, `diem_den`, `diem_khoi_hanh`, `gia_tour`, `gioi_thieu_tour`, `loai_tour`, `ngay_ket_thuc`, `ngay_khoi_hanh`, `noi_dung_tour`, `so_ngay`, `ten_tour`, `trang_thai`, `giam_gia`, `ma_giam_gia`) VALUES
(1, 'f62912dd-77bd-4cb1-a502-c7d991cb3c83BLACK_VIRGIN_MOUNTAIN_near_Saigon_-_Copy.jpg', 'Sun World Ba Den Mountain – Nóc nhà Nam Bộ', 'Gò vấp , TP HCM', 3000000, 'Tour Tây Ninh Trọn Gói Cao Cấp', 1, '2024-12-27 00:00:00.000000', '2024-12-25 00:00:00.000000', '<p>Tây Ninh là một tỉnh thuộc vùng Đông Nam Bộ, Việt Nam.</p>', 2, 'Du Lịch Tây Ninh 2024 ', 1, 10, 'TET2025'),
(3, '9b9691de-72ec-4cbd-9289-512d365c239ddu-lich-vung-tau-3-ngay-2-dem-1.jpg', 'Thành Phố Biển Vũng Tàu', 'Sài Gòn', 5000000, 'Tour du lịch Vũng Tàu 3 ngày 2 đêm trọn gói của Hitour khởi hành từ TP Hồ Chí Minh đáp ứng mọi nhu cầu của khách hàng.', 1, '2024-11-20 00:00:00.000000', '2025-01-18 00:00:00.000000', '<p>Sài Gòn - Vũng Tàu - Đồi cừu - Khu du lịch Hồ Mây - Bến du thuyền Marina - tượng Chúa Kito - tắm biển Vũng Tàu</p>', 3, 'Tour du lịch Vũng Tàu 3 ngày 2 đêm', 1, 15, 'TET2025'),
(5, '5fdf5794-857f-4174-9ab8-7cf68c399af0thailan.jpg', 'Cung Điện Hoàng Gia, Chùa Phật Ngọc', 'Sài Gòn', 15000000, 'Cung Điện Hoàng Gia, Chùa Phật Ngọc, Wat Pho và Wat Arun', 2, '2025-01-21 00:00:00.000000', '2025-01-17 00:00:00.000000', '<p>Tour Bangkok trong ngày sẽ đưa bạn đến những ngôi chùa nổi tiếng của thành phố với nhiều lựa chọn điểm tham quan như Cung điện Hoàng gia tuyệt đẹp, Chùa Phật Ngọc (Wat Phra Kaew), Chùa Wat Phra Chetuphon Vimolmangklaram (Wat Pho và Chùa Wat Arun (Chùa Bình Minh).</p>', 5, 'Tour Chùa Bangkok', 1, 12, 'GIANGSINH2024'),
(6, '7994dd16-1789-4951-aac9-e7233583c9f6ve-vinwonders-phu-quoc-phuquocxanh-2.jpg', 'Vinpearl Safari - Vinwonders - Grand World', 'Sài Gòn', 5000000, 'Khám Phá Bắc Đảo - Vinpearl Safari - Vinwonders - Grand World', 1, '2025-01-07 00:00:00.000000', '2025-01-05 00:00:00.000000', '<p><strong>Tour này có gì hay</strong></p><p>- Khởi hành (thứ 7 &amp; CN): 09 /11 ; 07, 14, 21/12 - Tham quan Vườn tiêu, Lò chế biến rượu Sim rừng Phú Quốc, Cơ sở nước mắm Phú Quốc. - Trải nghiệm “Cáp treo 3 dây vượt biển dài nhất thế giới tại Hòn Thơm” với tổng chiều dài 7.899,9m, thời gian di chuyển 15 phút - Viếng Thiên Viện Trúc Lâm Hộ Quốc ngôi chùa đẹp và lớn nhất đảo ngọc.</p>', 3, 'Du lịch Phú Quốc ', 1, 15, 'TET2025'),
(7, 'ec9342cf-90b7-4206-8e94-55a7076ac3ebGolden-Bridge-Featured.jpg', 'Bà Nà Hills, Cầu Quay Sông Hàn, Đà Nẵng', 'Sài Gòn', 8000000, 'Bà Nà Hills, Cầu Quay Sông Hàn, Ngũ Hành Sơn, Bãi biển Non Nước', 1, '2024-12-30 00:00:00.000000', '2024-12-25 00:00:00.000000', '<p>Đà Nẵng nằm giữa ba di sản thế giới: cố đô Huế, phố cổ Hội An và thánh địa Mỹ Sơn. Đà Nẵng còn có nhiều danh thắng tuyệt đẹp say lòng du khách như Ngũ Hành Sơn, Bà Nà, bán đảo Sơn Trà, đèo Hải Vân, sông Hàn thơ mộng và cầu quay Sông Hàn – niềm tự hào của thành phố, và biển Mỹ Khê đẹp nhất hành tinh.</p>', 5, 'Du lịch Đà Nẵng', 1, 12, 'TET2025'),
(9, '9b1662a9-1d93-45c5-bb51-8203cedc671bbieu-tuong-cua-dat-nuoc-han-quoc.jpg', 'Seoul - Namsan Tower - Đảo Nami', 'HCM', 19999000, 'Tour Hàn Quốc ngắm tuyết rơi Seoul - Namsan Tower - Đảo Nami - Trượt Tuyết - Hái Dâu 5N4Đ', 2, '2024-11-05 00:00:00.000000', '2025-01-01 00:00:00.000000', '<p>Chiêm ngưỡng cảnh sắc mùa tuyết rơi trọn vẹn tuyệt vời nhất tại thủ đô Seoul, đảo Nami, trải nghiệm Trượt tuyết...thỏa sức vui chơi, mua sắm. Tour&nbsp;khởi hành hàng tuần&nbsp;trọn gói 100% , luôn có tour dịp lễ, tết và các mùa trong năm.</p>', 5, 'Tour Hàn Quốc ngắm tuyết rơi Seoul', 1, NULL, NULL),
(10, '1e100fe7-2c23-4e20-9668-ea218b2dec33395819774_3018954388238442_7370488672443613636_n.jpg', 'Sydney - Wild Park - Blue Mountains', 'Hồ Chí Minh', 42988000, 'Australia – một quốc gia đa văn hóa nổi tiếng với hình ảnh quen thuộc của những chú chuột túi', 2, '2024-12-26 00:00:00.000000', '2024-12-21 00:00:00.000000', '<p><strong>Giá bao gồm</strong></p><ul><li>Vé máy bay khứ hồi theo đoàn: Vietjet Air tàu bay A330 (Máy bay thân rộng 377 chỗ ngồi) - Thuế phi trường 2 nước, thuế an ninh, phụ phí xăng dầu, …</li><li>Hành trình bay:</li><li><strong>SAI GON – SYDNEY</strong> <strong>VJ085 19:30 – 07:20</strong></li><li><strong>SYDNEY – SAI GON</strong> <strong>VJ086 10:15 – 16:30</strong></li><li>Hành lý&nbsp; đã bao gồm: ký gửi 30kg/khách + xách tay 07kg/khách&nbsp; </li><li>Khách sạn 3 sao Australia trung tâm: tiêu chuẩn 2, 3 khách 1 phòng: Ibis Sydney, Metro Central… hoặc tương đương. Trong trường hợp quý khách đi một mình công ty sẽ bố trí khách ngủ ghép với khách lẻ khác trong đoàn hoặc Hướng dẫn viên cùng giới tính (tối đa phòng 3 người) hoặc phụ thu phòng đơn (nếu có) quý khách được nghỉ ngơi 1 mình 1 phòng suốt tour.</li><li>Các bữa ăn theo chương trình với các món Âu, Á, Thái xen kẽ</li><li>HDV tiếng Việt đi theo đoàn suốt chương trình từ Việt Nam qua Úc trở lại Việt Nam</li><li>Bảo hiểm du lịch quốc tế theo quy định với mức chi trả 30.000$. Trường hợp khách trên 70 tuổi khuyến khích mua thêm phí bảo hiểm cao hơn với mức phí 500.000vnđ/khách/tour.</li><li>Quà tặng: Nón du lịch,&nbsp; Bao da hộ chiếu</li></ul><p><strong>Giá không bao gồm</strong></p><ul><li>Chi phí cá nhân, sim điện thoại, giặt ủi, đi lại ngoài giờ, hành lý quá cước, chi phí dời ngày, đổi chặng, nâng hạng vé máy bay. Trường hợp Quý khách không sử dụng chặng đi của vé đoàn theo tour, các chặng nội địa và quốc tế còn lại sẽ bị hủy hoặc không sử dụng chặng về cũng không được hoàn do điều kiện của hãng hàng không.</li><li>Phí visa nhập cảnh vào Úc: 5.000.000 vnđ/khách.</li><li>Tùy theo hồ sơ lãnh sự Úc cấp cho khách 1 lần hay nhiều lần, 1 năm hay nhiều năm. Kết quả visa nhanh ra chậm cũng tùy bộ hồ sơ.</li><li>Tiền TIP cho HDV và lái xe ở nước ngoài: 1.000.000 vnđ/trọn tour/ 1 khách (Ngày thường)</li><li>Phụ thu phòng đơn (nếu có – dành cho khách muốn ngủ một mình một phòng, hoặc trường hợp khách đăng ký đi lẻ 1 mình, nếu đoàn có khách lẻ Nam hoặc khách lẻ Nữ chúng tôi sẽ linh động ghép phòng, trong trường hợp không có khách lẻ nào khác để ghép với quý khách, quý khách vui lòng đóng phí phòng đơn): 6.500.000/khách/Tour</li><li>Các chi phí phát sinh không đề cập trong chương trình.</li><li>Xe phục vụ trung bình 10 giờ/1 ngày đảm bảo theo lịch trình tham quan, nếu phát sinh thêm giờ, quý khách vui lòng trả trực tiếp 100Aud/1 giờ.</li><li>Quý khách có nhu cầu xuất hóa đơn vui lòng báo trước khi đăng ký tour (sau thời điểm đăng kí sẽ không được giải quyết)</li><li>Đối với khách quốc tịch nước ngoài:</li><li>Phí làm visa tái nhập Việt Nam</li><li>Phí khai Giấy phép du lịch điện tử (Electronic Travel Authorization - eTA) 500.000vnd/ người (Tùy nước)</li><li>Chi phí dời ngày, đổi chặng, nâng hạng vé máy bay. Trường hợp Quý khách không sử dụng chặng đi của vé đoàn theo tour, các chặng nội địa và quốc tế còn lại sẽ bị hủy hoặc không sử dụng chặng về cũng không được hoàn do điều kiện của hãng Hàng Không.</li></ul>', 5, 'Tour Úc 2024: Sydney 5N4Đ', 1, NULL, NULL),
(11, '4580af80-052d-473f-ad39-b19ff32a1b504581724159247437663532909006014464626380171n-17253551798752075648067-1725356318932-1725356319070839564794.webp', 'Quảng trường Anh hùng , Cologne, Bonn,...', 'Hồ Chí Minh', 105000000, 'Đức là thế giới của các hãng xe hơi danh tiếng như BMW, Ferrari, Porsche, Mercedes nơi có bảo tàng xe hơi đầy thú vị.', 2, '2024-12-29 00:00:00.000000', '2024-12-22 00:00:00.000000', '<p>Đức là thế giới của các hãng xe hơi danh tiếng như BMW, Ferrari, Porsche, Mercedes nơi có bảo tàng xe hơi đầy thú vị. Munich sở hữu kiến trúc lâu đài và quảng trường nguy nga. Không chỉ có vậy, đất nước này nhộn nhịp với lễ hội bia Oktoberfest và xúc xích danh tiếng.<br>Đăng ký tour <a href=\"https://travel.com.vn/du-lich-%C4%90%E1%BB%A9c\"><strong>Đức </strong></a>cùng Vietravel, Quý khách có thể đến khám phá các điểm đến nổi bật sau: <a href=\"https://travel.com.vn/du-lich-duc\"><strong>Quảng trường Anh hùng </strong></a>, <a href=\"https://travel.com.vn/du-lich-cologne\"><strong>Cologne</strong></a>, <a href=\"https://travel.com.vn/du-lich-bonn\"><strong>Bonn</strong></a>, <a href=\"https://travel.com.vn/du-lich-munich\"><strong>Munich</strong></a>, <a href=\"https://travel.com.vn/du-lich-frankfurt\"><strong>Frankfurt</strong></a>, <a href=\"https://travel.com.vn/du-lich-D%C3%BCsseldorf\"><strong>Düsseldorf</strong></a>,...<br>Để hiểu hơn về Đức Mời Quý khách tham khảo <a href=\"https://travel.com.vn/kinh-nghiem-du-lich/du-lich-%C4%90%E1%BB%A9c.aspx\"><strong>Kinh nghiệm du lịch Đức </strong></a>.</p>', 7, 'Du lịch Đức 2025', 1, NULL, NULL),
(12, 'e20aa91f-d35f-4939-a5f9-90822af481d1maxresdefault.jpg', ' Đỉnh Fansipan – Check in Moana ', 'Hà Nội', 4998000, 'Tới Fansipan bất kể mùa nào, ngồi trên cabin cáp treo rẽ ngàn trùng mây, giữa thênh thang đất trời và dãy núi Hoàng Liên Sơn, du khách đều có một cảm giác an nhiên. ', 1, '2024-12-27 00:00:00.000000', '2024-12-25 00:00:00.000000', '<h2><strong>Lịch trình tour</strong></h2><p><strong>NGÀY 01: HÀ NỘI - SAPA - CHECK IN MOANA / BẢN CÁT CÁT (Ăn Trưa, Tối)</strong><br><strong>6h30 - 7h00:</strong> Xe đón Quý khách tại điểm hẹn của nhà xe bus. Sau đó khởi hành đi Sa Pa bằng xe bus giường nằm chất lượng cao.<br><strong>9h00:</strong> Xe dừng chân dọc đường cao tốc Nội Bài – Lào Cai để quý khách nghỉ ngơi ăn sáng.<br><strong>12h30:</strong> Xe đến <a href=\"https://dulichsapa.org.vn/diem-du-lich/thi-tran-sapa-lao-cai/\">thị trấn Sa Pa</a> nơi có rất nhiều dân tộc sinh sống như H’mong, Dao, Tày,… Hướng dẫn viên sẽ đưa Quý khách về khách sạn:<br>Ăn trưa tại khách sạn sau đó nhận phòng và nghỉ ngơi.<br>Buổi chiều: HDV cùng quý khách đi bộ khám phá góc sống ảo Sapa. Khu check in Moana Sapa là một điểm đến ở Sapa còn khá mới mẻ. Với tổng diện tích lên đến 10.000m2 cùng tổ hợp các hạng mục được thực hiện công phu. Hạng mục đầu tiên được nhiều du khách quan tâm chính là cổng trời Bali. Đây là một chiếc cổng được lấy cảm hứng từ cổng trời của thành phố Bali xinh đẹp. Với thiết kế mô phỏng bản gốc cùng vị trí hướng thẳng ra núi rừng mênh mông, nơi đây sẽ tạo cho bạn nhiều ảnh chụp mang vẻ đẹp thiêng liêng, huyền bí. Cánh cổng được xây dựng công phu, phía trước là mặt sàn lát gạch bóng loáng để tạo nên dấu ấn hoàng tráng….Ngoài các góc check in đẹp, độc và mới mẻ, điểm đến này còn được yêu thích vì sở hữu view hướng thẳng ra dãy núi Hoàng Liên Sơn và đỉnh núi Fanxipan. Đến đây, bạn vừa được chụp hình thỏa thích, vừa được ngắm bức tranh lãng đãng mây trời đầy huyền ảo của Sapa.<br>Qúy khách có thể lựa chọn thăm <a href=\"https://dulichsapa.org.vn/diem-du-lich/ban-cat-cat-sapa/\">Bản Cát Cát</a>: phát sinh vé thắng cảnh 70.000 đồng/khách.<br>HDV đưa quý khách đi bộ xuống thăm bản Cát Cát nơi sinh sống của người H’mong đen, một nơi phòng cảnh hữu tình tại thung lũng nằm dưới chân đỉnh Phanxipang hùng vĩ. HDV địa phương sẽ giới thiệu cho quý khách cuộc sống thường ngày của người dân tộc nơi đây, sau đó quý khách tiếp tục đi bộ đến thác nước Cát Cát, trạm thủy điện Cát Cát của người Pháp xây dựng từ những năm đầu thế kỉ XX. Quý khách vui chơi chụp hình lưu niệm.<br><strong>17h30</strong> Xe đón quý khách trở lại thị trấn sapa<br><strong>19h00:</strong> Quý khách dùng bữa tối. Sau đó tự do khám phá thị trấn Sapa về đêm: Thăm nhà thờ đá Sapa, đi chợ ẩm thực Sapa và thưởng thức những món nướng đặc trưng của vùng đất này,… Ngủ đêm tại khách sạn 3* trung tâm thị trấn Sapa.</p><p><strong>NGÀY 02: SAPA - CHUNG PHỤC ĐỈNH FANSIPAN - SAPA - HÀ NỘI (Ăn Sáng, Trưa)</strong><br><strong>7h00:</strong> Quý khách dùng bữa sáng tại khách sạn.<br><strong>8h00:</strong> Sau bữa ăn sáng: Xe đón Quý khách khởi hành ra ga <a href=\"https://dulichsapa.org.vn/diem-du-lich/cap-treo-fansipan/\">cáp trep Fansipan</a>, đi cáp treo 3 dây dài nhất thế giới với chiều dài 6.292,5m. Quý khách sẽ được ngắm nhìn thung lũng Mường Hoa, dãy Hoàng Liên Sơn và biển mây tuyệt đẹp từ trên cao.<br>Sau 15 phút đi cáp treo, Quý khách tiếp tục leo bộ 604 bậc thang để đến với <a href=\"https://dulichsapa.org.vn/diem-du-lich/phan-xi-pang-sapa/\">đỉnh Fansipan</a>. Quý khách chụp hình để lưu lại khoảnh khách đáng nhớ này.<br>Sau đó Quý khách trở lại ga cáp treo để di chuyển xuống.<br><strong>11h30:</strong> Xe đón Quý khách về lại thị trấn.<br><strong>12h00:</strong> Quý khách làm thủ tục trả phòng. Sau đó dùng bữa trưa.<br>Sau bữa trưa Quý khách tự do mua sắm đặc sản địa phương về làm quà cho người thân hoặc ngồi nhâm nhi thưởng thức hương vị cà phê phố núi và hít thở không khí dịu mát nơi đây.<br><strong>13h30-14h00:</strong> Quý khách lên xe giường nằm khởi hành về lại Hà Nội.<br><strong>19h30-20h00:</strong> Về đến Hà Nội. Xe đưa Quý khách về điểm đón ban đầu, kết thúc hành trình khám phá thị trấn trong sương 2 ngày 1 đêm đầy thú vị.<br>Tạm biệt và hẹn gặp lại Quý khách trong những hành trình du lịch lần sau.</p>', 2, 'Tour du lịch Sapa', 1, NULL, ''),
(13, '09d055ad-c81f-47e6-827f-652b1603e6f1du-lich-da-lat-4-ngay-3-dem.png', 'Chuồn Chuồn Bistro - Đồi Săn Mây', 'Hồ Chí Minh', 6979000, 'Đà Lạt mộng mơ nơi mimosa và ngàn hoa khoe sắc, từ đồi Robin ngắm Hồ Tuyền Lâm, núi Voi, viếng Thiền Viện Trúc Lâm', 1, '2024-11-17 00:00:00.000000', '2024-12-15 00:00:00.000000', '<h3><strong>GIÁ TOUR BAO GỒM</strong></h3><ul><li><strong>Vận chuyển:</strong>&nbsp;Xe tham quan 29 chỗ Thaco/ Mini&nbsp; Univers hoặc xe giường nằm 40 chỗ , đời mới, băng đôi, ghế bật, máy lạnh.&nbsp; Đạt tiêu chuẩn du lịch. Bố trí xe phù hợp với số lượng khách đăng ký.</li><li><strong>Lưu trú:&nbsp;Resort 4 Sao: Resort Wonder / Tearacota</strong></li></ul><p>+ Trung tâm Đà Lạt, gần chợ đêm, trang thiết bị mới, sáng buffet tại khách sạn<br>+ Tiện nghi trong phòng: máy lạnh, tivi, hệ thống nước nóng, vệ sinh khép kín. Phòng từ 2 -&nbsp;3 khách.</p><ul><li><strong>Ăn uống:</strong></li></ul><p>+ Ăn sáng: + 01 bữa sáng ngày đầu: 1 Tô + 1 Ly tại nhà hàng</p><p>+ 02 bữa sáng ngày 2 + 3: Buffet sáng nếu chọn 3 sao.</p><p>+ Ăn chính: 5 bữa<br>+&nbsp;3 bữa Ăn chính: 150.000 VND / 1 suất, gồm 6 - 7 món ngon, hợp vệ sinh.<br>+ 01 bữa đặc sản buffet lẩu rau LEGUDA: 160.000 VND / 1 suất <br> + 1 bữa Đặc sản Lẩu gà lá é&nbsp;+ Cơm niêu.</p><ul><li><strong>Hướng dẫn viên</strong>:</li></ul><p>+ Mỗi xe 1 HDV/Xe , HDV Tiếng Việt thuyết minh và phục vụ ăn, nghỉ, tham quan cho Quý khách , hoạt náo ,tổ chức các trò chơi vận động tập thể, sinh hoạt , ca hát.<br>+ Đội ngũ Hướng dẫn viên trẻ, năng động, nhiệt tình.</p><ul><li><strong>Bảo hiểm: </strong>Khách được bảo hiểm du lịch&nbsp;trọn gói, mức bồi thường tối đa 100.000.000đ/trường hợp. Thuốc Y tế thông thường.</li><li><strong>Quà tặng: </strong>Mỗi vị khách trên đường đi được phục vụ, 01 khăn lạnh, 02 chai nước tinh khiết 0.5l / ngày / người.</li><li><strong>Tham quan:</strong>&nbsp;Bao gồm phí vào cổng tại các điểm tham quan nêu trên chương trình.</li></ul>', 3, 'Tour Đà Lạt 3 Ngày 2 Đêm', 1, NULL, NULL),
(14, '33ee3c1e-65e5-479e-b4c7-ab8e0b2637a6hq720.jpg', 'Thung Lũng Loris - Versailles - Tháp Eiffel...', 'Hồ Chí Minh', 150005000, 'Khám Phá Kinh Đô Ánh Sáng Và Vẻ Đẹp Nước Pháp', 2, '2025-01-04 00:00:00.000000', '2024-12-30 00:00:00.000000', '<h2><strong>Ngày 1: TP.HCM – Paris (Ăn tối)</strong></h2><p><strong>Sáng</strong>: HDV <a href=\"https://www.vietnambooking.com/du-lich\"><strong>công ty du lịch Vietnam Booking</strong></a>&nbsp;đón du khách tại ga quốc tế sân bay Tân Sơn Nhất để đáp chuyến bay khởi hành đi du lịch Paris&nbsp;nước Pháp.</p><p>Du khách đáp xuống sân bay Charles de Gaulle, hdv hỗ trợ đoàn làm thủ tục nhập cảnh vào nước Pháp.</p><p><strong>Tối: </strong>Du khách dùng bữa tối tại nhà hàng địa phương và về khách sạn nhận phòng, nghỉ đêm tại Paris hoặc tự do khám phá Paris về đêm.</p><h2><strong>Ngày 2: Thung Lũng Loris -&nbsp;Lâu Đài Chenonceau (Ăn 3 bữa)</strong></h2><p><strong>Sáng:</strong> Du khách dùng bữa sáng tại khách sạn. Sau đó, xe và HDV đưa du khách đi tham quan các địa điểm có trong chương trình tour như Thung lũng Loris (Loire Valley), nơi được mệnh danh là thung lũng của những tòa lâu đài. Hầu hết những lâu đài ở Loris đều xây dựng từ thời Trung đại và Phục hưng bằng chất liệu đá cẩm thạch, hoa cương, lung linh soi bóng nước được bảo tồn gần như nguyên vẹn đến ngày nay.</p><p><strong>Trưa, chiều:</strong> du khách ăn trưa tại nhà hàng địa phương. Sau đó, tiếp tục chương trình du khách đi tham quan:</p><ul><li>Lâu đài Chenonceau một tòa lâu đài nằm vắt ngang qua sông Cher và được người dân Pháp gọi là lâu đài quý bà, vì những người có công chính cho xây dựng đều là các phụ nữ. Lâu đài Chenonceau được xem là một trong những lâu đài cổ đẹp nhất trong 300 tòa lâu đài tại thung lũng Loire.</li><li>Hầm rượu Chenonceau: Thung lũng sông Loire không chỉ nổi tiếng với hệ thống lâu đài tuyệt đẹp mà nơi đây còn được biết đến là vùng trồng nho và nghề làm rượu vang có từ thời La Mã. Chính vì vậy mà hiện nay rượu vang từ Loire vẫn là loại rượu sang trọng và hoàn hảo bậc nhất nước Pháp.</li></ul><p><strong>Tối</strong>: Đoàn dùng cơm tối và về khách sạn để nghỉ ngơi.</p><h2><strong>Ngày 3: Versailles - Bảo tàng Lourve – Du ngoạn sông Sein (Ăn 3 bữa)</strong></h2><p><strong>Sáng</strong>: Du khách dùng bữa sáng tại khách sạn và khởi hành đi tham quan những địa danh nổi tiếng của nước Pháp:</p><ul><li>Cung điện Versailles nơi được xem là biểu tượng quyền lực của các triều đại phong kiến Pháp. Versailles nổi tiếng bởi đây là một công trình kiến trúc đẹp và quy mô. Kiến trúc của cung điện tuân theo những quy tắc chuẩn mực của chủ nghĩa cổ điển được lấy cảm hứng từ truyền thuyết và nghệ thuật cổ đại, kết hợp với nghệ thuật Baroque.</li><li>Bảo tàng Lourve tọa lạc bên dòng sông Seine, nằm tại khu vực trung tâm thủ đô Paris. Trước đây, Lourve vốn là một pháo đài được xây dựng vào năm 1190. Ngày nay, bảo tàng Lourve là nơi trưng bày các hiện vật về những nền văn minh cô, nghệ thuật Hồi giáo, nghệ thuật Châu âu với nhiều tác phẩm nổi tiếng như: Tranh Mona Lisa, Bia đá Mesia, Tượng thần vệ nữ,… (tham quan bên trong bảo táng chi phí tự túc).</li><li>Du khách đi du ngoạn bằng tàu trên dòng sông Sein, ngắm cảnh Paris từ hướng dòng sông thơ mộng (chi phí tự túc).</li></ul><p><strong>Tối</strong>: Du khách dùng cơm tối tại nhà hàng địa phương, sau đó đoàn về khách sạn nghỉ ngơi.</p><h2><strong>Ngày 4: Paris – City tour (Ăn sáng)</strong></h2><p><strong>Sáng:</strong> Du khách dùng điểm tâm sáng tại khách sạn. Sau đó, du khách sẽ có một ngày tự do để đi tham quan, mua sắm tại các trung tâm thương mại sầm uất của Paris. Ngắm cảnh đường phố hay thưởng thức những món ẩm thực đặc trưng của người Pháp.</p><p>Du khách tự túc bữa tối và nghỉ ngơi tại khách sạn chuẩn bị cho chương trình <a href=\"https://www.vietnambooking.com/du-lich/tour-du-lich/du-lich-phap.html\"><strong>du lịch Pháp</strong></a> ngày mai.</p><h2><strong>Ngày 5: Tháp Eiffel – Nhà thờ Đức Bà – Điện Invalides (Ăn 3 bữa)</strong></h2><p><strong>Sáng:</strong> Du khách dùng bữa sáng tại khách sạn và làm thủ tục trả phòng. HDV và xe sẽ đưa du khách tiếp tục đi tham quan:</p><ul><li>Tháp Eiffel một công trình kiến trúc bằng thép nằm bên sông Seine, được xem như là biểu tượng của nước Pháp và là công trình kỷ niệm 100 năm cách mạng Pháp (tham quan bên ngoài ).</li><li>Quảng trường Trocadero có đường kính 164m, là nơi đặt là bức tượng Thống chế Ferdinand Foch cùng một công trình vinh danh quân đội Pháp. Bên cạnh quảng trường là Cung Chaillot và vườn hoa Trocadéro, nhìn sang bên kia sông là tháp Eiffel.</li></ul><p><strong>Trưa, chiều</strong>: Du khách ăn trưa tại nhà hàng địa phương, buổi chiều đoàn tiếp tục tham quan:</p><ul><li>Nhà thờ Đức Bà Paris (Notre Dame de Paris) là nhà thờ Chánh tòa công giáo có kiến trúc lối Gothic tiêu biểu và nổi tiếng thế giới.</li><li>Khải hoàn môn (L’Arc de Triomphe): Là một công trình kiến trúc biểu tượng cho lịch sử nước Pháp nằm giao của 12 đại lộ và 3 quận ở Paris, được xây dựng và khánh thành năm 1836.</li><li>Đại lộ Élysees (Champs Élysées): Hay còn được gọi là đại lộ thiên đường là con đường lớn nhất và nổi tiếng nhất ở Pháp.</li><li>Điện Invalides là một công trình phức hợp được vua Louis XIV cho xây dựng cuối thế kỷ 17 để làm bệnh viện quân đội hoàng gia.</li></ul><p><strong>Tối:</strong> Du khách theo HDV ra sân bay, làm thủ tục cho chuyến bay về Việt Nam. Du khách dùng bữa tối trên máy bay.</p><h2><strong>Ngày 6: Paris – TP.HCM (Ăn trên máy bay)</strong></h2><p>Du khách dùng bữa sáng trên máy bay</p><p>Sau khi đáp xuống sân bay Tân Sơn Nhất, trưởng đoàn giúp du khách làm thủ tục nhập cảnh và tạm biệt du khách, kết thúc chuyến <strong>du lịch Paris nước Pháp&nbsp;</strong>nhiều kỉ niệm. Hẹn gặp lại du khách trong những <strong>tour </strong>Paris&nbsp;sau.</p>', 6, 'Tour du lịch Pháp 6N5Đ', 1, NULL, NULL),
(15, 'bf0a9949-c9db-4f4a-a3cc-f14be788423bdu-lich-y.png', 'ROME-VATICAN-FLORENCE-VENICE-MILAN', 'Đà Nẵng', 139868000, 'CHIÊM NGƯỠNG VẺ ĐẸP CỔ KÍNH TẠI ITALIA', 2, '2024-12-14 00:00:00.000000', '2024-12-09 00:00:00.000000', '<p><strong>Tour này có gì hay</strong></p><p>- Hành trình đặc sắc khám phá nước Ý lãng mạn, tìm hiểu cuộc sống thanh bình và con người nơi đây với giá tiết kiệm đặc biệt của Saigontourist - Thưởng ngoạn các danh lam thắng cảnh, chiêm ngưỡng các công trình kiến trúc, các chứng tích lịch sử cổ kính, những kiệt tác của các hoạ sỹ thiên tài… - Đặc biệt, khám phá một Vatican nhỏ bé nhưng đầy bí ẩn trong lòng Rome !</p><p><strong>NGÀY 1 – 29/04/2020 : ĐÀ NẴNG&nbsp; - DOHA –&nbsp;&nbsp; ROME (Ăn trưa, tối trên máy bay)</strong><br>Qúy khách có mặt tại ga quốc tế của sân bay Đà Nẵng, hướng dẫn viên đón khách và làm thủ tục đi Tp. Doha – Qatar (<strong>QR997,08:40-12:55</strong>). Đoàn tiếp tục nối chuyến đi Rome (<strong>QR113, 16:10 – 21:15</strong>). Đoàn đến sân bay <strong>Leonardo da Vinci</strong>, quý khách làm thủ tục nhập cảnh <strong>Rome. </strong>Đoàn đến khu vực lấy hành lí và di chuyển ra cổng sân bay. Xe đón đoàn về khách sạn nghỉ ngơi. Nghỉ đêm tại Rome.</p><p><strong>NGÀY 2 – 30/04/2020 : ROME – VATICAN (Ăn sáng, trưa, tối)</strong><br>Đoàn tham quan <strong>Vatican</strong> – quốc gia nhỏ nhất thế giới về diện tích và dân số nhưng rất giàu có và quyền lực. Quý khách sẽ khám phá bảo tàng Vatican nổi tiếng với bộ sưu tập nghệ thuật lớn nhất thế giới, nơi trưng bày nhiều kiệt tác thời Phục Hưng cùng với nhà nguyện Sixtine. Tham quan bên trong Đại <strong>Thánh đường &amp; quảng trường Saint Peter</strong> Basillica hay còn gọi là Saint Pietro - nơi thiêng liêng nhất ở Vatican, điểm thu hút tín đồ và du khách khắp thế giới. Chiều, tham quan quảng trường Tây Ban Nha, điện Pantheon, <strong>đài phun nước Trevi</strong> – một kiệt tác vĩnh cữu của các nhà nghệ thuật Ý. Các <strong>bậc thang</strong> <strong>Tây Ban Nha</strong> (Spanish Steps): công trình kiến trúc có lối đi bậc thang gồm 135 bậc – nơi thu hút đông đạo du khách từ khắp thế giới đến tham quan, cũng là điểm tụ tập và hẹn hồ của dân địa phương. Tự do mua sắm. Ăn tối, nghỉ đêm ở Rome.</p><p><strong>NGÀY 3 – 01/05/2020 : ROME - FLORENCE (Ăn sáng, trưa, tối)</strong><br>Đoàn khởi hành đi Florence (273km), khám phá <strong>thành phố Florence - </strong>cái nôi của kinh đô nghệ thuật, nơi quy tụ các giá trị văn hóa tiêu biểu thời Trung cổ. Dừng chân chụp hình tại <strong>Thánh đường</strong> <strong>Duomo</strong> <strong>Santa Maria del Fiore</strong> nguy nga mang phong cách Gothic và chiêm ngưỡng bản sao <strong>bức tượng Chàng David</strong> <strong>tại Quảng trường Piazzale Michelangelo; </strong>ngắm nhìn <strong>cây cầu Ponte Vecchio</strong> vắt ngang sông Arno - một trong những cây cầu đẹp nhất thế giới được xây dựng theo kiến trúc Trung Cổ Ăn tối. Nghỉ đêm tại Florence.</p><p><strong>NGÀY 4 – 02/05/2020 : FLORENCE - VENICE (Ăn sáng, trưa, tối)</strong><br>Đoàn khởi hành đi<strong> Venice (256 km) - </strong>điểm đến lãng mạn trong hành trình tour du lịch Ý. Đoàn lên tàu từ bến Tronchetto di chuyển đến bến tàu San Marco để lên đảo chính Venice. Ăn trưa trên đảo Venice. Tham quan và chụp hình bên ngoài <strong>dinh Tổng Trấn (Doge’s palace)</strong> với nghệ thuật trang trí vô cùng độc đáo và ấn tượng, thăm <strong>quảng trường San Marco, nhà thờ mái vòm San Marco</strong> – được đặt tên theo vị thần bảo hộ của thành phố, <strong>Tháp chuông</strong>, <strong>cây cầu của những tiếng thở dài (Bridges of Sighs)</strong> – nổi tiếng nhất thành Venice với thiết kế cong mỹ miều. Quý khách có thể trải nghiệm ngồi <strong>thuyền gỗ Gondola</strong> dập dìu trên những kênh đào, tham quan các ngõ ngách của Venice lãng mạn (chi phí tự túc). Tham qua nhà máy thủy tinh <strong>Glass Blowing Factory</strong>.Về lại đất liền, ăn tối.&nbsp; Nhận phòng khách sạn. Nghỉ đêm tại Venice.</p><p><strong>NGÀY 5 – 03/05/2020 : VENICE - MILAN –DOHA (Ăn sáng, trưa, tối)</strong><br>Đoàn khởi hành khởi hành đi Milan (264km) - trung tâm thời trang của nước Ý. Dừng chân chụp hình <strong>Thánh đường Duomo Milan</strong> thiêng liêng được xây dựng từ năm 1386, chụp hình bên ngoài<strong> lâu đài Sforza </strong>và<strong> nhà hát La Scala</strong> và bức tượng của danh họa nổi tiếng <strong>Leonardo Da Vinci</strong>.&nbsp; Ăn tối tại nhà hàng. Đoàn tiễn khách ra sân bay <strong>Malpensa</strong>, đáp chuyến bay đi <strong>Doha</strong> <strong>(QR118, 22:55 – 05:35 +1).</strong></p><p><strong>NGÀY 6 – 04/05/2020 : DOHA - ĐÀ NẴNG</strong><br>Đến Doha, đoàn tiếp tục nối chuyến về <i><strong>Đà Nẵng</strong></i> <strong>(QR994, 08:25 – 19:25).</strong> Ăn nghỉ trên máy bay. Đến Đà Nẵng. Kết thúc chương trình. Chào tạm biệt.</p>', 6, 'DU LỊCH ITALY', 1, NULL, NULL),
(16, '469119f5-d8c0-4561-91b1-e4e14ecb7ad7vietgoing_gcn2101205075.jpg.webp', ' Hang Sửng Sốt - Đảo TiTốp - Hang Luồn.', 'Hà Nội', 2999000, 'Tour Hạ Long Trong Ngày: Du Thuyền Ambassador II 5 Sao', 1, '2024-12-05 00:00:00.000000', '2024-12-05 00:00:00.000000', '<h2><strong>Chương trình tour</strong></h2><p><strong>08:30 – 09:15:</strong>&nbsp;Du khách tập trung ở sảnh đón khách tầng 1, Cảng tàu khách quốc tế Hạ Long, để check-in và lên Du thuyền Ambassador II.</p><p><i>Du thuyền Ambassador II: Một trải nghiệm du lịch sang trọng và đẳng cấp trên vịnh Hạ Long, cung cấp các dịch vụ và tiện nghi cao cấp.</i></p><p><strong>09:00&nbsp;- 10:00:</strong>&nbsp;Thưởng thức bữa sáng nhẹ trên du thuyền</p><p><strong>09:30 – 11:00:</strong>&nbsp;Khi di chuyển qua Vịnh Hạ Long và Bái Tử Long trên Du thuyền Ambassador, du khách sẽ được chiêm ngưỡng cảnh quan núi đá vôi hùng vĩ.</p><p><i>Vịnh Bái Tử Long: Một kỳ quan thiên nhiên kỳ vĩ với những dãy núi đá vôi tráng lệ, cảnh quan yên bình và sự đa dạng sinh học.</i></p><p><strong>11:00 – 12:00:</strong>&nbsp;Thăm quan <strong>hang Sửng Sốt</strong> – một trong mười hang động đẹp nhất Thế giới – nằm ở trung tâm Di sản thiên nhiên thế giới <strong>vịnh Hạ Long</strong>.</p><p><i>Hang Sửng Sốt – một trong mười hang động đẹp nhất Thế giới – nằm ở trung tâm Di sản thiên nhiên thế giới vịnh Hạ Long.</i></p><p><strong>12:00&nbsp;- 12:45:&nbsp;Tham quan đảo&nbsp;TiTốp</strong></p><p><i>Đảo Ti-tốp, hòn đảo sở hữu cảnh sắc thiên nhiên hữu tình cùng bãi tắm</i><br><i>tuyệt đẹp có hình dáng như một vầng trăng ôm trọn lấy chân đảo.</i></p><p><strong>12:30 – 14:00:</strong>&nbsp;Thưởng thức bữa trưa thượng hạng tại nhà hàng sang trọng.</p><p><i>Bữa trưa thượng hạng tại nhà hàng du thuyền Ambassador Cruise: Ẩm thực cao cấp và không gian sang trọng.</i></p><p>14:00 – 15:00:&nbsp;Tham quan Hang Luồn.</p><p>Hang Luồn: Một điểm tham quan nổi bật ở Vịnh Hạ Long, nổi tiếng với hang động tự nhiên huyền bí và cảnh quan thiên nhiên tươi đẹp xung quanh.</p><p>15:30 – 16:00:&nbsp;Trải nghiệm lớp học nấu ăn tại nhà hàng tầng 4.</p><p><i>Lớp học nấu ăn trên tàu: Bếp trưởng dạy nấu ăn Việt, tổ chức trên boong tàu hoặc trong nhà hàng.</i></p><p>15:30 – 16:45:&nbsp;Thưởng thức nhạc sống trên sundeck (trừ Thứ Hai)</p><p><i>Thưởng thức nhạc sống trên sundeck (trừ Thứ Hai) trong khi du thuyền trở về cảng.</i></p><p>16:45: Du thuyền cập bến cảng.</p><p><i>Thứ tự tham quan có thể thay đổi nhưng vẫn đảm bảo đầy đủ điểm trong chương trình.</i></p>', 1, 'Tour Hạ Long', 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tour_start`
--

CREATE TABLE `tour_start` (
  `id` bigint NOT NULL,
  `ngay_khoi_hanh` datetime(6) DEFAULT NULL,
  `tour_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tour_start`
--

INSERT INTO `tour_start` (`id`, `ngay_khoi_hanh`, `tour_id`) VALUES
(1, '2024-12-01 00:00:00.000000', 1),
(2, '2024-12-29 00:00:00.000000', 1),
(3, '2024-12-16 00:00:00.000000', 1),
(4, '2024-11-26 00:00:00.000000', 1),
(5, '2025-01-12 00:00:00.000000', 1),
(7, '2024-12-30 00:00:00.000000', 3),
(10, '2025-01-25 00:00:00.000000', 1),
(11, '2024-11-23 00:00:00.000000', 1),
(12, '2024-12-26 00:00:00.000000', 6),
(13, '2024-12-29 00:00:00.000000', 6),
(14, '2025-01-17 00:00:00.000000', 6),
(15, '2024-12-19 00:00:00.000000', 7),
(16, '2024-12-22 00:00:00.000000', 7),
(17, '2025-01-01 00:00:00.000000', 7),
(18, '2025-01-09 00:00:00.000000', 7),
(19, '2025-01-16 00:00:00.000000', 7),
(20, '2024-12-02 00:00:00.000000', 5),
(21, '2024-12-15 00:00:00.000000', 5),
(22, '2024-12-19 00:00:00.000000', 5),
(23, '2024-12-23 00:00:00.000000', 5),
(24, '2024-12-26 00:00:00.000000', 5),
(25, '2024-12-06 00:00:00.000000', 9),
(26, '2024-12-01 00:00:00.000000', 9),
(27, '2025-01-01 00:00:00.000000', 9),
(29, '2025-01-03 00:00:00.000000', 9),
(30, '2024-12-20 00:00:00.000000', 10),
(31, '2024-12-26 00:00:00.000000', 10),
(32, '2025-02-01 00:00:00.000000', 10),
(33, '2025-02-22 00:00:00.000000', 10),
(34, '2025-01-02 00:00:00.000000', 11),
(35, '2025-01-09 00:00:00.000000', 11),
(36, '2025-01-16 00:00:00.000000', 11),
(37, '2025-01-23 00:00:00.000000', 11),
(38, '2024-12-23 00:00:00.000000', 12),
(39, '2024-12-30 00:00:00.000000', 12),
(40, '2025-01-06 00:00:00.000000', 12),
(41, '2025-01-13 00:00:00.000000', 12),
(42, '2024-12-02 00:00:00.000000', 13),
(43, '2024-12-08 00:00:00.000000', 13),
(44, '2024-12-14 00:00:00.000000', 13),
(45, '2024-12-28 00:00:00.000000', 13),
(46, '2024-12-06 00:00:00.000000', 14),
(47, '2024-12-13 00:00:00.000000', 14),
(48, '2024-12-20 00:00:00.000000', 14),
(49, '2024-12-09 00:00:00.000000', 15),
(50, '2024-12-23 00:00:00.000000', 15),
(51, '2025-01-06 00:00:00.000000', 15),
(52, '2025-01-20 00:00:00.000000', 15),
(53, '2024-12-14 00:00:00.000000', 16),
(54, '2024-12-21 00:00:00.000000', 16),
(55, '2024-12-28 00:00:00.000000', 16),
(56, '2025-01-04 00:00:00.000000', 16),
(57, '2024-12-27 00:00:00.000000', 1),
(58, '2024-12-27 00:00:00.000000', 6),
(59, '2024-12-27 00:00:00.000000', 12),
(60, '2024-12-27 00:00:00.000000', 3),
(61, '2025-01-01 00:00:00.000000', 3),
(62, '2025-01-04 00:00:00.000000', 3),
(63, '2025-01-11 00:00:00.000000', 3);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gioi_tinh` varchar(255) DEFAULT NULL,
  `ho_ten` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` int DEFAULT NULL,
  `sdt` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `auth_provider` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `dia_chi`, `email`, `gioi_tinh`, `ho_ten`, `password`, `role`, `sdt`, `username`, `auth_provider`) VALUES
(2, 'TN', 'nguyenhoanganh132003@gmail.com', 'Nam', 'Nguyễn Hoàng Anh', '$2a$10$w3lq/pEgzayB1XXMvOuC1O7klr7qlakMDjlcDfZvk4Kk3oNrJxsWa', 1, '0987654321', 'Hoanganh', 'GOOGLE'),
(3, 'Tây Ninh', 'user', 'Nam', 'User1', '$2a$10$eXQSmPKe/vWKYDFRwtsok.0znWt/65dXxZyrOhNSknX.0JVI0DP/6', 1, '09843264536', 'User1', 'LOCAL'),
(4, 'Hồ Chí Minh', 'user@gmail.com', 'Nam', 'Tester', '$2a$10$BJADLdRakNDgS4WMWKStluRCSlggZKXXTli0JYyRhCGmKgcUNWYrK', 1, '0987654321', 'User2', 'LOCAL'),
(5, 'Hồ Chí Minh', 'anhnhtech@gmail.com', 'Nam', 'Hoàng Anh', '$2a$10$Qicz/mAyLM4YE5SVpVfp5.oyU5JX/8jf9Sv6U9/AU7oQvSwiKJek2', 1, '0135792468', 'anhnhtech', 'GOOGLE'),
(6, 'Hồ Chí Minh', 'Anh123@gmail.com', 'Nam', 'Admin', '$2a$10$87zO6EzRM5FO05OoX7ILeevwK48EVKZO2z4lBbWU1eU70zZXHB0TO', 0, '0909090909', 'Hoanganh779', 'LOCAL'),
(7, 'bà rịa', 'user3@gmail.com', 'Nam', 'Hoannganh', '$2a$10$XF8CPAqfK2Ee7zPNve8bXu52nYcbJRH5zJ7nAqmfwLNhN6MHPnJQW', 1, '0984657231', 'user3', NULL),
(8, 'Hồ Chí Minh', 'Hoanganh1234@gmail.com', 'Nam', 'Nguyễn Hoàng Anh', '$2a$10$PZN5H04CEZORjg/DWIQdjuOWHXgSyFWrQfu/nfOOybZ4f2qCS3yAC', 1, '097845372', 'Hoanganh123', NULL),
(9, 'Gò vấp', 'Hoanganh70@gmail.com', 'Nam', 'Nguyễn Hoàng Anh', '$2a$10$1P5OcjyIEMahmOlcel9Nb.N6SJTUN5NmQckiVYByOzo2DsRl0Zvji', 1, '0987454312', 'Hoanganh70', NULL),
(10, 'Gò Vấp', 'Anhnguyen69@gmail.com', 'Nam', 'Nguyễn Hoàng Anh', '$2a$10$9ymkSHcZFFzGUdOC8zBgRuN4JVwIlFVViv.uksjEP1/qATfOfl7GW', 1, '0978563429', 'Hoanganh69', NULL),
(12, 'Tây Ninh', 'Hoanganh79@gmail.com', 'Nam', 'Nguyễn Hoàng Anh', '$2a$10$J1TKibIB/EhhK7/bghCF7eQmLSs1Ue1XbzoImBF.J28hkaUyItliG', 1, '0987635421', 'Hoanganh79', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `destination`
--
ALTER TABLE `destination`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tin_tuc`
--
ALTER TABLE `tin_tuc`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tour`
--
ALTER TABLE `tour`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tour_start`
--
ALTER TABLE `tour_start`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT for table `destination`
--
ALTER TABLE `destination`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `image`
--
ALTER TABLE `image`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `tin_tuc`
--
ALTER TABLE `tin_tuc`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tour`
--
ALTER TABLE `tour`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `tour_start`
--
ALTER TABLE `tour_start`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
