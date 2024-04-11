DROP SCHEMA IF EXISTS `mydata`;

CREATE SCHEMA `mydata`;

use `mydata`;

SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE user_account(
 `id` INT NOT NULL AUTO_INCREMENT,
 `user_name` varchar(128) DEFAULT NULL,
 `email` varchar(45) DEFAULT NULL,
 `phonenumber` varchar(20) DEFAULT NULL,
 `password` varchar(10) DEFAULT NULL,
 `is_banned` bool,
 `setting_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SETTING_idx` (`setting_id`),
  CONSTRAINT `FK_SETTING` FOREIGN KEY (`setting_id`) 
  REFERENCES `setting` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE setting(
 `id` INT NOT NULL AUTO_INCREMENT,
 `update_account` varchar(128) DEFAULT NULL,
 `update_chat` varchar(128) DEFAULT NULL,
 `phone_number` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE role(
 `id` INT NOT NULL AUTO_INCREMENT,
 `role_name` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE user_has_role(
 `id` INT NOT NULL AUTO_INCREMENT,
 `role_id`INT NOT NULL ,
 `user_id`INT NOT NULL ,
 `role_start_time` datetime,
 `role_end_time` datetime, 
  PRIMARY KEY (`id`),
  KEY `FK_ACCOUNT_idx` (`user_id`),
  CONSTRAINT `FK_ACCOUNT` FOREIGN KEY (`user_id`) 
  REFERENCES `user_account` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_ROLE_idx` (`role_id`),
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) 
  REFERENCES `role` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE chat(
 `id` INT NOT NULL AUTO_INCREMENT,
 `from_user_id` INT NOT NULL,
 `to_user_id` INT NOT NULL,
 `content` varchar(2048) DEFAULT NULL,
 `sent_datetime` timestamp,
  PRIMARY KEY (`id`),
  KEY `FK_USER_ACCOUNT_idx` (`from_user_id`),
  CONSTRAINT `FK_USER_ACCOUNT` FOREIGN KEY (`from_user_id`) 
  REFERENCES `user_account` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE salesperson(
 `id` INT NOT NULL AUTO_INCREMENT,
 `name` varchar(128) DEFAULT NULL,
 `num_of_followers` int DEFAULT NULL,
 `user_has_role_id` INT NOT NULL ,
  PRIMARY KEY (`id`),
  KEY `FK_HAS_ROLE_idx` (`user_has_role_id`),
  CONSTRAINT `FK_HAS_ROLE` FOREIGN KEY (`user_has_role_id`) 
  REFERENCES `uer_has_role` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE customer(
 `id` INT NOT NULL AUTO_INCREMENT,
 `cus_name` varchar(128) DEFAULT NULL,
 `num_of_followers`int DEFAULT NULL,
 `role_id` INT NOT NULL ,
  PRIMARY KEY (`id`),
  KEY `FK_USER_HAS_ROLE_idx` (`role_id`),
  CONSTRAINT `FK_USER_HAS_ROLE` FOREIGN KEY (`role_id`) 
  REFERENCES `uer_has_role` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE cus_rank(
 `id` INT NOT NULL,
 `rank_name` varchar(20) NOT NULL,
 `cus_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CUSTOMs_idx` (`cus_id`),
  CONSTRAINT `FK_CUSTOMs` FOREIGN KEY (`cus_id`) 
  REFERENCES `customer` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE address_cus(
 `address_id` INT NOT NULL,
 `cus_id` INT NOT NULL,
  PRIMARY KEY (`address_id`,`cus_id`),
  KEY `FK_ADDRESS_idx` (`address_id`),
  CONSTRAINT `FK_ADDRESS` FOREIGN KEY (`address_id`) 
  REFERENCES `address` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_CUSTOM_idx` (`cus_id`),
  CONSTRAINT `FK_CUSTOMER` FOREIGN KEY (`cus_id`) 
  REFERENCES `customer` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE rating(
 `id` INT NOT NULL AUTO_INCREMENT,
 `cus_id` INT NOT NULL,
 `product_id` INT NOT NULL,
 `product_stars` INT DEFAULT NULL,
 `review_line` varchar(1000) NOT NULL,
 `delivery_stars` INT DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CUSTOM_idx` (`cus_id`),
  CONSTRAINT `FK_CUSTOM` FOREIGN KEY (`cus_id`) 
  REFERENCES `customer` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_PRODUCT_idx` (`product_id`),
  CONSTRAINT `FK_PRODUCT` FOREIGN KEY (`product_id`) 
  REFERENCES `product` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE product_list(
 `id` INT NOT NULL AUTO_INCREMENT,
 `product_id` INT NOT NULL,
 `salesperson_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SALES_PERSON_idx` (`salesperson_id`),
  CONSTRAINT `FK_SALES_PERSON` FOREIGN KEY (`salesperson_id`) 
  REFERENCES `salesperson` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_PRODUCTS_idx` (`product_id`),
  CONSTRAINT `FK_PRODUCTS` FOREIGN KEY (`product_id`) 
  REFERENCES `product` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE product(
 `id` INT NOT NULL AUTO_INCREMENT,
 `product_name` varchar(128) NOT NULL,
 `description` varchar(128) DEFAULT NULL,
 `current_price` INT NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE category(
 `id` INT NOT NULL AUTO_INCREMENT,
 `category_name` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE category_product(
 `category_id` INT NOT NULL ,
 `product_id` INT NOT NULL ,
  PRIMARY KEY (`category_id`,`product_id`),
  KEY `FK_PRODUCT2_idx` (`product_id`),
  CONSTRAINT `FK_PRODUCT2` FOREIGN KEY (`product_id`) 
  REFERENCES `product` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
   KEY `FK_CATEGORY_idx` (`category_id`),
  CONSTRAINT `FK_CATEGORY` FOREIGN KEY (`category_id`) 
  REFERENCES `category` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE sub_category(
 `id` INT NOT NULL AUTO_INCREMENT,
 `color` varchar(20) NOT NULL,
 `size` varchar(10) NOT NULL,
 `quanity` INT NOT NULL,
 `product_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_PRODUCT1_idx` (`product_id`),
  CONSTRAINT `FK_PRODUCT1` FOREIGN KEY (`product_id`) 
  REFERENCES `product` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE order_status(
 `id` INT NOT NULL AUTO_INCREMENT,
 `status_name` varchar(128) NOT NULL,
 `rating_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_RATING_idx` (`rating_id`),
  CONSTRAINT `FK_RATING` FOREIGN KEY (`rating_id`) 
  REFERENCES `rating` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE address(
 `id` INT NOT NULL AUTO_INCREMENT,
 `street_name` varchar(128) NOT NULL,
 `country_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_COUNTRY_idx` (`country_id`),
  CONSTRAINT `FK_COUNTRY` FOREIGN KEY (`country_id`) 
  REFERENCES `country` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE address_sales(
 `address_id` INT NOT NULL ,
 `salesperson_id` INT NOT NULL, 
  PRIMARY KEY (`address_id`, `salesperson_id` ),
  KEY `FK_ADDRESS1_idx` (`address_id`),
  CONSTRAINT `FK_ADDRESS1` FOREIGN KEY (`address_id`) 
  REFERENCES `address` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_SALESPERSON1_idx` (`salesperson_id`),
  CONSTRAINT `FK_SALESPERSON1` FOREIGN KEY (`salesperson_id`) 
  REFERENCES `salesperson` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE country(
 `id` INT NOT NULL AUTO_INCREMENT,
 `country_name` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE city(
 `id` INT NOT NULL AUTO_INCREMENT,
 `city_name` varchar(128) NOT NULL,
 `country_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_COUNTRY1_idx` (`country_id`),
  CONSTRAINT `FK_COUNTRY1` FOREIGN KEY (`country_id`) 
  REFERENCES `country` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE district(
 `id` INT NOT NULL AUTO_INCREMENT,
 `district_name` varchar(128) NOT NULL,
 `city_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CITY_idx` (`city_id`),
  CONSTRAINT `FK_CITY` FOREIGN KEY (`city_id`) 
  REFERENCES `country` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE orders(
 `id` INT NOT NULL AUTO_INCREMENT ,
 `sold_quantity` INT NOT NULL, 
 `total_price` INT NOT NULL,
 `product_id` INT NOT NULL,
 `delivery_id` INT NOT NULL,
 `salesperson_id` INT NOT NULL,
 `cus_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CUSTOM1_idx` (`cus_id`),
  CONSTRAINT `FK_CUSTOM1` FOREIGN KEY (`cus_id`) 
  REFERENCES `customer` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_SALESPERSON2_idx` (`salesperson_id`),
  CONSTRAINT `FK_SALESPERSON2` FOREIGN KEY (`salesperson_id`) 
  REFERENCES `salesperson` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_PRODUCT3_idx` (`product_id`),
  CONSTRAINT `FK_PRODUCT3` FOREIGN KEY (`product_id`) 
  REFERENCES `product` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_DELIVERY_idx` (`delivery_id`),
  CONSTRAINT `FK_DELIVERY` FOREIGN KEY (`delivery_id`) 
  REFERENCES `delivery_driver` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE delivery_driver(
 `id` INT NOT NULL AUTO_INCREMENT,
 `name` varchar(128) NOT NULL,
 `phone_number` varchar(20) NOT NULL,
 `state` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE payment(
 `id` INT NOT NULL AUTO_INCREMENT,
 `name` varchar(128) NOT NULL,
 `payment_method` varchar(128) NOT NULL,
 `payyment_date` datetime,
 `amout` double not null,
 `cus_id` INT NOT NULL,
 `order_id` INT NOT NULL,
  PRIMARY KEY (`id`),
   KEY `FK_CUSTOM2_idx` (`cus_id`),
  CONSTRAINT `FK_CUSTOM2` FOREIGN KEY (`cus_id`) 
  REFERENCES `customer` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_ORDERS_idx` (`order_id`),
  CONSTRAINT `FK_ORDERS` FOREIGN KEY (`order_id`) 
  REFERENCES `orders` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE voucher(
 `id` INT NOT NULL AUTO_INCREMENT,
 `live_id` INT NOT NULL,
 `video_id` INT NOT NULL,
 `product_id` INT NOT NULL,
 `percent_discount` INT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_PRODUCT5_idx` (`product_id`),
  CONSTRAINT `FK_PRODUCT5` FOREIGN KEY (`product_id`) 
  REFERENCES `product` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_LIVE_idx` (`live_id`),
  CONSTRAINT `FK_LIVE` FOREIGN KEY (`live_id`) 
  REFERENCES `live` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_VIDEO_idx` (`video_id`),
  CONSTRAINT `FK_VIDEO` FOREIGN KEY (`video_id`) 
  REFERENCES `video` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE live(
 `id` INT NOT NULL AUTO_INCREMENT,
 `salesperson_id` INT NOT NULL,
 `content` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SALESPERSON3_idx` (`salesperson_id`),
  CONSTRAINT `FK_SALESPERSON3` FOREIGN KEY (`salesperson_id`) 
  REFERENCES `salesperson` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE video(
 `id` INT NOT NULL AUTO_INCREMENT,
 `user_id` INT NOT NULL,
 `description` varchar(128) NOT NULL,
 `comment` varchar(128) NOT NULL,
 `link_product` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_USER_idx` (`user_id`),
  CONSTRAINT `FK_USER` FOREIGN KEY (`user_id`) 
  REFERENCES `user_account` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE shopping_basket(
 `id` INT NOT NULL AUTO_INCREMENT,
 `product_id` INT NOT NULL,
 `cus_id` INT NOT NULL,
 `quantity` INT NOT NULL,
 `state` varchar(128) NOT NULL,
   PRIMARY KEY (`id`),
   KEY `FK_CUSTOM3_idx` (`cus_id`),
  CONSTRAINT `FK_CUSTOM3` FOREIGN KEY (`cus_id`) 
  REFERENCES `customer` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE warehouse(
 `id` INT NOT NULL auto_increment,
 `delivery_id` INT NOT NULL,
`warehouse_address` varchar(128) not null,
   PRIMARY KEY (`id`),
   KEY `FK_DELIVERY1_idx` (`delivery_id`),
  CONSTRAINT `FK_DELIVERY1` FOREIGN KEY (`delivery_id`) 
  REFERENCES `delivery` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE order_status_orders(
 `orders_id` INT NOT NULL ,
 `order_status_id` INT NOT NULL, 
  PRIMARY KEY ( `orders_id` , `order_status_id`),
  KEY `FK_ORDER_STATUS_idx` ( `order_status_id`),
  CONSTRAINT `FK_ORDER_STATUS` FOREIGN KEY ( `order_status_id`) 
  REFERENCES `order_status` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_ORDERS1_idx` (`orders_id`),
  CONSTRAINT `FK_ORDERS1` FOREIGN KEY (`orders_id`) 
  REFERENCES `orders` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE orders_product(
 `orders_id` INT NOT NULL ,
 `product_id` INT NOT NULL, 
  PRIMARY KEY ( `orders_id` , `product_id`),
  KEY `FK_PRODUCT6_idx` (`product_id`),
  CONSTRAINT `FK_PRODUCT6` FOREIGN KEY (`product_id`) 
  REFERENCES `product` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_ORDERS2_idx` (`orders_id`),
  CONSTRAINT `FK_ORDERS2` FOREIGN KEY (`orders_id`) 
  REFERENCES `orders` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE live_voucher(
 `live_id` INT NOT NULL ,
 `voucher_id` INT NOT NULL, 
  PRIMARY KEY ( `live_id` , `voucher_id`),
  KEY `FK_LIVE1_idx` (`live_id`),
  CONSTRAINT `FK_LIVE1` FOREIGN KEY (`live_id`) 
  REFERENCES `live` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_VOUCHER1_idx` (`voucher_id`),
  CONSTRAINT `FK_VOUCHER1` FOREIGN KEY (`voucher_id`) 
  REFERENCES `voucher` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE video_voucher(
 `video_id` INT NOT NULL ,
 `voucher_id` INT NOT NULL, 
  PRIMARY KEY ( `video_id` , `voucher_id`),
  KEY `FK_VIDEO1_idx` (`video_id`,`voucher_id`),
  CONSTRAINT `FK_VIDEO1` FOREIGN KEY (`video_id`) 
  REFERENCES `video` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_VOUCHER2_idx` (`voucher_id`),
  CONSTRAINT `FK_VOUCHER2` FOREIGN KEY (`voucher_id`) 
  REFERENCES `voucher` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=latin1;