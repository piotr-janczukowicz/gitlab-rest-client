package io.github.piotr_janczukowicz.gitlab.api.remotemirrors;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab mirror host key.
 *
 * @param fingerprintSha256 the fingerprint sha256
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMirrorHostKey")
public record GitLabMirrorHostKey(@Nullable String fingerprintSha256) {}
