CREATE DATABASE  IF NOT EXISTS `tp_grupo37` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `tp_grupo37`;

-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: tp_grupo37
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cantidad_comprada` int NOT NULL,
  `fecha_compra` datetime(6) DEFAULT NULL,
  `total` double NOT NULL,
  `fk_cliente` int NOT NULL,
  `fk_producto` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq5ptidjteu82shi34nwb0gmic` (`fk_cliente`),
  KEY `FK3ghtm394j9k3brflokdcxa82u` (`fk_producto`),
  CONSTRAINT `FK3ghtm394j9k3brflokdcxa82u` FOREIGN KEY (`fk_producto`) REFERENCES `producto` (`id`),
  CONSTRAINT `FKq5ptidjteu82shi34nwb0gmic` FOREIGN KEY (`fk_cliente`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (1,1,'2024-06-15 12:24:05.470979',23589214.75,2,3);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lote`
--

DROP TABLE IF EXISTS `lote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lote` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cantidad_recibida` int NOT NULL,
  `fecha_recepcion` datetime(6) DEFAULT NULL,
  `precio_producto` double NOT NULL,
  `fk_pedido` bigint NOT NULL,
  `fk_producto` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKnvuq3403ydnwvw4o889wmieek` (`fk_pedido`),
  KEY `FKj26amcmsqgxw2rid9i83wtepe` (`fk_producto`),
  CONSTRAINT `FK70kf29do7im1igdeqkd5rjg96` FOREIGN KEY (`fk_pedido`) REFERENCES `pedido` (`id`),
  CONSTRAINT `FKj26amcmsqgxw2rid9i83wtepe` FOREIGN KEY (`fk_producto`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lote`
--

LOCK TABLES `lote` WRITE;
/*!40000 ALTER TABLE `lote` DISABLE KEYS */;
/*!40000 ALTER TABLE `lote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cantidad_pedida` int NOT NULL,
  `proveedor` varchar(45) NOT NULL,
  `fk_admin` int NOT NULL,
  `fk_producto` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjyvc9uo2mkop2kac5475cp4a3` (`fk_admin`),
  KEY `FKnov35d48jsm6knv2eq5fdyxi4` (`fk_producto`),
  CONSTRAINT `FKjyvc9uo2mkop2kac5475cp4a3` FOREIGN KEY (`fk_admin`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FKnov35d48jsm6knv2eq5fdyxi4` FOREIGN KEY (`fk_producto`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `activo` bit(1) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `precio` double NOT NULL,
  `fk_stock` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK7y7upyrd7bcuu01mqj8nungfo` (`fk_stock`),
  CONSTRAINT `FKi4a5ie0q1le7kbbrfxedtormo` FOREIGN KEY (`fk_stock`) REFERENCES `stock` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,_binary '\0','colchon comodo','Sommier',358.6,4),(2,_binary '','Es un celular','Celular',254.52,1),(3,_binary '','Es un automovil','Automovil',23589214.75,2),(4,_binary '','Es un Televisor','Televisor',414.59,3);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol_de_usuario`
--

DROP TABLE IF EXISTS `rol_de_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol_de_usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha_actualizacion` datetime(6) DEFAULT NULL,
  `fecha_cracion` datetime(6) DEFAULT NULL,
  `rol` varchar(100) NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe87tiuiwg0i58lvjm9pon8afo` (`user_id`),
  CONSTRAINT `FKe87tiuiwg0i58lvjm9pon8afo` FOREIGN KEY (`user_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol_de_usuario`
--

LOCK TABLES `rol_de_usuario` WRITE;
/*!40000 ALTER TABLE `rol_de_usuario` DISABLE KEYS */;
INSERT INTO `rol_de_usuario` VALUES (1,'2024-06-04 11:00:00.000000','2024-06-04 11:00:00.000000','ROL_ADMIN',1),(2,'2024-06-04 11:00:00.000000','2024-06-04 11:00:00.000000','ROL_USUARIO',2);
/*!40000 ALTER TABLE `rol_de_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cantidad_actual` int NOT NULL,
  `cantidad_critica` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (1,50,20),(2,49,20),(3,20,10),(4,25,5);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `activada` bit(1) NOT NULL,
  `clave` varchar(60) NOT NULL,
  `fecha_actualizacion` datetime(6) DEFAULT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `nombre_de_usuario` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKsj730g58rpsy2ulyrp2hhtxop` (`nombre_de_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,_binary '','$2a$10$kYBrxPXgZnZqkNCezWyufePgbcWRHMRUkACh./XaNlBYQR3q4Qr4K','2024-06-07 10:30:00.000000','2024-06-07 10:30:00.000000','Admin'),(2,_binary '','$2a$10$LAaSq2Un8FJKSf3vXGZZpO.arGHN8blyuEbgZSiDDIf4YXaGOq5ye','2024-06-05 10:30:00.000000','2024-06-05 10:30:00.000000','Cliente');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-15 12:26:18
