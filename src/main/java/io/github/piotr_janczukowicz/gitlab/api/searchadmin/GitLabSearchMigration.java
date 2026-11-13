package io.github.piotr_janczukowicz.gitlab.api.searchadmin;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab search migration.
 *
 * @param version the version
 * @param name the name
 * @param startedAt the started at
 * @param completedAt the completed at
 * @param completed the completed
 * @param obsolete the obsolete
 * @param migrationState the migration state
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesSearchMigration")
public record GitLabSearchMigration(
        @Nullable Integer version,
        @Nullable String name,
        @Nullable Instant startedAt,
        @Nullable Instant completedAt,
        @Nullable Boolean completed,
        @Nullable Boolean obsolete,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> migrationState) {}
