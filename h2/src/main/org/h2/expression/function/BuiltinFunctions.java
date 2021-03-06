/*
 * Copyright 2004-2020 H2 Group. Multiple-Licensed under the MPL 2.0,
 * and the EPL 1.0 (https://h2database.com/html/license.html).
 * Initial Developer: H2 Group
 */
package org.h2.expression.function;

import java.util.HashSet;

import org.h2.engine.Database;

/**
 * Maintains the list of built-in functions.
 */
public final class BuiltinFunctions {

    private static final HashSet<String> FUNCTIONS;

    static {
        String[] names = { //
                // MathFunction
                "ABS", "MOD", "FLOOR", "CEIL", "ROUND", "ROUNDMAGIC", "SIGN", "TRUNC", "TRUNCATE",
                // MathFunction1
                "SIN", "COS", "TAN", "COT", "SINH", "COSH", "TANH", "ASIN", "ACOS", "ATAN", //
                "LOG10", "LN", "EXP", "SQRT", "DEGREES", "RADIANS",
                // MathFunction2
                "ATAN2", "LOG", "POWER",
                // BitFunction
                "BITAND", "BITOR", "BITXOR", "BITNOT", "BITGET", "LSHIFT", "RSHIFT",
                // DateTimeFunction
                "EXTRACT", "DATE_TRUNC", "DATEADD", "DATEDIFF", //
                "TIMESTAMPADD", "TIMESTAMPDIFF",
                // DateTimeFormatFunction
                "FORMATDATETIME", "PARSEDATETIME",
                // DayMonthNameFunction
                "DAYNAME", "MONTHNAME",
                // CardinalityExpression
                "CARDINALITY", "ARRAY_MAX_CARDINALITY",
                // StringFunction1
                "UPPER", "LOWER", "ASCII", "CHAR", "CHR", "STRINGENCODE", "STRINGDECODE", "STRINGTOUTF8",
                "UTF8TOSTRING", "HEXTORAW", "RAWTOHEX", "SPACE", "QUOTE_IDENT",
                // LengthFunction
                "CHAR_LENGTH", "CHARACTER_LENGTH", "LENGTH", "OCTET_LENGTH", "BIT_LENGTH", //
                // CompressFunction
                "COMPRESS", "EXPAND",
                // SoundexFunction
                "SOUNDEX", "DIFFERENCE",
                // JsonConstructorFunction
                "JSON_OBJECT", "JSON_ARRAY",
                // CryptFunction
                "ENCRYPT", "DECRYPT",
                // CoalesceFunction
                "COALESCE", "GREATEST", "LEAST",
                // NullIfFunction
                "NULLIF",
                // ConcatFunction
                "CONCAT", "CONCAT_WS",
                // HashFunction
                "HASH", "ORA_HASH",
                // RandFunction
                "RAND", "RANDOM", "SECURE_RAND", "RANDOM_UUID", "UUID",
                // SessionControlFunction
                "ABORT_SESSION", "CANCEL_SESSION",
                // SysInfoFunction
                "AUTOCOMMIT", "DATABASE_PATH", "H2VERSION", "LOCK_MODE", "LOCK_TIMEOUT", "MEMORY_FREE", "MEMORY_USED",
                "READONLY", "SESSION_ID", "TRANSACTION_ID",
                // TableInfoFunction
                "DISK_SPACE_USED", "ESTIMATED_ENVELOPE",
                // FileFunction
                "FILE_READ", "FILE_WRITE",
                // DataTypeSQLFunction
                "DATA_TYPE_SQL",
                // DBObjectFunction
                "DB_OBJECT_ID", "DB_OBJECT_SQL",
                // CompatibilitySequenceValueFunction
                "CURRVAL", "NEXTVAL",
                // Constants
                "ZERO", "PI",
                //
        };
        HashSet<String> set = new HashSet<>(128);
        for (String n : names) {
            set.add(n);
        }
        FUNCTIONS = set;
    }

    /**
     * Returns whether specified function is a non-keyword built-in function.
     *
     * @param database
     *            the database
     * @param upperName
     *            the name of the function in upper case
     * @return {@code true} if it is
     */
    public static boolean isBuiltinFunction(Database database, String upperName) {
        return FUNCTIONS.contains(upperName) || Function.getFunction(database, upperName) != null;
    }

    private BuiltinFunctions() {
    }

}
