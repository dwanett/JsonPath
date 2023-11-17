grammar JsonPath;

jsonPath : jsonPathElement EOF;

jsonPathElement
: ((NAME | STRING) | (NAME | STRING) (filter | INDEXARRAY) | (NAME | STRING) filter INDEXARRAY) (DOT (jsonPathElement | FUNCTION))?;

filter : '[' MATCHTYPE? '(' condition ')]';

//condition :  expr | expr LOGICEXPR condition | '{' condition '}' (LOGICEXPR condition)?;

//condition :  expr (LOGICEXPR expr)* | (expr LOGICEXPR)? '{' condition '}' (LOGICEXPR (expr (LOGICEXPR condition)?))?;

condition :  expr (LOGICEXPR expr)* | ((expr | priority) LOGICEXPR)* priority (LOGICEXPR (expr | priority))*;

priority : '{' condition '}';

//condition :  expr | expr LOGICEXPR expr (LOGICEXPR expr)* | (expr LOGICEXPR)* '{' condition '}' (LOGICEXPR condition)*;

expr
    : jsonPathElement COMPARETYPE 'null'
    | jsonPathElement COMPARETYPE 'empty'
    | jsonPathElement (COMPARETYPE | COMPARETYPENOTSTRICT) (DIGIT | FLOAT)
    | jsonPathElement COMPARETYPE STRING
    | jsonPathElement COMPARETYPE FUNCTIONFORCOMPARE
    | jsonPathElement COMPARETYPE BACK+ jsonPathElement
    | jsonPathElement
    ;


STRING: '"' (ESC|.)*? '"' ;
fragment
ESC : '\\"' | '\\\\' ;

FUNCTION : SORT | SIZE;

FUNCTIONFORCOMPARE : REG | CONTAINS;

INDEXARRAY : '[' (DIGIT | ALLINDEX) ']';

MATCHTYPE : ALLMATCH | NONMATCH;

FLOAT : DIGIT '.' DIGIT;

COMPARETYPE : EQUALS | NOT_EQUALS;

COMPARETYPENOTSTRICT : LESS | GREATER | LESS_OR_EQUALS | GREATER_OR_EQUALS;

LOGICEXPR : AND | OR;

DIGIT : [0-9]+;

NAME : [a-zA-Z0-9_,]+;

ALLINDEX : '~';

DOT : '.';

BACK : '../';

NONMATCH : '!';

ALLMATCH : '*';

AND : '&&';

OR : '||';

EQUALS : '==';

NOT_EQUALS : '!=';

LESS : '<';

LESS_OR_EQUALS : '<=';

GREATER : '>';

GREATER_OR_EQUALS : '>=';

SORT : 'sort()';

SIZE : 'size()';

REG : 'reg(' STRING ')';

CONTAINS : 'contains(' STRING ')';

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines