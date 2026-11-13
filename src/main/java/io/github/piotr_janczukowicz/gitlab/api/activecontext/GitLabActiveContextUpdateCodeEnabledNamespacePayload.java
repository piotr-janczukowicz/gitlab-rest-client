package io.github.piotr_janczukowicz.gitlab.api.activecontext;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.CatalogSimpleXor;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4AdminActiveContextCodeEnabledNamespaces}.
 *
 * @param namespaceId the namespace id
 * @param state the state
 * @param connectionId the connection id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4AdminActiveContextCodeEnabledNamespaces/requestBody")
public record GitLabActiveContextUpdateCodeEnabledNamespacePayload(
        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_STRING_INTEGER)
        String namespaceId,

        GitLabActiveContextUpdateCodeEnabledNamespaceState state,
        @Nullable Long connectionId) {
    public GitLabActiveContextUpdateCodeEnabledNamespacePayload {
        requireNonNull(state, "state");
    }
}
