/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     31/05/2011 22:16:34                          */
/*==============================================================*/


drop index INDEX_ACESSO;

drop table ACESSO;

drop index INDEX_AUDITORIA;

drop table AUDITORIA;

drop index INDEX_CAR_ID;

drop table CARGO;

drop index INDEX_CIDADE;

drop table CIDADE;

drop index INDEX_CLIENTE;

drop table CLIENTE;

drop index INDEX_CONTA;

drop table CONTA;

drop index INDEX_DEPARTAMENTO;

drop table DEPARTAMENTO;

drop index INDEX_EMAIL;

drop table EMAIL;

drop index INDEX_EMAILCLIENTE;

drop table EMAILCLIENTE;

drop index INDEX_EMAILFORNECEDOR;

drop table EMAILFORNECEDOR;

drop index INDEX_EMAILFUNCIONARIO;

drop table EMAILFUNCIONARIO;

drop index INDEX_EMPRESA;

drop table EMPRESA;

drop index INDEX_ENDERECO2;

drop index INDEX_ENDERECO;

drop table ENDERECO;

drop index INDEX_ENDERCLIENTE;

drop table ENDERECOCLIENTE;

drop index INDEX_ENDEMP_ID;

drop table ENDERECOEMPRESA;

drop index INDEX_FIL_ID;

drop table ENDERECOFILIAL;

drop index INDEX_ENDERFORNEC;

drop table ENDERECOFORNECEDOR;

drop index INDEX_ENDERFUNCIONARIO;

drop table ENDERECOFUNCIONARIO;

drop index INDEX_ERROSISTEMA;

drop table ERROSISTEMA;

drop index INDEX_FILIAL2;

drop index INDEX_FILIAL;

drop table FILIAL;

drop index INDEX_FORNECEDOR2;

drop index INDEX_FORNECEDOR;

drop table FORNECEDOR;

drop index INDEX_FUNCIONARIO2;

drop index INDEX_FUNCIONARIO;

drop table FUNCIONARIO;

drop index INDEX_LOG;

drop table LOG;

drop index INDEX_MENU;

drop table MENU;

drop index INDEX_PARAM_ID;

drop table PARAMETRO;

drop index INDEX_TELEFONE;

drop table TELEFONE;

drop index INDEX_TELELEFCLIENTE;

drop table TELEFONECLIENTE;

drop index INDEX_TELEFFORNECED;

drop table TELEFONEFORNECEDOR;

drop index INDEX_TELEFFUNCIONARIO;

drop table TELEFONEFUNCIONARIO;

drop index INDEX_UF2;

drop index INDEX_UF;

drop table UF;

drop index INDEX_USR2;

drop index INDEX_USR;

drop table USUARIO;

/*==============================================================*/
/* Table: ACESSO                                                */
/*==============================================================*/
create table ACESSO (
   ACESS_ID             SERIAL               not null,
   ACESS_USR_ID         INT4                 null,
   ACESS_MENU_ID        INT4                 not null,
   ACESS_INC            BOOL                 not null,
   ACESS_ALT            BOOL                 not null,
   ACESS_EXC            BOOL                 not null,
   ACESS_PESQ           BOOL                 not null,
   constraint PK_ACESSO primary key (ACESS_ID)
);

comment on table ACESSO is
'tabela de permissao de acessos aos menus do sistema';

/*==============================================================*/
/* Index: INDEX_ACESSO                                          */
/*==============================================================*/
create  index INDEX_ACESSO on ACESSO (
ACESS_ID,
ACESS_USR_ID,
ACESS_MENU_ID
);

/*==============================================================*/
/* Table: AUDITORIA                                             */
/*==============================================================*/
create table AUDITORIA (
   AUD_ID               SERIAL               not null,
   AUD_USR_ID           INT4                 null,
   AUD_DATA             DATE                 not null,
   AUD_HORA             TIME                 not null,
   AUD_ACAO             VARCHAR(25)          not null,
   AUD_TABELA           VARCHAR(32)          not null,
   AUD_DESCRICAO        VARCHAR(256)         null,
   constraint PK_AUDITORIA primary key (AUD_ID)
);

comment on table AUDITORIA is
'tabela de logs e alteraçoes no sistema';

/*==============================================================*/
/* Index: INDEX_AUDITORIA                                       */
/*==============================================================*/
create  index INDEX_AUDITORIA on AUDITORIA (
AUD_ID,
AUD_DATA
);

