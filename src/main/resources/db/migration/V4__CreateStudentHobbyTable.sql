create table student(
    id bigint GENERATED ALWAYS AS IDENTITY primary key ,
    name varchar,
    surname varchar,
    last_name varchar
    );

insert into student(name,surname,last_name)
select
    random()::varchar
        as name,
    random()::varchar
        as surname,
    random()::varchar
        as last_name
from generate_series(1,1000) as k(i);

create table hobby(
    name varchar,
    student_id bigint references  student(id)

);
insert into hobby(name,student_id)
select
    (ARRAY['hokkey','football','chess','carts','job','basketball','fighting','swimming','proggramming','gaming']) [round(random()*10+1)]
        as name,
    floor(random()*1000+1)::bigint
        as student_id

from generate_series(1,10000) as k(i);