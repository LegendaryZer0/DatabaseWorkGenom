create table forView1(
  key bigint unique,
  value varchar

);
insert into forView1(key,value)
select i as id,
       random()::varchar
         as name
from generate_series(1,50) as k(i);

create table forView2(
                         key bigint unique,
                         value varchar

);
insert into forView2(key,value)
select i as id,
       random()::varchar
         as name
from generate_series(1,50) as k(i);

create table forView3(
                         key bigint unique,
                         value varchar

);
insert into forView3(key,value)
select i as id,
       random()::varchar
         as name
from generate_series(1,50) as k(i);
