DROP SCHEMA IF EXISTS azspace cascade;

create schema azspace;

CREATE SEQUENCE azspace.statsequence     INCREMENT 1    START 1 ;
CREATE SEQUENCE azspace.rolesequence   INCREMENT 1    START 1 ;
CREATE SEQUENCE azspace.suserroleseq    INCREMENT 1    START 1 ;
CREATE SEQUENCE azspace.usersequence   INCREMENT 1    START 1 ;


CREATE TABLE azspace.suser
(
    userid integer NOT NULL DEFAULT nextval('azspace.usersequence'::regclass),
    firstname character varying(100) COLLATE pg_catalog."default",
    lastname character varying(100) COLLATE pg_catalog."default",
    email character varying(100) COLLATE pg_catalog."default",
    password character varying(150) COLLATE pg_catalog."default",
    enabled boolean,
    CONSTRAINT user_pkey PRIMARY KEY (userid)
);



CREATE TABLE azspace.srole
(
    roleid integer NOT NULL DEFAULT nextval('azspace.rolesequence'::regclass),
    name character varying(100) ,
    CONSTRAINT role_pkey PRIMARY KEY (roleid)
);




CREATE TABLE azspace.suserrole
(
    sid integer NOT NULL DEFAULT nextval('azspace.suserroleseq'::regclass),
    userid integer NOT NULL,
    roleid integer NOT NULL,
    CONSTRAINT suserrole_pkey PRIMARY KEY (sid),
    CONSTRAINT suserrole_roleid_fkey FOREIGN KEY (roleid)
        REFERENCES azspace.srole (roleid) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID,
    CONSTRAINT suserrole_userid_fkey FOREIGN KEY (userid)
        REFERENCES azspace.suser (userid) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
);





CREATE TABLE azspace.azstatus
(
    statusid integer NOT NULL DEFAULT nextval('azspace.statsequence'::regclass),
    userid integer NOT NULL,
    filename character varying(500) ,
    processed boolean,
    mailsend boolean,
    satname character varying(500) ,
    azconfig character varying(500) ,
    processdate timestamp without time zone DEFAULT now(),
    updatedate timestamp without time zone,
    azdescription character varying(500) ,
    CONSTRAINT azstatus_pkey PRIMARY KEY (statusid)
);




INSERT INTO azspace.srole(  name) VALUES ( 'ROLE_ADMIN');
INSERT INTO azspace.srole(  name) VALUES ( 'ROLE_USER');

INSERT INTO azspace.suser(	 firstname, lastname, email, password, enabled) 	VALUES ( 'admin', 'turksat', 'admin@turksat.com.tr', '$2a$12$GZ6Hmp2z7erKUHbgr3fUh.5Urv5lL6yDsZUJMabTk4qdmG92wcRNa', true);
INSERT INTO azspace.suserrole( userid, roleid)	VALUES ( 1, 1);


