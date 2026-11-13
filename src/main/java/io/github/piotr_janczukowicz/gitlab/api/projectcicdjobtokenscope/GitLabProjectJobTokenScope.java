package io.github.piotr_janczukowicz.gitlab.api.projectcicdjobtokenscope;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project job token scope.
 *
 * @param inboundEnabled the inbound enabled
 * @param outboundEnabled the outbound enabled
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProjectJobTokenScope")
public record GitLabProjectJobTokenScope(
        @Nullable Boolean inboundEnabled, @Nullable Boolean outboundEnabled) {}
