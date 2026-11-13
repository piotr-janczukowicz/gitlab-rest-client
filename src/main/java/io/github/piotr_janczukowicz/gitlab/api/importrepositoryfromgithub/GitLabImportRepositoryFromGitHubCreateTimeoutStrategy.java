package io.github.piotr_janczukowicz.gitlab.api.importrepositoryfromgithub;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab import repository from git hub create timeout strategy. */
@CatalogSchema("operations/postApiV4ImportGithub/requestBody/properties/timeout_strategy")
public enum GitLabImportRepositoryFromGitHubCreateTimeoutStrategy {
    OPTIMISTIC("optimistic"),
    PESSIMISTIC("pessimistic");

    private static final EnumUtils.WireIndex<GitLabImportRepositoryFromGitHubCreateTimeoutStrategy> WIRE_INDEX =
            EnumUtils.index(
                    GitLabImportRepositoryFromGitHubCreateTimeoutStrategy.class,
                    GitLabImportRepositoryFromGitHubCreateTimeoutStrategy::wireValue);

    private final String wireValue;

    GitLabImportRepositoryFromGitHubCreateTimeoutStrategy(final String wireValue) {
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
    public static GitLabImportRepositoryFromGitHubCreateTimeoutStrategy fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
