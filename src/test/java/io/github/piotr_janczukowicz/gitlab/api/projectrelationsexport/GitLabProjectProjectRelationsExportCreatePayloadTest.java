package io.github.piotr_janczukowicz.gitlab.api.projectrelationsexport;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectRelationsExportCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBatchedIsNullable() {
        final GitLabProjectProjectRelationsExportCreatePayloadBuilder builder =
                GitLabProjectProjectRelationsExportCreatePayloadBuilder.builder(
                                ProjectrelationsexportCatalogFixtures.projectProjectRelationsExportCreatePayload())
                        .batched(null);

        final GitLabProjectProjectRelationsExportCreatePayload built = builder.build();

        assertThat(built.batched()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectRelationsExportCreatePayload value =
                ProjectrelationsexportCatalogFixtures.projectProjectRelationsExportCreatePayload();

        assertThat(value.batched()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectRelationsExportCreatePayload original =
                ProjectrelationsexportCatalogFixtures.projectProjectRelationsExportCreatePayload();

        final GitLabProjectProjectRelationsExportCreatePayload rebuilt =
                GitLabProjectProjectRelationsExportCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectRelationsExportCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("batched");
    }
}
