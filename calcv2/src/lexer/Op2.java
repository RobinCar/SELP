package lexer;

import parser.SyntaxError;

import java.io.IOException;

public enum Op2 implements Token {
    PLUS {
        @Override
        public String toString() {
            return "PLUS";
        }
    },

    MINUS {
        @Override
        public String toString() {
            return "MINUS";
        }
    },

    TIMES {
        @Override
        public String toString() {
            return "TIMES";
        }
    },

    DIVIDE {
        @Override
        public String toString() {
            return "DIVIDE";
        }
    },

    EQUAL {
        @Override
        public String toString() {
            return "EQUAL";
        }
    },

    LESS {
        @Override
        public String toString() {
            return "LESS";
        }
    };

    public static Op2 parseOp(String op) throws IOException {
        switch (op) {
            case "+" : return Op2.PLUS;
            case "-" : return Op2.MINUS;
            case "*" : return Op2.TIMES;
            case "/" : return Op2.DIVIDE;
            case "=" : return Op2.EQUAL;
            case "<" : return Op2.LESS;
            default : throw  new SyntaxError("Can't find Symbol");
        }
    }
}
