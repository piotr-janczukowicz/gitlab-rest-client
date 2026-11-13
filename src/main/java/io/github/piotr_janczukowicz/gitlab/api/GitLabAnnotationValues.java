package io.github.piotr_janczukowicz.gitlab.api;

/** Values that generated annotations share. */
public final class GitLabAnnotationValues {

    /** The reason of the suppression for a free-form object, which the schema comparator reads as a bare object. */
    public static final String BARE_OBJECT = "dump is a bare object with no properties";

    /** The union kinds {@code integer|string}. */
    public static final String XOR_INTEGER_STRING = "integer|string";

    /** The union kinds {@code string|array}. */
    public static final String XOR_STRING_ARRAY = "string|array";

    /** The union kinds {@code string|integer}. */
    public static final String XOR_STRING_INTEGER = "string|integer";

    /** The union kinds {@code string|string}. */
    public static final String XOR_STRING_STRING = "string|string";

    private GitLabAnnotationValues() {
        throw new UnsupportedOperationException("GitLabAnnotationValues");
    }
}
