
package Enums;


public enum Status {
        AVAILABLE,
        BORROWED;
        
        public static Status CheckStatus(boolean value) {
        return value ? AVAILABLE : BORROWED;
        }
}
