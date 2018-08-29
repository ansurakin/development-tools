CREATE TABLE project (
  "id" int8 PRIMARY KEY,
  "name" varchar(255),
  "description" varchar(255),
  "order_number" int4 DEFAULT 100,
  "is_clone" bool DEFAULT true,
  "is_build" bool DEFAULT true,
  "build_branch" varchar(255),
  "is_install" bool DEFAULT false,
  "is_runable" bool DEFAULT false,
  "is_init_script" bool DEFAULT false
)
;

