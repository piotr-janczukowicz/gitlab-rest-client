package io.github.piotr_janczukowicz.gitlab.api.softwarecompositionanalysis;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;

/** Request body of the operation {@code postApiV4JobsIdSbomScansSbomDigest}. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4JobsIdSbomScansSbomDigest/requestBody")
public record GitLabSoftwareCompositionAnalysisCreateBySbomDigestPayload() {}
