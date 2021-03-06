grammar Enquanto;

programa : seqComando;     // sequência de comandos


seqComando: comando (';' comando?)* ;


comando: ID ':=' expressao                          # atribuicao
       | 'skip'                                     # skip
       | 'se' bool 'entao' comando
             ( 'senaose' bool 'entao' comando )?
             'senao' comando  # se
       | 'enquanto' bool 'faca' comando             # enquanto
       | 'para' ID 'de' expressao 'ate' expressao
             ( 'passo' expressao )? 'faca' comando  # para
       | 'quebrar' (INT)?                           # quebrar
       | 'escolha' expressao
             ( 'caso' expressao ':' comando )*
             ('outro' ':' comando )?                # escolha
       | 'exiba' Texto                              # exiba
       | 'escreva' expressao                        # escreva
       | '{' seqComando '}'                         # bloco
       ;

expressao: INT                                      # inteiro
         | 'leia'                                   # leia
         | ID                                       # id
         | expressao '*' expressao                  # opBin
         | expressao '+' expressao                  # opBin
         | expressao '-' expressao                  # opBin
         | expressao '/' expressao                  # opBin
         | <assoc=right> expressao '^' expressao    # opBin
         | '(' expressao ')'                        # expPar
         ;

bool: ('verdadeiro'|'falso')                        # booleano
    | expressao '=' expressao                       # opRel
    | expressao '<=' expressao                      # opRel
    | expressao '>=' expressao                      # opRel
    | expressao '<>' expressao                      # opRel
    | 'nao' bool                                    # naoLogico
    |  bool'ou' bool                                # ouLogico
    |  bool'xor' bool                               # xorLogico
    |  bool 'e' bool                                # eLogico
    | '(' bool ')'                                  # boolPar
    ;

INT: '-'?('0'..'9')+ ;
ID: ('a'..'z')+;
Texto: '"' .*? '"';

Espaco: [ \t\n\r] -> skip;
