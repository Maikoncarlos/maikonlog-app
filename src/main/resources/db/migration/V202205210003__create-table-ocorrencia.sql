CREATE TABLE public.ocorrencia
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    entrega_id bigint NOT NULL,
    descricao character varying(150) NOT NULL,
    data_ocorrencia time without time zone NOT NULL,
    CONSTRAINT ocorrencia_pkey PRIMARY KEY (id),
    CONSTRAINT fk6s5qo326hpov2shx1c5wmnofk FOREIGN KEY (entrega_id)
            REFERENCES public.entrega (id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.ocorrencia
    OWNER to postgres;