/*==============================================================*/
/* Table: CARGO                                                 */
/*==============================================================*/
create table CARGO (
   CAR_ID               SERIAL               not null,
   CAR_DESCRICAO        VARCHAR(100)         not null,
   CAR_STS              BOOL                 not null,
   constraint PK_CARGO primary key (CAR_ID)
);

/*==============================================================*/
/* Index: INDEX_CAR_ID                                          */
/*==============================================================*/
create  index INDEX_CAR_ID on CARGO (
CAR_ID,
CAR_DESCRICAO
);

/*==============================================================*/
/* Table: CIDADE                                                */
/*==============================================================*/
create table CIDADE (
   CID_ID               SERIAL               not null,
   CID_UF_ID            INT4                 null,
   CID_NOME             VARCHAR(256)         not null,
   CID_STS              BOOL                 not null,
   constraint PK_CIDADE primary key (CID_ID)
);

comment on table CIDADE is
'TABELA ESPECIALIZADA DE CIDADES';

/*==============================================================*/
/* Index: INDEX_CIDADE                                          */
/*==============================================================*/
create  index INDEX_CIDADE on CIDADE (
CID_ID,
CID_UF_ID
);

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE (
   CLI_ID               SERIAL               not null,
   CLI_FIL_ID           INT4                 null,
   CLI_NOME             varchar(256)         not null,
   CLI_DATACADASTRO     DATE                 null,
   CLI_DATANASCIMENTO   DATE                 null,
   CLI_CNPJCPF          VARCHAR(32)          not null,
   CLI_RG               VARCHAR(20)          not null,
   CLI_STS              BOOL                 not null,
   CLI_TIPO             CHAR(2)              not null,
   constraint PK_CLIENTE primary key (CLI_ID)
);

/*==============================================================*/
/* Index: INDEX_CLIENTE                                         */
/*==============================================================*/
create  index INDEX_CLIENTE on CLIENTE (
CLI_ID,
CLI_FIL_ID,
CLI_NOME
);

/*==============================================================*/
/* Table: CONTA                                                 */
/*==============================================================*/
create table CONTA (
   CON_ID               SERIAL               not null,
   CON_FIL_ID           INT4                 null,
   CON_VALORCONTA       NUMERIC(10,2)        not null,
   CON_VALORPAGTO       NUMERIC(10,2)        null,
   CON_DATAEMISSAO      DATE                 not null,
   CON_DATAPAGTO        DATE                 null,
   CON_TIPO             CHAR(2)              not null,
   constraint PK_CONTA primary key (CON_ID)
);

/*==============================================================*/
/* Index: INDEX_CONTA                                           */
/*==============================================================*/
create  index INDEX_CONTA on CONTA (
CON_ID,
CON_FIL_ID,
CON_DATAEMISSAO
);

/*==============================================================*/
/* Table: DEPARTAMENTO                                          */
/*==============================================================*/
create table DEPARTAMENTO (
   DEP_ID               SERIAL               not null,
   DEP_FIL_ID           INT4                 null,
   DEP_NOME             VARCHAR(256)         not null,
   DEP_STS              BOOL                 not null,
   constraint PK_DEPARTAMENTO primary key (DEP_ID)
);

/*==============================================================*/
/* Index: INDEX_DEPARTAMENTO                                    */
/*==============================================================*/
create  index INDEX_DEPARTAMENTO on DEPARTAMENTO (
DEP_ID,
DEP_FIL_ID,
DEP_NOME
);

/*==============================================================*/
/* Table: EMAIL                                                 */
/*==============================================================*/
create table EMAIL (
   EMAIL_ID             SERIAL               not null,
   EMAIL_DESCRICAO      VARCHAR(128)         not null,
   EMAIL_TIPO           CHAR(2)              not null,
   EMAIL_STS            BOOL                 not null,
   constraint PK_EMAIL primary key (EMAIL_ID)
);

comment on table EMAIL is
'TABELA ESPECIALIZADA DE EMAILS';

/*==============================================================*/
/* Index: INDEX_EMAIL                                           */
/*==============================================================*/
create  index INDEX_EMAIL on EMAIL (
EMAIL_ID,
EMAIL_DESCRICAO
);

/*==============================================================*/
/* Table: EMAILCLIENTE                                          */
/*==============================================================*/
create table EMAILCLIENTE (
   EMAILCLI_CLI_ID      INT4                 not null,
   EMAILCLI_EMAIL_ID    INT4                 not null,
   constraint PK_EMAILCLIENTE primary key (EMAILCLI_CLI_ID, EMAILCLI_EMAIL_ID)
);

