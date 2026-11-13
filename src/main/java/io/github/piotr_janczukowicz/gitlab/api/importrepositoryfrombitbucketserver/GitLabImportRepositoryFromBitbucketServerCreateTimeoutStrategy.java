package io.github.piotr_janczukowicz.gitlab.api.importrepositoryfrombitbucketserver;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab import repository from bitbucket server create timeout strategy. */
@CatalogSchema("operations/postApiV4ImportBitbucketServer/requestBody/properties/timeout_strategy")
public enum GitLabImportRepositoryFromBitbucketServerCreateTimeoutStrategy {
    OPTIMISTIC("optimistic"),
    PESSIMISTIC("pessimistic");

    private static final EnumUtils.WireIndex<GitLabImportRepositoryFromBitbucketServerCreateTimeoutStrategy>
            WIRE_INDEX = EnumUtils.index(
                    GitLabImportRepositoryFromBitbucketServerCreateTimeoutStrategy.class,
                    GitLabImportRepositoryFromBitbucketServerCreateTimeoutStrategy::wireValue);

    private final String wireValue;

    GitLabImportRepositoryFromBitbucketServerCreateTimeoutStrategy(final String wireValue) {
        this.wireValue = wireValue;
    }

    /**
     * Value GitLab sends and expects in JSON.
     *
     * @return wire value
     */
    @JsonValue
    public String wireValue() {
        return wireValue;
    }

    /**
     * Resolves the constant from its wire value.
     *
     * @param value JSON value
     * @return matching constant
     * @throws NullPointerException if {@code value} is {@code null}
     * @throws IllegalArgumentException if {@code value} is not a known value
     */
    @JsonCreator
    public static GitLabImportRepositoryFromBitbucketServerCreateTimeoutStrategy fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
