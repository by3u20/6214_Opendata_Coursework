/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/5/8 16:51:22                            */
/*==============================================================*/


drop table if exists travel_city;

/*==============================================================*/
/* Table: travel_city                                           */
/*==============================================================*/
create table travel_city
(
   city_id               int not null auto_increment,
   city_name             varchar(100),
   covidgovltlacity_name varchar(100),
   weather_city_name     varchar(100),
   gdp_nameps  varchar(100),
   gdp_city_name  varchar(100),
   gdp2018  varchar(100),
   holiday_visit         int,
   travel_visit          int,
   total_visit           int,
   visits_in10kround     double,
   visit_score_by_rank     double,
   visit_score           double,
   university_name       varchar(100),
   university_score      double,
   gdp20181  double,
   Shopping_Score double,
   primary key (city_id)
);

alter table travel_city comment '旅游城市表';

