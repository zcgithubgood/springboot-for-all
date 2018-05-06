-- ----------------------------
-- ----------------------------
-- Table structure for e_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."e_user";
CREATE TABLE "public"."e_user" (
  "id" varchar(32) COLLATE "default" NOT NULL,
  "user_name" varchar(100) COLLATE "default",
  "passwd" varchar(100) COLLATE "default",
  "email" varchar(100) COLLATE "default",
  "full_name" varchar(100) COLLATE "default",
  "mobile_phone" varchar(16) COLLATE "default",
  "phone" varchar(16) COLLATE "default",
  "status" varchar(16) COLLATE "default",
  "status_time" timestamp(6),
  "create_user" varchar(32) COLLATE "default",
  "create_time" timestamp(6),
  "update_user" varchar(32) COLLATE "default",
  "update_time" timestamp(6),
  "search_word" varchar(500) COLLATE "default",
  "is_deleted" int4,
  "description" text COLLATE "default"
)
WITH (OIDS=FALSE)
;