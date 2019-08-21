create database quanlytrasua;
use quanlytrasua;

CREATE TABLE `invoice` (
  `IniD` int(11) Primary Key auto_increment,
  `Note` varchar(255) COLLATE utf8mb4_unicode_ci,
  `Date` datetime DEFAULT CURRENT_TIMESTAMP,
  `TotalPrice` int(11)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `product` (
  `PiD` int(11) Primary Key auto_increment,
  `Pname` varchar(255) COLLATE utf8mb4_unicode_ci,
  `Quantity` int(11),
  `Price` int(11)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `customer` (
  `CiD` int(11) primary key auto_increment,
  `Cname` varchar(255) COLLATE utf8mb4_unicode_ci,
  `Note` varchar(255) COLLATE utf8mb4_unicode_ci,
  `Address` varchar(255) COLLATE utf8mb4_unicode_ci,
  `Tel` int(11)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `employee` (
  `EiD` int(11) primary key auto_increment,
  `Ename` varchar(255) COLLATE utf8mb4_unicode_ci,
  `Sex` varchar(10) COLLATE utf8mb4_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `bill` (
  `BiD` int(11) Primary key auto_increment,
  `IniD` int(11),
  `CiD` int(11),
  `PiD` int(11),
  `EiD` int(11),
  `Pname` varchar(255) COLLATE utf8mb4_unicode_ci NULL,
  `Quantity` int(11) DEFAULT NULL,
  `Note` varchar(255) COLLATE utf8mb4_unicode_ci,
  `Date` datetime DEFAULT CURRENT_TIMESTAMP,
  `Price` int(11),
  foreign key bill(IniD) references invoice(IniD) on delete cascade on update cascade,
  foreign key customer(CiD) references customer(CiD) on delete cascade on update cascade,
  foreign key product(PiD) references product(PiD) on delete cascade on update cascade,
  foreign key employee(EiD) references employee(EiD) on delete cascade on update cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


insert into product(`Pname`,`Price`)
values
('Tra Sua Socola - M',15000),
('Tra Sua Socola - L',20000),
('Tra Sua Dau - M',15000),
('Tra Sua Dau - L',20000),
('Tra Sua Bac Ha - M',15000),
('Tra Sua Bac Ha - L',20000);

insert into employee(`Ename`,`Sex`)
values
('Le Viet Dung','Male'),
('Pham Ngoc Chien','Male'),
('Ngo Duc Anh','Male');
