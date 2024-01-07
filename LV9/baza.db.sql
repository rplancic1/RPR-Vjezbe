BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "grad" (
	"id"	INTEGER,
	"naziv"	TEXT,
	"broj_stanovnika"	INTEGER,
	"drzava"	INTEGER,
	FOREIGN KEY("drzava") REFERENCES "drzava"("id"),
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "drzava" (
	"id"	INTEGER,
	"naziv"	TEXT,
	"glavni_grad"	INTEGER,
	FOREIGN KEY("glavni_grad") REFERENCES "grad"("id"),
	PRIMARY KEY("id")
);
INSERT INTO "grad" VALUES (1,'London',8982000,1);
INSERT INTO "grad" VALUES (2,'Oslo',634293,2);
INSERT INTO "drzava" VALUES (1,'Velika Britanija',1);
INSERT INTO "drzava" VALUES (2,'Norveska',2);
COMMIT;