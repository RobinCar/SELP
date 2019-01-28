grammar Calc;

// syntactic rules

program  : funcDef* body
         ;
funcDef  : '(' 'defun' head body ')'
         ;
head     : '(' functionId variableId* ')'
         ;
body     : varDef* expression
         ;
varDef   : '(' '=' variableId expression ')'
         ;
expression : LITERAL                                            #Literal
           | '(' expression ')'                                 #ParenExpression
           | variableId                                         #Variable
           | (MINUS | NOT) expression                           #UnaryMinus
           | expression (OP | MINUS) expression                 #BinaryExpression
           | expression '?' expression ':' expression           #ConditionalExpression
           | functionId expression*                             #FunctionCall
           ;
variableId : IDENTIFIER
           ;
functionId : IDENTIFIER
           ;

// lexical rules

MINUS    : '-'
         ;
NOT      : '!'
         ;
OP       : '+' | '*' | '/' | '==' | '<'
         ;
IDENTIFIER : ('a'..'z')('a'..'z' | '0'..'9')*
         ;
LITERAL  : '0' | ('1'..'9')('0'..'9')*              
         ;
WS : [ \t\n\r]+ -> channel(HIDDEN) ;
LINE_COMMENT : '//' ~'\n'* '\n' -> channel(HIDDEN) ;