/*==============================================================*/
/* Index: INDEX_EMAILCLIENTE                                    */
/*==============================================================*/
create  index INDEX_EMAILCLIENTE on EMAILCLIENTE (
EMAILCLI_CLI_ID,
EMAILCLI_EMAIL_ID
);

/*==============================================================*/
/* Table: EMAILFORNECEDOR                                       */
/*==============================================================*/
create table EMAILFORNECEDOR (
   EMAILFOR_FOR_ID      INT4                 not null,
   EMAILFOR_EMAIL_ID    INT4                 not null,
   constraint PK_EMAILFORNECEDOR primary key (EMAILFOR_FOR_ID, EMAILFOR_EMAIL_ID)
);

/*==============================================================*/
/* Index: INDEX_EMAILFORNECEDOR                                 */
/*==============================================================*/
create  index INDEX_EMAILFORNECEDOR on EMAILFORNECEDOR (
EMAILFOR_FOR_ID,
EMAILFOR_EMAIL_ID
);

/*==============================================================*/
/* Table: EMAILFUNCIONARIO                                      */
/*==============================================================*/
create table EMAILFUNCIONARIO (
   EMAILFUN_FUN_ID      INT4                 not null,
   EMAILFUN_EMAIL_ID    INT4                 not null,
   constraint PK_EMAILFUNCIONARIO primary key (EMAILFUN_FUN_ID, EMAILFUN_EMAIL_ID)
);

/*==============================================================*/
/* Index: INDEX_EMAILFUNCIONARIO                                */
/*==============================================================*/
create  index INDEX_EMAILFUNCIONARIO on EMAILFUNCIONARIO (
EMAILFUN_FUN_ID,
EMAILFUN_EMAIL_ID
);

/*==============================================================*/
/* Table: EMPRESA                                               */
/*==============================================================*/
create table EMPRESA (
   EMP_ID               SERIAL               not null,
   EMP_NOME             varchar(256)         not null,
   EMP_CNPJ             VARCHAR(32)          not null,
   EMP_STS              BOOL                 not null,
   constraint PK_EMPRESA primary key (EMP_ID)
);

/*==============================================================*/
/* Index: INDEX_EMPRESA                                         */
/*==============================================================*/
create  index INDEX_EMPRESA on EMPRESA (
EMP_ID,
EMP_NOME
);

/*==============================================================*/
/* Table: ENDERECO                                              */
/*==============================================================*/
create table ENDERECO (
   END_ID               SERIAL               not null,
   END_CID_ID           INT4                 null,
   END_RUA              VARCHAR(256)         not null,
   END_NUMERO           VARCHAR(64)          null,
   END_QUADRA           VARCHAR(64)          null,
   END_LOTE             VARCHAR(64)          null,
   END_BAIRRO           VARCHAR(256)         not null,
   END_CEP              VARCHAR(32)          not null,
   END_COMPLEMENTO      VARCHAR(256)         null,
   END_STS              BOOL                 not null,
   constraint PK_ENDERECO primary key (END_ID)
);

comment on table ENDERECO is
'TABELA ESPECIALIZADA DE ENDERECOS';

/*==============================================================*/
/* Index: INDEX_ENDERECO                                        */
/*==============================================================*/
create  index INDEX_ENDERECO on ENDERECO (
END_ID,
END_CID_ID
);

/*==============================================================*/
/* Index: INDEX_ENDERECO2                                       */
/*==============================================================*/
create  index INDEX_ENDERECO2 on ENDERECO (
END_ID,
END_RUA,
END_BAIRRO
);

/*==============================================================*/
/* Table: ENDERECOCLIENTE                                       */
/*==============================================================*/
create table ENDERECOCLIENTE (
   ENDCLI_CLI_ID        INT4                 not null,
   ENDCLI_END_ID        INT4                 not null,
   constraint PK_ENDERECOCLIENTE primary key (ENDCLI_CLI_ID, ENDCLI_END_ID)
);

/*==============================================================*/
/* Index: INDEX_ENDERCLIENTE                                    */
/*==============================================================*/
create  index INDEX_ENDERCLIENTE on ENDERECOCLIENTE (
ENDCLI_CLI_ID,
ENDCLI_END_ID
);

