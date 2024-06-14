grammar JsonPath;

jsonPath : jsonPathElement EOF;

jsonPathElement
: (NAME | STRING | NO_NAME) filter? INDEXARRAY? (DOT (jsonPathElement | FUNCTION))?;

filter : '[' MATCHTYPE? '(' condition ')]';

condition :  expr (LOGICEXPR expr)* | ((expr | priority) LOGICEXPR)* priority (LOGICEXPR (expr | priority))*;

priority : '{' condition '}';

expr
    : jsonPathElement COMPARETYPE 'null'
    | jsonPathElement COMPARETYPE 'empty'
    | jsonPathElement (COMPARETYPE | COMPARETYPENOTSTRICT) (DIGIT | FLOAT)
    | jsonPathElement COMPARETYPE STRING
    | jsonPathElement COMPARETYPE FUNCTIONFORCOMPARE
    | jsonPathElement COMPARETYPE BACK+ jsonPathElement
    | NOT? FUNCTIONFORCOMPARE
    | NOT? jsonPathElement
    ;


STRING: '"' (ESC|.)*? '"' ;
fragment
ESC : '\\"' | '\\\\' ;

FUNCTION : SORT | SIZE | DISTINCT | NAMEATTR;

FUNCTIONFORCOMPARE : REG | CONTAINS;

INDEXARRAY : '[' (DIGIT | ALLINDEX | INDEXRANGE) ']';

MATCHTYPE : ALLMATCH | NONMATCH;

FLOAT : DIGIT '.' DIGIT;

COMPARETYPE : EQUALS | NOT_EQUALS;

COMPARETYPENOTSTRICT : LESS | GREATER | LESS_OR_EQUALS | GREATER_OR_EQUALS;

LOGICEXPR : AND | OR;

INDEXRANGE : DIGIT ',' DIGIT;

DIGIT : [0-9]+;

NAME : [a-zA-Z0-9_,]+;

NO_NAME : '*';

ALLINDEX : '~';

NOT : '!';

DOT : '.';

BACK : '../';

NONMATCH : 'nonMatch';

ALLMATCH : 'allMatch';

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

DISTINCT : 'distinct()';

NAMEATTR : 'name()';

REG : 'reg(' STRING ')';

CONTAINS : 'contains(' STRING ')';

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines