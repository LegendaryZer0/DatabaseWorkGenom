create table simpleclent (
 id  bigint PRIMARY KEY ,
 name varchar
);

insert into simpleclent (id,name)
select i as id,
       random()::varchar
         as name
from generate_series(1,10000) as k(i);

create table techInfoSimpleClient (
        par_id  bigint references simpleclent(id),
        trust_coif float8
);

insert into techInfoSimpleClient (par_id,trust_coif)
select i as par_id,
       random()::float8
         as trust_coif
from generate_series(1,10000) as k(i);