/*==============================================================*/
/* Table: ENDERECOEMPRESA                                       */
/*==============================================================*/
create table ENDERECOEMPRESA (
   ENDEMP_EMP_ID        INT4                 not null,
   ENDEMP_END_ID        INT4                 not null,
   constraint PK_ENDERECOEMPRESA primary key (ENDEMP_EMP_ID, ENDEMP_END_ID)
);

/*==============================================================*/
/* Index: INDEX_ENDEMP_ID                                       */
/*==============================================================*/
create  index INDEX_ENDEMP_ID on ENDERECOEMPRESA (
ENDEMP_EMP_ID,
ENDEMP_END_ID
);

/*==============================================================*/
/* Table: ENDERECOFILIAL                                        */
/*==============================================================*/
create table ENDERECOFILIAL (
   ENDFIL_FIL_ID        INT4                 not null,
   ENDFIL_END_ID        INT4                 not null,
   constraint PK_ENDERECOFILIAL primary key (ENDFIL_FIL_ID, ENDFIL_END_ID)
);

/*==============================================================*/
/* Index: INDEX_FIL_ID                                          */
/*==============================================================*/
create  index INDEX_FIL_ID on ENDERECOFILIAL (
ENDFIL_FIL_ID,
ENDFIL_END_ID
);

/*==============================================================*/
/* Table: ENDERECOFORNECEDOR                                    */
/*==============================================================*/
create table ENDERECOFORNECEDOR (
   ENDFOR_FOR_ID        INT4                 not null,
   ENDFOR_END_ID        INT4                 not null,
   constraint PK_ENDERECOFORNECEDOR primary key (ENDFOR_FOR_ID, ENDFOR_END_ID)
);

/*==============================================================*/
/* Index: INDEX_ENDERFORNEC                                     */
/*==============================================================*/
create  index INDEX_ENDERFORNEC on ENDERECOFORNECEDOR (
ENDFOR_FOR_ID,
ENDFOR_END_ID
);

/*==============================================================*/
/* Table: ENDERECOFUNCIONARIO                                   */
/*==============================================================*/
create table ENDERECOFUNCIONARIO (
   ENDFUN_FUN_ID        INT4                 not null,
   ENDFUN_END_ID        INT4                 not null,
   constraint PK_ENDERECOFUNCIONARIO primary key (ENDFUN_FUN_ID, ENDFUN_END_ID)
);

/*==============================================================*/
/* Index: INDEX_ENDERFUNCIONARIO                                */
/*==============================================================*/
create  index INDEX_ENDERFUNCIONARIO on ENDERECOFUNCIONARIO (
ENDFUN_FUN_ID,
ENDFUN_END_ID
);

/*==============================================================*/
/* Table: ERROSISTEMA                                           */
/*==============================================================*/
create table ERROSISTEMA (
   ERRO_ID              SERIAL               not null,
   ERRO_USR_ID          INT4                 null,
   ERRO_DATA            DATE                 not null,
   ERRO_HORA            TIME                 not null,
   ERRO_DESC            TEXT                 not null,
   constraint PK_ERROSISTEMA primary key (ERRO_ID)
);

comment on table ERROSISTEMA is
'tabela para gravar os erros gerados pelo sistema!';

/*==============================================================*/
/* Index: INDEX_ERROSISTEMA                                     */
/*==============================================================*/
create  index INDEX_ERROSISTEMA on ERROSISTEMA (
ERRO_ID,
ERRO_DATA
);

/*==============================================================*/
/* Table: FILIAL                                                */
/*==============================================================*/
create table FILIAL (
   FIL_ID               SERIAL               not null,
   FIL_EMP_ID           INT4                 null,
   FIL_NOME             varchar(256)         not null,
   FIL_CNPJ             VARCHAR(32)          not null,
   FIL_STS              BOOL                 not null,
   constraint PK_FILIAL primary key (FIL_ID)
);

/*==============================================================*/
/* Index: INDEX_FILIAL                                          */
/*==============================================================*/
create  index INDEX_FILIAL on FILIAL (
FIL_ID,
FIL_EMP_ID,
FIL_CNPJ
);

/*==============================================================*/
/* Index: INDEX_FILIAL2                                         */
/*==============================================================*/
create  index INDEX_FILIAL2 on FILIAL (
FIL_ID,
FIL_NOME
);

