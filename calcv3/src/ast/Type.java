package ast;

public enum Type {
    INT{
        public String toString() {
            return "int";
        }
    },
    BOOL{
        public String toString() {
            return "bool";
        }
    };
}
