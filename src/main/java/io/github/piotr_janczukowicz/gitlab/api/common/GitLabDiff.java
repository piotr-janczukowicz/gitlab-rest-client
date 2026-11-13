package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab diff.
 *
 * @param diff the diff
 * @param collapsed the collapsed
 * @param tooLarge the too large
 * @param newPath the new path
 * @param oldPath the old path
 * @param aMode the a mode
 * @param bMode the b mode
 * @param newFile the new file
 * @param renamedFile the renamed file
 * @param deletedFile the deleted file
 * @param generatedFile the generated file
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesDiff")
public record GitLabDiff(
        @Nullable String diff,
        @Nullable Boolean collapsed,
        @Nullable Boolean tooLarge,
        @Nullable String newPath,
        @Nullable String oldPath,
        @Nullable String aMode,
        @Nullable String bMode,
        @Nullable Boolean newFile,
        @Nullable Boolean renamedFile,
        @Nullable Boolean deletedFile,
        @Nullable Boolean generatedFile) {}
