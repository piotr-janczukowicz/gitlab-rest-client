package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.CatalogSimpleXor;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4FeaturesName}.
 *
 * @param value the value
 * @param key the key
 * @param featureGroup the feature group
 * @param user the user
 * @param group the group
 * @param namespace the namespace
 * @param project the project
 * @param organization the organization
 * @param repository the repository
 * @param runner the runner
 * @param endpoint the endpoint
 * @param force the force
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4FeaturesName/requestBody")
public record GitLabInstanceFeatureFlagsCreatePayload(
        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_STRING_INTEGER)
        String value,

        @Nullable GitLabInstanceFeatureFlagsCreateKey key,
        @Nullable String featureGroup,
        @Nullable String user,
        @Nullable String group,
        @Nullable String namespace,
        @Nullable String project,
        @Nullable String organization,
        @Nullable String repository,
        @Nullable String runner,
        @Nullable String endpoint,
        @Nullable Boolean force) {}
