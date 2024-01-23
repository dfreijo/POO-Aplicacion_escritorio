-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: mysql_db
-- Tiempo de generación: 20-12-2023 a las 17:10:42
-- Versión del servidor: 8.2.0
-- Versión de PHP: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `eventos`
--
CREATE DATABASE IF NOT EXISTS `eventos` DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci;
USE `eventos`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Actos`
--

CREATE TABLE `Actos` (
  `Id_acto` int NOT NULL,
  `Fecha` date NOT NULL,
  `Hora` time NOT NULL,
  `Titulo` varchar(100) NOT NULL,
  `Descripcion_corta` varchar(2000) NOT NULL,
  `Descripcion_larga` text NOT NULL,
  `Num_asistentes` int NOT NULL,
  `Id_tipo_acto` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `Actos`
--

INSERT INTO `Actos` (`Id_acto`, `Fecha`, `Hora`, `Titulo`, `Descripcion_corta`, `Descripcion_larga`, `Num_asistentes`, `Id_tipo_acto`) VALUES
(1, '2023-12-20', '15:45:00', 'Jazz Fusion', 'Concierto de Jazz', 'Únete a nosotros para una velada inolvidable con músicos de renombre que fusionarán sonidos tradicionales con melodías modernas en un ambiente íntimo y acogedor.', 300, 6),
(2, '2023-12-22', '20:00:00', 'Platos calientes', 'Degustación de platos de cocina creativa', 'Únete a nosotros para una degustación de platos único que jamás hubieras pensado que podrían existir. Deleita tu paladar con sabores que harán explotar tus sentidos.', 130, 5),
(3, '2023-11-24', '16:30:00', 'Cambio climático', 'Concienciación del cambio climático', 'Asiste a una charla interesante sobre el cambio climático, donde descubrirás aspectos que te sorprenderán. Además aprenderás a como puedes aportar frente a este problema global', 200, 1),
(4, '2023-12-12', '10:15:00', 'Cine a la fresca', 'Jornada de cine de accion', 'Ven a una apasionante tarde de cine a la fresca, tan fresca que estaremos a 0 grados bajo cero', 200, 1),
(5, '2023-12-23', '17:00:00', 'Taller bricomanias', 'Fabricación de muebles', 'Aprende a tratar la madera y poder hacer cosas increíbles para tu hogar', 1, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Documentacion`
--

