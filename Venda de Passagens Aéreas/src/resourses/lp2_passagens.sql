--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: aviao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE aviao (
    id_aviao integer NOT NULL,
    nome character varying,
    assentos integer
);


ALTER TABLE aviao OWNER TO postgres;

--
-- Name: aviao_id_aviao_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE aviao_id_aviao_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aviao_id_aviao_seq OWNER TO postgres;

--
-- Name: aviao_id_aviao_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE aviao_id_aviao_seq OWNED BY aviao.id_aviao;


--
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE cliente (
    id_cliente integer NOT NULL,
    rg character varying,
    nome character varying,
    telefone character varying
);


ALTER TABLE cliente OWNER TO postgres;

--
-- Name: cliente_id_cliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE cliente_id_cliente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cliente_id_cliente_seq OWNER TO postgres;

--
-- Name: cliente_id_cliente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE cliente_id_cliente_seq OWNED BY cliente.id_cliente;


--
-- Name: venda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE venda (
    id_venda integer NOT NULL,
    id_cliente integer,
    id_voo integer,
    horario timestamp without time zone
);


ALTER TABLE venda OWNER TO postgres;

--
-- Name: venda_id_venda_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE venda_id_venda_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE venda_id_venda_seq OWNER TO postgres;

--
-- Name: venda_id_venda_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE venda_id_venda_seq OWNED BY venda.id_venda;


--
-- Name: voo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE voo (
    id_voo integer NOT NULL,
    origem character varying,
    destino character varying,
    id_aviao integer,
    horario timestamp without time zone,
    lugares integer
);


ALTER TABLE voo OWNER TO postgres;

--
-- Name: voo_id_voo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE voo_id_voo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE voo_id_voo_seq OWNER TO postgres;

--
-- Name: voo_id_voo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE voo_id_voo_seq OWNED BY voo.id_voo;


--
-- Name: id_aviao; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY aviao ALTER COLUMN id_aviao SET DEFAULT nextval('aviao_id_aviao_seq'::regclass);


--
-- Name: id_cliente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cliente ALTER COLUMN id_cliente SET DEFAULT nextval('cliente_id_cliente_seq'::regclass);


--
-- Name: id_venda; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY venda ALTER COLUMN id_venda SET DEFAULT nextval('venda_id_venda_seq'::regclass);


--
-- Name: id_voo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY voo ALTER COLUMN id_voo SET DEFAULT nextval('voo_id_voo_seq'::regclass);


--
-- Data for Name: aviao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY aviao (id_aviao, nome, assentos) FROM stdin;
1	Aviao	200
3	Outro aviao	300
\.


--
-- Name: aviao_id_aviao_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('aviao_id_aviao_seq', 3, true);


--
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cliente (id_cliente, rg, nome, telefone) FROM stdin;
1	1234567890	Cliente	519988547
\.


--
-- Name: cliente_id_cliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cliente_id_cliente_seq', 2, true);


--
-- Data for Name: venda; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY venda (id_venda, id_cliente, id_voo, horario) FROM stdin;
1	1	2	2016-10-19 23:40:33.65
\.


--
-- Name: venda_id_venda_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('venda_id_venda_seq', 1, true);


--
-- Data for Name: voo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY voo (id_voo, origem, destino, id_aviao, horario, lugares) FROM stdin;
1	Brasilia	Porto Alegre	3	2016-10-20 18:00:00	300
2	Porto Alegre	Brasilia	1	2016-10-20 00:00:00	200
\.


--
-- Name: voo_id_voo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('voo_id_voo_seq', 2, true);


--
-- Name: aviaoPkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY aviao
    ADD CONSTRAINT "aviaoPkey" PRIMARY KEY (id_aviao);


--
-- Name: clientePkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT "clientePkey" PRIMARY KEY (id_cliente);


--
-- Name: pKeyVenda; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY venda
    ADD CONSTRAINT "pKeyVenda" PRIMARY KEY (id_venda);


--
-- Name: pKeyVoo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY voo
    ADD CONSTRAINT "pKeyVoo" PRIMARY KEY (id_voo);


--
-- Name: fkeyVendaCliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY venda
    ADD CONSTRAINT "fkeyVendaCliente" FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente);


--
-- Name: fkeyVendaVoo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY venda
    ADD CONSTRAINT "fkeyVendaVoo" FOREIGN KEY (id_voo) REFERENCES voo(id_voo);


--
-- Name: fkeyVooAviao; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY voo
    ADD CONSTRAINT "fkeyVooAviao" FOREIGN KEY (id_aviao) REFERENCES aviao(id_aviao);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

