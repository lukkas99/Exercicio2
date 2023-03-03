--
-- PostgreSQL database dump
--

-- Dumped from database version 13.6 (Ubuntu 13.6-0ubuntu0.21.10.1)
-- Dumped by pg_dump version 13.6 (Ubuntu 13.6-0ubuntu0.21.10.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: pokemon; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pokemon (
    codigo integer NOT NULL,
    nome text,
    tipo text,
    sexo character(1)
);


ALTER TABLE public.pokemon OWNER TO postgres;

--
-- Name: pokemon pokemon_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pokemon
    ADD CONSTRAINT pokemon_pkey PRIMARY KEY (codigo);


--
-- PostgreSQL database dump complete
--
INSERT INTO pokemon (codigo, nome, tipo, sexo) VALUES (1, 'bulbasaur', 'grass', 'M');
INSERT INTO pokemon (codigo, nome, tipo, sexo) VALUES (2, 'ivysaur', 'grass', 'F');
INSERT INTO pokemon (codigo, nome, tipo, sexo) VALUES (3, 'venusaur', 'grass', 'F');
INSERT INTO pokemon (codigo, nome, tipo, sexo) VALUES (4, 'charmander', 'fire', 'F');
INSERT INTO pokemon (codigo, nome, tipo, sexo) VALUES (6, 'charmeleon', 'fire', 'F');
INSERT INTO pokemon (codigo, nome, tipo, sexo) VALUES (5, 'charizard', 'fire', 'F');
INSERT INTO pokemon (codigo, nome, tipo, sexo) VALUES (7, 'squirtle', 'water', 'F');
INSERT INTO pokemon (codigo, nome, tipo, sexo) VALUES (8, 'wartortle', 'water', 'M');
INSERT INTO pokemon (codigo, nome, tipo, sexo) VALUES (9, 'blastoise', 'water', 'M');
INSERT INTO pokemon (codigo, nome, tipo, sexo) VALUES (10, 'mew', 'paulo', 'M');