/*==============================================================*/
/* Table: FORNECEDOR                                            */
/*==============================================================*/
create table FORNECEDOR (
   FOR_ID               SERIAL               not null,
   FOR_FIL_ID           INT4                 null,
   FOR_NOME             varchar(256)         not null,
   FOR_DATACADASTRO     DATE                 null,
   FOR_CNPJCPF          VARCHAR(32)          not null,
   FOR_STS              BOOL                 not null,
   FOR_TIPO             CHAR(2)              not null,
   constraint PK_FORNECEDOR primary key (FOR_ID)
);

/*==============================================================*/
/* Index: INDEX_FORNECEDOR                                      */
/*==============================================================*/
create  index INDEX_FORNECEDOR on FORNECEDOR (
FOR_ID,
FOR_FIL_ID,
FOR_CNPJCPF
);

/*==============================================================*/
/* Index: INDEX_FORNECEDOR2                                     */
/*==============================================================*/
create  index INDEX_FORNECEDOR2 on FORNECEDOR (
FOR_ID,
FOR_NOME
);

/*==============================================================*/
/* Table: FUNCIONARIO                                           */
/*==============================================================*/
create table FUNCIONARIO (
   FUN_ID               SERIAL               not null,
   FUN_DEP_ID           INT4                 null,
   FUN_USR_ID           INT4                 null,
   FUN_CAR_ID           INT4                 null,
   FUN_NOME             varchar(256)         not null,
   FUN_DATAADMISSAO     DATE                 null,
   FUN_DATADEMISSAO     DATE                 null,
   FUN_COMISSAO         NUMERIC(10,2)        null,
   FUN_SALARIO          NUMERIC(10,2)        null,
   FUN_STS              BOOL                 not null,
   FUN_CTPS             VARCHAR(30)          not null,
   FUN_CPF_CNPJ         VARCHAR(30)          null,
   FUN_RG               VARCHAR(30)          null,
   FUN_FOTO             TEXT                 null,
   constraint PK_FUNCIONARIO primary key (FUN_ID)
);

/*==============================================================*/
/* Index: INDEX_FUNCIONARIO                                     */
/*==============================================================*/
create  index INDEX_FUNCIONARIO on FUNCIONARIO (
FUN_ID,
FUN_DEP_ID,
FUN_USR_ID
);

/*==============================================================*/
/* Index: INDEX_FUNCIONARIO2                                    */
/*==============================================================*/
create  index INDEX_FUNCIONARIO2 on FUNCIONARIO (
FUN_ID,
FUN_NOME
);

/*==============================================================*/
/* Table: LOG                                                   */
/*==============================================================*/
create table LOG (
   LOG_ID               SERIAL               not null,
   LOG_USR_ID           INT4                 null,
   LOG_DATA             DATE                 not null,
   LOG_HORA             TIME                 not null,
   LOG_IP               VARCHAR(25)          null,
   constraint PK_LOG primary key (LOG_ID)
);

comment on table LOG is
'tabela que inclui os acessos do usuario e o tempo que ficam logado';

/*==============================================================*/
/* Index: INDEX_LOG                                             */
/*==============================================================*/
create  index INDEX_LOG on LOG (
LOG_ID,
LOG_DATA
);

/*==============================================================*/
/* Table: MENU                                                  */
/*==============================================================*/
create table MENU (
   MENU_ID              SERIAL               not null,
   MENU_USR_ID          INT4                 null,
   MENU_NOME            VARCHAR(128)         not null,
   MENU_DESCRICAO       VARCHAR(256)         not null,
   MENU_MENU_ID         INT4                 null,
   MENU_LINK            VARCHAR(256)         not null,
   MENU_ORDEM           INT2                 not null,
   MENU_TIPO            CHAR(2)              not null,
   MENU_STS             BOOL                 not null,
   constraint PK_MENU primary key (MENU_ID)
);

comment on table MENU is
'tabela de menus do sistema';

/*==============================================================*/
/* Index: INDEX_MENU                                            */
/*==============================================================*/
create  index INDEX_MENU on MENU (
MENU_ID,
MENU_MENU_ID
);

/*==============================================================*/
/* Table: PARAMETRO                                             */
/*==============================================================*/
create table PARAMETRO (
   PARAM_ID             SERIAL               not null,
   PARAM_USR_ID         INT4                 null,
   PARAM_IMG_LOGIN      VARCHAR(256)         null,
   PARAM_IMG_INICIAL    VARCHAR(256)         null,
   PARAM_IMG_LOGO       VARCHAR(256)         null,
   PARAM_VERSAO         VARCHAR(256)         null,
   PARAM_DATA           DATE                 not null,
   constraint PK_PARAMETRO primary key (PARAM_ID)
);

