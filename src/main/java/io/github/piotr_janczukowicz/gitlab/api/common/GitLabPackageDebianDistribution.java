package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab package debian distribution.
 *
 * @param id the id
 * @param codename the codename
 * @param suite the suite
 * @param origin the origin
 * @param label the label
 * @param version the version
 * @param description the description
 * @param validTimeDurationSeconds the valid time duration seconds
 * @param components the components
 * @param architectures the architectures
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesPackagesDebianDistribution")
public record GitLabPackageDebianDistribution(
        @Nullable Long id,
        @Nullable String codename,
        @Nullable String suite,
        @Nullable String origin,
        @Nullable String label,
        @Nullable String version,
        @Nullable String description,
        @Nullable Integer validTimeDurationSeconds,
        @Nullable List<String> components,
        @Nullable List<String> architectures) {}
