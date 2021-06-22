-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: plasmabank
-- ------------------------------------------------------
-- Server version	8.0.24

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
-- Temporary view structure for view `hospitalbycity`
--

DROP TABLE IF EXISTS `hospitalbycity`;
/*!50001 DROP VIEW IF EXISTS `hospitalbycity`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `hospitalbycity` AS SELECT 
 1 AS `h_id`,
 1 AS `h_name`,
 1 AS `h_type`,
 1 AS `h_address`,
 1 AS `h_state`,
 1 AS `h_city`,
 1 AS `h_email`,
 1 AS `h_contactno`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `showdonor`
--

DROP TABLE IF EXISTS `showdonor`;
/*!50001 DROP VIEW IF EXISTS `showdonor`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `showdonor` AS SELECT 
 1 AS `d_id`,
 1 AS `d_name`,
 1 AS `d_bg`,
 1 AS `d_age`,
 1 AS `d_units`,
 1 AS `d_state`,
 1 AS `d_city`,
 1 AS `d_contactno`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `seekerbydate`
--

DROP TABLE IF EXISTS `seekerbydate`;
/*!50001 DROP VIEW IF EXISTS `seekerbydate`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `seekerbydate` AS SELECT 
 1 AS `s_id`,
 1 AS `s_name`,
 1 AS `s_bg`,
 1 AS `s_units`,
 1 AS `s_date`,
 1 AS `s_city`,
 1 AS `s_state`,
 1 AS `s_contactno`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `plasmabankcity`
--

DROP TABLE IF EXISTS `plasmabankcity`;
/*!50001 DROP VIEW IF EXISTS `plasmabankcity`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `plasmabankcity` AS SELECT 
 1 AS `p_id`,
 1 AS `p_name`,
 1 AS `p_state`,
 1 AS `p_city`,
 1 AS `p_contactno`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `hospitalbycity`
--

/*!50001 DROP VIEW IF EXISTS `hospitalbycity`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `hospitalbycity` AS select `hospital`.`h_id` AS `h_id`,`hospital`.`h_name` AS `h_name`,`hospital`.`h_type` AS `h_type`,`hospital`.`h_address` AS `h_address`,`hospital`.`h_state` AS `h_state`,`hospital`.`h_city` AS `h_city`,`hospital`.`h_email` AS `h_email`,`hospital`.`h_contactno` AS `h_contactno` from `hospital` order by `hospital`.`h_state`,`hospital`.`h_city` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `showdonor`
--

/*!50001 DROP VIEW IF EXISTS `showdonor`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `showdonor` AS select `donor`.`d_id` AS `d_id`,`donor`.`d_name` AS `d_name`,`donor`.`d_bg` AS `d_bg`,`donor`.`d_age` AS `d_age`,`donor`.`d_units` AS `d_units`,`donor`.`d_state` AS `d_state`,`donor`.`d_city` AS `d_city`,`donor`.`d_contactno` AS `d_contactno` from `donor` order by `donor`.`d_age`,`donor`.`d_bg` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `seekerbydate`
--

/*!50001 DROP VIEW IF EXISTS `seekerbydate`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `seekerbydate` AS select `seeker`.`s_id` AS `s_id`,`seeker`.`s_name` AS `s_name`,`seeker`.`s_bg` AS `s_bg`,`seeker`.`s_units` AS `s_units`,`seeker`.`s_date` AS `s_date`,`seeker`.`s_city` AS `s_city`,`seeker`.`s_state` AS `s_state`,`seeker`.`s_contactno` AS `s_contactno` from `seeker` order by `seeker`.`s_date` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `plasmabankcity`
--

/*!50001 DROP VIEW IF EXISTS `plasmabankcity`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `plasmabankcity` AS select `plasmabank`.`p_id` AS `p_id`,`plasmabank`.`p_name` AS `p_name`,`plasmabank`.`p_state` AS `p_state`,`plasmabank`.`p_city` AS `p_city`,`plasmabank`.`p_contactno` AS `p_contactno` from `plasmabank` order by `plasmabank`.`p_city` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-22 16:12:00