comment on table PARAMETRO is
'PARAMETROS DO SISTEMA';

/*==============================================================*/
/* Index: INDEX_PARAM_ID                                        */
/*==============================================================*/
create  index INDEX_PARAM_ID on PARAMETRO (
PARAM_ID,
PARAM_DATA
);

/*==============================================================*/
/* Table: TELEFONE                                              */
/*==============================================================*/
create table TELEFONE (
   TEL_ID               SERIAL               not null,
   TEL_NUMERO           VARCHAR(20)          not null,
   TEL_TIPO             CHAR(2)              not null,
   TEL_STS              BOOL                 not null,
   TEL_RAMAL            INT4                 null,
   constraint PK_TELEFONE primary key (TEL_ID)
);

comment on table TELEFONE is
'TABELA ESPECIALIZADA DE TELEFONES';

/*==============================================================*/
/* Index: INDEX_TELEFONE                                        */
/*==============================================================*/
create  index INDEX_TELEFONE on TELEFONE (
TEL_ID,
TEL_NUMERO,
TEL_TIPO
);

/*==============================================================*/
/* Table: TELEFONECLIENTE                                       */
/*==============================================================*/
create table TELEFONECLIENTE (
   TELCLI_CLI_ID        INT4                 not null,
   TELCLI_TEL_ID        INT4                 not null,
   constraint PK_TELEFONECLIENTE primary key (TELCLI_CLI_ID, TELCLI_TEL_ID)
);

/*==============================================================*/
/* Index: INDEX_TELELEFCLIENTE                                  */
/*==============================================================*/
create  index INDEX_TELELEFCLIENTE on TELEFONECLIENTE (
TELCLI_CLI_ID,
TELCLI_TEL_ID
);

/*==============================================================*/
/* Table: TELEFONEFORNECEDOR                                    */
/*==============================================================*/
create table TELEFONEFORNECEDOR (
   TELFOR_FOR_ID        INT4                 not null,
   TELFOR_TEL_ID        INT4                 not null,
   constraint PK_TELEFONEFORNECEDOR primary key (TELFOR_FOR_ID, TELFOR_TEL_ID)
);

/*==============================================================*/
/* Index: INDEX_TELEFFORNECED                                   */
/*==============================================================*/
create  index INDEX_TELEFFORNECED on TELEFONEFORNECEDOR (
TELFOR_FOR_ID,
TELFOR_TEL_ID
);

/*==============================================================*/
/* Table: TELEFONEFUNCIONARIO                                   */
/*==============================================================*/
create table TELEFONEFUNCIONARIO (
   TELFUN_FUN_ID        INT4                 not null,
   TELFUN_TEL_ID        INT4                 not null,
   constraint PK_TELEFONEFUNCIONARIO primary key (TELFUN_FUN_ID, TELFUN_TEL_ID)
);

/*==============================================================*/
/* Index: INDEX_TELEFFUNCIONARIO                                */
/*==============================================================*/
create  index INDEX_TELEFFUNCIONARIO on TELEFONEFUNCIONARIO (
TELFUN_FUN_ID,
TELFUN_TEL_ID
);

/*==============================================================*/
/* Table: UF                                                    */
/*==============================================================*/
create table UF (
   UF_ID                SERIAL               not null,
   UF_NOME              VARCHAR(50)          not null,
   UF_SIGLA             CHAR(2)              not null,
   UF_STS               BOOL                 not null,
   constraint PK_UF primary key (UF_ID)
);

comment on table UF is
'TABELA ESPECIALIZADA DE UFS(UNIDADE FEDERATIVA)';

/*==============================================================*/
/* Index: INDEX_UF                                              */
/*==============================================================*/
create  index INDEX_UF on UF (
UF_ID,
UF_NOME
);

