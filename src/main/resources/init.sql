CREATE TABLE `RssIData` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `IndexId`  int(10) not null,
  `RssI` int(10) NOT NULL,
  `SSID` varchar(20) COLLATE utf8_persian_ci NOT NULL,
  `Positions` int(10) NOT NULL,
  `MacAddress` varchar(20) COLLATE utf8_persian_ci NOT NULL,
  `DateTime` timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;


CREATE TABLE `PositioningData` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Positions` int(11) NOT NULL,
  `IndexId` int(10) NOT NULL,
  `DateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `AccelerationX` double NOT NULL,
  `AccelerationY` double NOT NULL,
  `AccelerationZ` double NOT NULL,
  `GyroscopeX` double NOT NULL,
  `GyroscopeY` double NOT NULL,
  `GyroscopeZ` double NOT NULL,
  `MagneticX` double NOT NULL,
  `MagneticY` double NOT NULL,
  `MagneticZ` double NOT NULL,
  `OrientationX` double NOT NULL,
  `OrientationY` double NOT NULL,
  `OrientationZ` double NOT NULL,
  `CampassX` double NOT NULL,
  `CampassY` double NOT NULL,
  `CampassZ` double NOT NULL,
  `Presure` double NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=110952 DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

alter table PositioningData add IndexId int(10) not null;

alter table RssIData add IndexId int(10) not null;



CREATE TABLE `DataCollectRecord` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `IndexId`  int(10) NOT NULL,
  `Positions` int(10) NOT NULL,
  `MobilePhone` varchar(50) COLLATE utf8_persian_ci NOT NULL,
  `DataSizes` int(10) NOT NULL,
  `DateTime` timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;