BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Vjezbe" (
	"Naziv_Vjezbe"	TEXT,
	FOREIGN KEY("Naziv_Vjezbe") REFERENCES "Dio_tijela"("NazivTijela")
);
CREATE TABLE IF NOT EXISTS "Dio_tijela" (
	"NazivTijela"	TEXT,
	PRIMARY KEY("NazivTijela")
);
INSERT INTO "Dio_tijela" VALUES ('Stomak');
INSERT INTO "Dio_tijela" VALUES ('Ledja');
INSERT INTO "Dio_tijela" VALUES ('Prsa');
INSERT INTO "Dio_tijela" VALUES ('Noge');
INSERT INTO "Dio_tijela" VALUES ('Ruke');
COMMIT;
