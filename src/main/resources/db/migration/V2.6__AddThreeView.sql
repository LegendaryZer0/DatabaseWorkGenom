create view  view1 as select * from forview1;
create view  view2 as select * from forview2;
create view  view3 as (select forview3.value as v3,forview3.key as k3,f.key as k1,f.value as v1 from forview3 inner join forview1 f on forview3.key = f.key);