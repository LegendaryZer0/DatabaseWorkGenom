insert into benchsimpletable(id,name)
select i as id,
       random()::varchar
as name
from generate_series(1,50000000) as k(i);