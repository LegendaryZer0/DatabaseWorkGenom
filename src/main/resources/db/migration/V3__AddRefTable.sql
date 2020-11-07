alter table forview1
	add constraint forview1_forview2_key_fk
		foreign key ("key") references forview2 ("key")
			on update cascade on delete cascade;


alter table forview2
	add constraint forview2_forview3_key_fk
		foreign key ("key") references forview3 ("key")
			on update cascade;


alter table forview1
	add constraint forview1_forview3_key_fk
		foreign key ("key") references forview3 ("key")
			on update cascade;