CREATE TABLE `Documentacion` (
  `Id_presentacion` int NOT NULL,
  `Id_acto` int NOT NULL,
  `Localizacion_documentacion` varchar(100) NOT NULL,
  `Orden` int NOT NULL,
  `Id_persona` int NOT NULL,
  `Titulo_documento` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `Documentacion`
--

INSERT INTO `Documentacion` (`Id_presentacion`, `Id_acto`, `Localizacion_documentacion`, `Orden`, `Id_persona`, `Titulo_documento`) VALUES
(1, 3, 'documentos/1702999036_codigo.txt', 1, 3, '1702999036_codigo.txt');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Inscritos`
--

CREATE TABLE `Inscritos` (
  `Id_inscripcion` int NOT NULL,
  `Id_persona` int NOT NULL,
  `id_acto` int NOT NULL,
  `Fecha_inscripcion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `Inscritos`
--

INSERT INTO `Inscritos` (`Id_inscripcion`, `Id_persona`, `id_acto`, `Fecha_inscripcion`) VALUES
(7, 3, 5, '2023-11-23 00:00:00'),
(8, 2, 1, '2023-11-23 00:00:00'),
(9, 3, 1, '2023-11-23 00:00:00'),
(10, 4, 1, '2023-11-23 00:00:00'),
(16, 3, 4, '2023-12-19 15:19:13'),
(17, 1, 4, '2023-12-19 15:58:14'),
(18, 1, 2, '2023-12-20 14:13:18');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Lista_Ponentes`
--

CREATE TABLE `Lista_Ponentes` (
  `id_ponente` int NOT NULL,
  `Id_persona` int NOT NULL,
  `Id_acto` int NOT NULL,
  `Orden` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `Lista_Ponentes`
--

INSERT INTO `Lista_Ponentes` (`id_ponente`, `Id_persona`, `Id_acto`, `Orden`) VALUES
(1, 3, 3, 3),
(2, 3, 4, 10),
(3, 4, 2, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Personas`
--

CREATE TABLE `Personas` (
  `Id_persona` int NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellido1` varchar(50) NOT NULL,
  `Apellido2` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `Personas`
--

INSERT INTO `Personas` (`Id_persona`, `Nombre`, `Apellido1`, `Apellido2`) VALUES
(1, 'Daniel', 'Freijo', 'Fernandez'),
(2, 'David', 'Lopez', 'Aguilera'),
(3, 'Aleix', 'Garcia', 'Aguilera'),
(4, 'Manuel', 'Chillaron', 'Mansolino'),
(5, 'Laura', 'Lopez', 'Fernandez'),
(6, 'Laura', 'Lopez', 'Fernandez'),
(7, 'Laura', 'Lopez', 'Fernandez'),
(8, 'Laura', 'Lopez', 'Fernandez'),
(9, 'Laura', 'Lopez', 'Fernandez'),
(10, 'Laura', 'Lopez', 'Fernandez'),
(11, 'Laura', 'Lopez', 'Fernandez'),
(12, 'Laura', 'Lopez', 'Fernandez'),
(13, 'Laura', 'Lopez', 'Fernandez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Tipos_usuarios`
--

CREATE TABLE `Tipos_usuarios` (
  `Id_tipo_usuario` int NOT NULL,
  `Descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `Tipos_usuarios`
--

INSERT INTO `Tipos_usuarios` (`Id_tipo_usuario`, `Descripcion`) VALUES
(1, 'Usuario'),
(2, 'Ponente'),
(3, 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Tipo_acto`
--

CREATE TABLE `Tipo_acto` (
  `Id_tipo_acto` int NOT NULL,
  `Descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `Tipo_acto`
--

INSERT INTO `Tipo_acto` (`Id_tipo_acto`, `Descripcion`) VALUES
(1, 'Conferencias'),
(2, 'Eventos Cinematograficos'),
(3, 'Eventos Culturales'),
(4, 'Eventos Deportivos'),
(5, 'Eventos Gastronomicos'),
(6, 'Eventos Musicales'),
(7, 'Seminarios'),
(8, 'Talleres');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuarios`
--

CREATE TABLE `Usuarios` (
  `Id_usuario` int NOT NULL,
  `Username` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Id_Persona` int NOT NULL,
  `Id_tipo_usuario` int NOT NULL,
  `Email` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `Usuarios`
--

INSERT INTO `Usuarios` (`Id_usuario`, `Username`, `Password`, `Id_Persona`, `Id_tipo_usuario`, `Email`) VALUES
(1, 'dfreijo13', '123456', 1, 1, 'dfreijo@uoc.edu'),
(2, 'admin', '1234', 2, 3, 'david@gmail.com'),
(3, 'Agarcia', '123456', 3, 2, 'agarcia@gmail.com'),
(4, 'ManuelManso', '123456', 4, 2, 'manso-lino@gmail.com'),
(5, 'laury', '$2y$12$H5d4xa6PS0CaAEdVjiI6xuczvYA.Lf5ZDkL8JOm4kBo0JbQKVT3MO', 13, 1, 'laura@gmail.com');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Actos`
--
ALTER TABLE `Actos`
  ADD PRIMARY KEY (`Id_acto`),
  ADD KEY `FK_Actos_Id_Tipo_Acto` (`Id_tipo_acto`);

--
-- Indices de la tabla `Documentacion`
--
ALTER TABLE `Documentacion`
  ADD PRIMARY KEY (`Id_presentacion`),
  ADD KEY `FK_Documentacion_Id_Acto` (`Id_acto`),
  ADD KEY `FK_Documentacion_Id_Persona` (`Id_persona`);

--
-- Indices de la tabla `Inscritos`
--
ALTER TABLE `Inscritos`
  ADD PRIMARY KEY (`Id_inscripcion`),
  ADD KEY `FK_Inscritos_Id_Persona` (`Id_persona`),
  ADD KEY `FK_Inscritos_Id_Acto` (`id_acto`);

--
-- Indices de la tabla `Lista_Ponentes`
--
ALTER TABLE `Lista_Ponentes`
  ADD PRIMARY KEY (`id_ponente`),
  ADD KEY `FK_Lista_Ponentes_Id_Persona` (`Id_persona`),
  ADD KEY `FK_Lista_Ponentes_Id_Acto` (`Id_acto`);

--
-- Indices de la tabla `Personas`
--
ALTER TABLE `Personas`
  ADD PRIMARY KEY (`Id_persona`);

--
-- Indices de la tabla `Tipos_usuarios`
--
ALTER TABLE `Tipos_usuarios`
  ADD PRIMARY KEY (`Id_tipo_usuario`);

--
-- Indices de la tabla `Tipo_acto`
--
ALTER TABLE `Tipo_acto`
  ADD PRIMARY KEY (`Id_tipo_acto`);

--
-- Indices de la tabla `Usuarios`
--
ALTER TABLE `Usuarios`
  ADD PRIMARY KEY (`Id_usuario`),
  ADD KEY `FK_Usuarios_Id_Persona` (`Id_Persona`),
  ADD KEY `FK_Usuarios_Id_Tipo_Usuarios` (`Id_tipo_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Actos`
--
ALTER TABLE `Actos`
  MODIFY `Id_acto` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `Documentacion`
--
ALTER TABLE `Documentacion`
  MODIFY `Id_presentacion` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `Inscritos`
--
ALTER TABLE `Inscritos`
  MODIFY `Id_inscripcion` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `Lista_Ponentes`
--
ALTER TABLE `Lista_Ponentes`
  MODIFY `id_ponente` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `Personas`
--
ALTER TABLE `Personas`
  MODIFY `Id_persona` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `Tipos_usuarios`
--
ALTER TABLE `Tipos_usuarios`
  MODIFY `Id_tipo_usuario` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `Tipo_acto`
--
ALTER TABLE `Tipo_acto`
  MODIFY `Id_tipo_acto` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `Usuarios`
--
ALTER TABLE `Usuarios`
  MODIFY `Id_usuario` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Actos`
--
ALTER TABLE `Actos`
  ADD CONSTRAINT `FK_Actos_Id_Tipo_Acto` FOREIGN KEY (`Id_tipo_acto`) REFERENCES `Tipo_acto` (`Id_tipo_acto`);

--
-- Filtros para la tabla `Documentacion`
--
ALTER TABLE `Documentacion`
  ADD CONSTRAINT `FK_Documentacion_Id_Acto` FOREIGN KEY (`Id_acto`) REFERENCES `Actos` (`Id_acto`),
  ADD CONSTRAINT `FK_Documentacion_Id_Persona` FOREIGN KEY (`Id_persona`) REFERENCES `Personas` (`Id_persona`);

--
-- Filtros para la tabla `Inscritos`
--
ALTER TABLE `Inscritos`
  ADD CONSTRAINT `FK_Inscritos_Id_Acto` FOREIGN KEY (`id_acto`) REFERENCES `Actos` (`Id_acto`),
  ADD CONSTRAINT `FK_Inscritos_Id_Persona` FOREIGN KEY (`Id_persona`) REFERENCES `Personas` (`Id_persona`);

--
-- Filtros para la tabla `Lista_Ponentes`
--
ALTER TABLE `Lista_Ponentes`
  ADD CONSTRAINT `FK_Lista_Ponentes_Id_Acto` FOREIGN KEY (`Id_acto`) REFERENCES `Actos` (`Id_acto`),
  ADD CONSTRAINT `FK_Lista_Ponentes_Id_Persona` FOREIGN KEY (`Id_persona`) REFERENCES `Personas` (`Id_persona`);

--
-- Filtros para la tabla `Usuarios`
--
ALTER TABLE `Usuarios`
  ADD CONSTRAINT `FK_Usuarios_Id_Persona` FOREIGN KEY (`Id_Persona`) REFERENCES `Personas` (`Id_persona`),
  ADD CONSTRAINT `FK_Usuarios_Id_Tipo_Usuarios` FOREIGN KEY (`Id_tipo_usuario`) REFERENCES `Tipos_usuarios` (`Id_tipo_usuario`);
--
-- Base de datos: `taravel_docker`
--
CREATE DATABASE IF NOT EXISTS `taravel_docker` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `taravel_docker`;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
