create table BTree(
    A integer,
    B integer,
    C integer
);
insert into BTree(A,B,C)
select
    random()*1000::integer
        as A,
    random()*1000::integer
        as B,
    random()*1000::integer
        as C
from generate_series(1,1000) as k(i);
create index btree_a_b_c_index
    on btree (a, b, c);

create index btree_a_b_index
    on btree (a, b);

create index btree_a_c_b_index
    on btree (a, c, b);

create index btree_a_c_index
    on btree (a, c);

create index btree_a_index
    on btree (a);

create index btree_b_a_c_index
    on btree (b, a, c);

create index btree_b_a_index
    on btree (b, a);

create index btree_b_c_a_index
    on btree (b, c, a);

create index btree_b_c_index
    on btree (b, c);

create index btree_b_index
    on btree (b);

create index btree_c_a_b_index
    on btree (c, a, b);

create index btree_c_a_index
    on btree (c, a);

create index btree_c_b_a_index
    on btree (c, b, a);

create index btree_c_b_index
    on btree (c, b);

create index btree_c_index
    on btree (c);