/*==============================================================*/
/* Index: INDEX_UF2                                             */
/*==============================================================*/
create  index INDEX_UF2 on UF (
UF_ID,
UF_SIGLA
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO (
   USR_ID               SERIAL               not null,
   USR_NOME             VARCHAR(256)         not null,
   USR_LOGIN            VARCHAR(256)         not null,
   USR_SENHA            VARCHAR(256)         not null,
   USR_STS              BOOL                 not null,
   USR_TIPO             CHAR(2)              not null,
   constraint PK_USUARIO primary key (USR_ID)
);

comment on table USUARIO is
'tabela de usuarios do sistema';

/*==============================================================*/
/* Index: INDEX_USR                                             */
/*==============================================================*/
create  index INDEX_USR on USUARIO (
USR_ID,
USR_LOGIN,
USR_SENHA
);

/*==============================================================*/
/* Index: INDEX_USR2                                            */
/*==============================================================*/
create  index INDEX_USR2 on USUARIO (
USR_ID,
USR_NOME
);

alter table ACESSO
   add constraint FK_ACESSO_USUARIO foreign key (ACESS_USR_ID)
      references USUARIO (USR_ID)
      on delete restrict on update restrict;

alter table ACESSO
   add constraint FK_ACESSO_MENU foreign key (ACESS_MENU_ID)
      references MENU (MENU_ID)
      on delete restrict on update restrict;

alter table AUDITORIA
   add constraint FK_AUDITORIA_USUARIO foreign key (AUD_USR_ID)
      references USUARIO (USR_ID)
      on delete restrict on update restrict;

alter table CIDADE
   add constraint FK_CIDADE_UF foreign key (CID_UF_ID)
      references UF (UF_ID)
      on delete restrict on update restrict;

alter table CLIENTE
   add constraint FK_CLIENTE_FILIAL foreign key (CLI_FIL_ID)
      references FILIAL (FIL_ID)
      on delete restrict on update restrict;

alter table CONTA
   add constraint FK_CONTA_FILIAL foreign key (CON_FIL_ID)
      references FILIAL (FIL_ID)
      on delete restrict on update restrict;

alter table DEPARTAMENTO
   add constraint FK_DEPARTAMENTO_FILIAL foreign key (DEP_FIL_ID)
      references FILIAL (FIL_ID)
      on delete restrict on update restrict;

alter table EMAILCLIENTE
   add constraint FK_EMAILCLI_CLIENTE foreign key (EMAILCLI_CLI_ID)
      references CLIENTE (CLI_ID)
      on delete restrict on update restrict;

alter table EMAILCLIENTE
   add constraint FK_EMAILCLI_EMAIL foreign key (EMAILCLI_EMAIL_ID)
      references EMAIL (EMAIL_ID)
      on delete restrict on update restrict;

alter table EMAILFORNECEDOR
   add constraint FK_EMAILFOR_FORNECEDOR foreign key (EMAILFOR_FOR_ID)
      references FORNECEDOR (FOR_ID)
      on delete restrict on update restrict;

alter table EMAILFORNECEDOR
   add constraint FK_EMAILFOR_EMAIL foreign key (EMAILFOR_EMAIL_ID)
      references EMAIL (EMAIL_ID)
      on delete restrict on update restrict;

alter table EMAILFUNCIONARIO
   add constraint FK_EMAILFUN_FUNCIONARIO foreign key (EMAILFUN_FUN_ID)
      references FUNCIONARIO (FUN_ID)
      on delete restrict on update restrict;

alter table EMAILFUNCIONARIO
   add constraint FK_EMAILFUN_EMAIL foreign key (EMAILFUN_EMAIL_ID)
      references EMAIL (EMAIL_ID)
      on delete restrict on update restrict;

alter table ENDERECO
   add constraint FK_ENDERECO_CIDADE foreign key (END_CID_ID)
      references CIDADE (CID_ID)
      on delete restrict on update restrict;

alter table ENDERECOCLIENTE
   add constraint FK_ENDERECOCLI_CLIENTE foreign key (ENDCLI_CLI_ID)
      references CLIENTE (CLI_ID)
      on delete restrict on update restrict;

alter table ENDERECOCLIENTE
   add constraint FK_ENDERECOCLI_ENDERECO foreign key (ENDCLI_END_ID)
      references ENDERECO (END_ID)
      on delete restrict on update restrict;

alter table ENDERECOEMPRESA
   add constraint FK_ENDERECOEMP_EMPRESA foreign key (ENDEMP_EMP_ID)
      references EMPRESA (EMP_ID)
      on delete restrict on update restrict;

alter table ENDERECOEMPRESA
   add constraint FK_ENDERECOEMP_ENDERECO foreign key (ENDEMP_END_ID)
      references ENDERECO (END_ID)
      on delete restrict on update restrict;

alter table ENDERECOFILIAL
   add constraint FK_ENDERECOFIL_FILIAL foreign key (ENDFIL_FIL_ID)
      references FILIAL (FIL_ID)
      on delete restrict on update restrict;

alter table ENDERECOFILIAL
   add constraint FK_ENDERECOFIL_ENDERECO foreign key (ENDFIL_END_ID)
      references ENDERECO (END_ID)
      on delete restrict on update restrict;

alter table ENDERECOFORNECEDOR
   add constraint FK_ENDERECOFOR_FORNECEDOR foreign key (ENDFOR_FOR_ID)
      references FORNECEDOR (FOR_ID)
      on delete restrict on update restrict;

alter table ENDERECOFORNECEDOR
   add constraint FK_ENDERECOFOR_ENDERECO foreign key (ENDFOR_END_ID)
      references ENDERECO (END_ID)
      on delete restrict on update restrict;

alter table ENDERECOFUNCIONARIO
   add constraint FK_ENDERECOFUN_FUNCIONARIO foreign key (ENDFUN_FUN_ID)
      references FUNCIONARIO (FUN_ID)
      on delete restrict on update restrict;

alter table ENDERECOFUNCIONARIO
   add constraint FK_ENDERECOFUN_ENDERECO foreign key (ENDFUN_END_ID)
      references ENDERECO (END_ID)
      on delete restrict on update restrict;

alter table ERROSISTEMA
   add constraint FK_ERROSISTEMA_USUARIO foreign key (ERRO_USR_ID)
      references USUARIO (USR_ID)
      on delete restrict on update restrict;

alter table FILIAL
   add constraint FK_FILIAL_EMPRESA foreign key (FIL_EMP_ID)
      references EMPRESA (EMP_ID)
      on delete restrict on update restrict;

alter table FORNECEDOR
   add constraint FK_FORNECEDOR_FILIAL foreign key (FOR_FIL_ID)
      references FILIAL (FIL_ID)
      on delete restrict on update restrict;

alter table FUNCIONARIO
   add constraint FK_FUNCIONARIO_USUARIO foreign key (FUN_USR_ID)
      references USUARIO (USR_ID)
      on delete restrict on update restrict;

alter table FUNCIONARIO
   add constraint FK_FUNCIONARIO_CARGO foreign key (FUN_CAR_ID)
      references CARGO (CAR_ID)
      on delete restrict on update restrict;

alter table FUNCIONARIO
   add constraint FK_FUNCIONARIO_DEPARTAMENTO foreign key (FUN_DEP_ID)
      references DEPARTAMENTO (DEP_ID)
      on delete restrict on update restrict;

alter table LOG
   add constraint FK_LOG_USUARIO foreign key (LOG_USR_ID)
      references USUARIO (USR_ID)
      on delete restrict on update restrict;

alter table MENU
   add constraint FK_MENU_USUARIO foreign key (MENU_USR_ID)
      references USUARIO (USR_ID)
      on delete restrict on update restrict;

alter table PARAMETRO
   add constraint FK_PARAMETRO_USUARIO foreign key (PARAM_USR_ID)
      references USUARIO (USR_ID)
      on delete restrict on update restrict;

alter table TELEFONECLIENTE
   add constraint FK_TELEFONECLI_CLIENTE foreign key (TELCLI_CLI_ID)
      references CLIENTE (CLI_ID)
      on delete restrict on update restrict;

alter table TELEFONECLIENTE
   add constraint FK_TELEFONECLI_TELEFONE foreign key (TELCLI_TEL_ID)
      references TELEFONE (TEL_ID)
      on delete restrict on update restrict;

alter table TELEFONEFORNECEDOR
   add constraint FK_TELEFONEFOR_FORNECEDOR foreign key (TELFOR_FOR_ID)
      references FORNECEDOR (FOR_ID)
      on delete restrict on update restrict;

alter table TELEFONEFORNECEDOR
   add constraint FK_TELEFONEFOR_TELEFONE foreign key (TELFOR_TEL_ID)
      references TELEFONE (TEL_ID)
      on delete restrict on update restrict;

alter table TELEFONEFUNCIONARIO
   add constraint FK_TELEFONEFUN_FUNCIONARIO foreign key (TELFUN_FUN_ID)
      references FUNCIONARIO (FUN_ID)
      on delete restrict on update restrict;

alter table TELEFONEFUNCIONARIO
   add constraint FK_TELEFONEFUN_TELEFONE foreign key (TELFUN_TEL_ID)
      references TELEFONE (TEL_ID)
      on delete restrict on update restrict;

