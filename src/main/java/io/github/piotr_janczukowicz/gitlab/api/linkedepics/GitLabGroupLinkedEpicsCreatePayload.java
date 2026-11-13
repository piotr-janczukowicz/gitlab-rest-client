package io.github.piotr_janczukowicz.gitlab.api.linkedepics;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4GroupsIdEpicsEpicIidRelatedEpics}.
 *
 * @param targetGroupId the target group id
 * @param targetEpicIid the target epic iid
 * @param linkType the link type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GroupsIdEpicsEpicIidRelatedEpics/requestBody")
public record GitLabGroupLinkedEpicsCreatePayload(
        @Nullable String targetGroupId,
        @Nullable Long targetEpicIid,
        @Nullable GitLabGroupLinkedEpicsCreateLinkType linkType) {}
